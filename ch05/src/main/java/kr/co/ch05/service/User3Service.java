package kr.co.ch05.service;

import kr.co.ch05.dto.User3DTO;
import kr.co.ch05.mapper.User3Mapper;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class User3Service {

    private final User3Mapper mapper;

    public void register(User3DTO user3DTO) {
        mapper.insert3DTO(user3DTO);
    };
    public List<User3DTO> findAll(){
        return mapper.selectAll3DTO();
    };
    public User3DTO findById(String userId){
        return mapper.select3DTO(userId);
    };
    public void modify(User3DTO user3DTO){
        mapper.update3DTO(user3DTO);
    };
    public void remove(String userId){
        mapper.delete3DTO(userId);
    };
}
