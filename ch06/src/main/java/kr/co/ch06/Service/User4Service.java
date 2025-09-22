package kr.co.ch06.Service;

import kr.co.ch06.DTO.User4DTO;
import kr.co.ch06.entity.User4;
import kr.co.ch06.repository.User4Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class User4Service {

    private final User4Repository user4Repository;;

    public void save(User4DTO user4DTO){
        User4 user4 = user4DTO.toEntity();
        user4Repository.save(user4);
    }

    public List<User4DTO> findAll(){
        List<User4> list = user4Repository.findAll();
        List<User4DTO> dtoList = list.stream()
                .map(entity -> entity.toDTO())
                .collect(Collectors.toList());
        return dtoList;
    }

    public User4DTO findById(String userId) {
        Optional<User4> optUser4 = user4Repository.findById(userId);

        if (optUser4.isPresent()) {
            return optUser4.get().toDTO();

        }
        return null;
    }

    public void modify(User4DTO user4DTO){
        if(user4Repository.existsById(user4DTO.getUserId())){
            user4Repository.save(user4DTO.toEntity());
        }
    }

    public void delete(String userId){
        user4Repository.deleteById(userId);
    }
}
