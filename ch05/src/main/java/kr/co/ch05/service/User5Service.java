package kr.co.ch05.service;

import kr.co.ch05.dto.User5DTO;
import kr.co.ch05.mapper.User5Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class User5Service {

    private final User5Mapper mapper;

    public void register(User5DTO user5DTO){
        mapper.insertUser5(user5DTO);
    };
    public List<User5DTO> findAll(){
        return mapper.selectAllUser5();
    };
    public User5DTO findById(String userId){
        return mapper.selectUser5(userId);
    };
    public void modify(User5DTO user5DTO){
        mapper.updateUser5(user5DTO);
    };
    public void remove(String userId){
        mapper.deleteUser5(userId);
    };
}
