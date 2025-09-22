package kr.co.ch06.Service;

import kr.co.ch06.DTO.User5DTO;
import kr.co.ch06.entity.User5;
import kr.co.ch06.repository.User5Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class User5Service {

    private final User5Repository user5Repository;

    public void save(User5DTO user5DTO) {
        user5Repository.save(user5DTO.toEntity());
    }

    public List<User5DTO> findAll(){
        java.util.List<User5> list = user5Repository.findAll();

        return list.stream().map(entity -> entity.toDTO()).collect(Collectors.toList());
    }

    public User5DTO findById(String userId){
        Optional<User5> optUser5 = user5Repository.findById(userId);
        if(optUser5.isPresent()){
            return optUser5.get().toDTO();
        }
        return null;
    }

    public void modify(User5DTO user5DTO){
        if(user5Repository.existsById(user5DTO.getUserId())){
            user5Repository.save(user5DTO.toEntity());
        }
    }

    public void delete(String userId){
        user5Repository.deleteById(userId);
    }
}
