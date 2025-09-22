package kr.co.ch06.Service;

import kr.co.ch06.DTO.User3DTO;
import kr.co.ch06.entity.User3;
import kr.co.ch06.repository.User3Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class User3Service {

    private final User3Repository user3Repository;

    public void save(User3DTO user3DTO) {
        User3 user3 = user3DTO.toEntity();
        user3Repository.save(user3);
    }

    public User3DTO getUser(String userId){
        Optional<User3> optUser3 = user3Repository.findById(userId);

        if (optUser3.isPresent()){
            User3 user3 = optUser3.get();
            return  user3.toDTO();
        }
        return null;
    }

    public List<User3DTO> getUsers(){
        List<User3> list = user3Repository.findAll();

        List<User3DTO> dtoList = list.stream()
                .map(entity -> entity.toDTO())
                .collect(Collectors.toList());

        return dtoList;
    }

    public void modify(User3DTO user3DTO){
        if (user3Repository.existsById(user3DTO.getUserId())) {
            user3Repository.save(user3DTO.toEntity());
        }
    }

    public void delete(String userId){
        user3Repository.deleteById(userId);
    }
}
