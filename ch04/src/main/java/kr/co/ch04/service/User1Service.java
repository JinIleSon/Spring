package kr.co.ch04.service;

import kr.co.ch04.dto.User1DTO;
import kr.co.ch04.mapper.User1Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class User1Service {

    private final User1Mapper mapper;

    public void save(User1DTO user1DTO){
        mapper.insert(user1DTO);
    };
    public User1DTO getUser(String userId){
        return mapper.select(userId);
    };
    public List<User1DTO> getUsers(){
        return mapper.selectAll();
    };
    public void update(User1DTO user1DTO){
        mapper.update(user1DTO);
    };
    public void delete(String userId){
        mapper.delete(userId);
    };
}
