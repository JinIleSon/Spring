package kr.co.ch05.service;

import kr.co.ch05.dto.User1DTO;
import kr.co.ch05.mapper.User1Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class User1Service {

    // 상단 @RequiredArgsConstructor 어노테이션으로 mapper 초기화
    private final User1Mapper mapper;

    public List<User1DTO> findAll(){
        return mapper.selectAllUser1();
    }
    public User1DTO findById(String uid){
        return mapper.selectUser1(uid);
    }
    public void register(User1DTO user1DTO){
        mapper.insertUser1(user1DTO);
    }
    public void modify(User1DTO user1DTO){
        mapper.updateUser1(user1DTO);
    }
    public void remove(String uid){
        mapper.deleteUser1(uid);
    }
}
