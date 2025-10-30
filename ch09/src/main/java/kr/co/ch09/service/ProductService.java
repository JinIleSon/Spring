package kr.co.ch09.service;


import kr.co.ch09.dto.PageRequestDTO;
import kr.co.ch09.dto.PageResponseDTO;
import kr.co.ch09.dto.ProductDTO;
import kr.co.ch09.entity.Product;
import kr.co.ch09.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public int register(ProductDTO productDTO){

        Product product = productDTO.toEntity();
        Product savedProduct = productRepository.save(product);

        return savedProduct.getPno();
    }

    public PageResponseDTO<ProductDTO> list(PageRequestDTO pageRequestDTO) {
        log.info("pageRequestDTO : " + pageRequestDTO);

        Pageable pageable = PageRequest.of(
                pageRequestDTO.getPg() - 1,  // 1페이지가 0이므로 주의
                pageRequestDTO.getSize(),
                Sort.by("pno").descending());

        Page<Product> productPage = productRepository.findByCategory(pageRequestDTO.getCategory(), pageable);

        List<ProductDTO> dtoList = productPage.getContent().stream()
                .map(Product::toDTO)
                .toList();

        int total = (int) productPage.getTotalElements();

        return PageResponseDTO.<ProductDTO>builder()
                .dtoList(dtoList)
                .pageRequestDTO(pageRequestDTO)
                .total(total)
                .build();
    }


	/*
		application.yml 파일 upload 경로 및 업로드 파일 크기 설정
		
		spring:
			servlet:
				multipart:
					max-file-size: 10MB
		
		file:
			upload:
				path: uploads
	*/

    @Value("${file.upload.path}")
    private String uploadPath; // yml: file.upload.path=uploads (상대경로면 더 주의)

    public Map<String, String> saveFiles(List<MultipartFile> files) {
        if (files == null || files.isEmpty()) return null;

        Map<String, String> uploadNames = new HashMap<>();

        // ① 업로드 폴더 생성 보장
        Path uploadDir = Paths.get(uploadPath);
        try {
            Files.createDirectories(uploadDir);
            log.info("uploadDir = {}", uploadDir.toAbsolutePath());
        } catch (IOException e) {
            log.error("업로드 폴더 생성 실패: {}", uploadDir.toAbsolutePath(), e);
            throw new RuntimeException("업로드 폴더 생성 실패", e);
        }

        for (MultipartFile mf : files) {
            String fieldName = mf.getName();
            String original = mf.getOriginalFilename();
            if (original == null || original.isBlank()) continue;

            String ext = "";
            int dot = original.lastIndexOf('.');
            if (dot >= 0) ext = original.substring(dot);

            String savedName = UUID.randomUUID() + ext;
            Path savePath = uploadDir.resolve(savedName); // OS 독립적 결합

            try {
                Files.copy(mf.getInputStream(), savePath); // 필요시 REPLACE_EXISTING 옵션
                uploadNames.put(fieldName, savedName);
                log.info("saved -> {}", savePath.toAbsolutePath());
            } catch (IOException e) {
                log.error("파일 저장 실패: {}", savePath.toAbsolutePath(), e);
                throw new RuntimeException("파일 저장 실패", e);
            }
        }
        return uploadNames;
    }

    public Resource getProductImage(String imageName) {
        Path path = Paths.get(uploadPath).resolve(imageName);
        return new FileSystemResource(path);
    }





}