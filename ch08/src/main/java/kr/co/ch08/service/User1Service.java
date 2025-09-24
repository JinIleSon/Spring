package kr.co.ch08.service;

import kr.co.ch08.dto.User1DTO;
import kr.co.ch08.entity.User1;
import kr.co.ch08.repository.User1Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class User1Service {

    private final User1Repository user1Repository;

    public void save(User1DTO user1DTO){
        user1Repository.save(user1DTO.toEntity());
    }
    public User1DTO getUser(String userId){

        Optional<User1> optUser1 = user1Repository.findById(userId);
        if(optUser1.isPresent()){
            return optUser1.get().toDTO();
        }
        return null;
    }
    public List<User1DTO> getUserAll(){
        List<User1> list = user1Repository.findAll();

        return list.stream().map(entity -> entity.toDTO()).collect(Collectors.toList());
    }
    public void modify(User1DTO user1DTO){
        if(user1Repository.existsById(user1DTO.getUserId())){
            user1Repository.save(user1DTO.toEntity());
        }
    }
    public void remove(String userId){
        user1Repository.deleteById(userId);
    }
}
