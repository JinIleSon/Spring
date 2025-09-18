package kr.co.ch05.service;

import kr.co.ch05.dto.User4DTO;
import kr.co.ch05.mapper.User4Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class User4Service {

    private final User4Mapper mapper;

    public void register(User4DTO user4DTO){
        mapper.insertUser4(user4DTO);
    };
    public List<User4DTO> findAll(){
        return mapper.selectAllUser4();
    };
    public User4DTO findById(String userId){
        return mapper.selectUser4(userId);
    };
    public void modify(User4DTO user4DTO){
        mapper.updateUser4(user4DTO);
    };
    public void remove(String userId){
        mapper.deleteUser4(userId);
    };
}
