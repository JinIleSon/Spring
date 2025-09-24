package kr.co.ch08.service;

import kr.co.ch08.dto.User1DTO;
import kr.co.ch08.dto.User2DTO;
import kr.co.ch08.entity.User2;
import kr.co.ch08.repository.User1Repository;
import kr.co.ch08.repository.User2Repository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class User2Service {

    private final User2Repository user2Repository;

    public User2DTO save(User2DTO user2DTO){
        User2 user2 = user2Repository.save(user2DTO.toEntity());
        return user2.toDTO();
    }

    public User2DTO getUser(String userId){
        Optional<User2> optUser2 = user2Repository.findById(userId);
        if(optUser2.isPresent()){
            return optUser2.get().toDTO();
        }
        return null;
    }

    public List<User2DTO> getUserAll(){
        List<User2> list = user2Repository.findAll();

        return list.stream().map(entity -> entity.toDTO()).collect(Collectors.toList());
    }

    public User2DTO modify(User2DTO user2DTO){
        if(user2Repository.existsById(user2DTO.getUserId())){
            User2 modifiedUser2 = user2Repository.save(user2DTO.toEntity());
            return modifiedUser2.toDTO();
        }
        return null;
    }

    public boolean remove(String userId){

        if(user2Repository.existsById(userId)){
            user2Repository.deleteById(userId);
            return true;
        }

        return false;
    }
}
