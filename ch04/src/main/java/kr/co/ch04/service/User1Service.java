package kr.co.ch04.service;

import kr.co.ch04.dao.User1DAO;
import kr.co.ch04.dto.User1DTO;
import kr.co.ch04.mapper.User1Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class User1Service {

    private final User1Mapper mapper;

    private final User1DAO dao;

    public void save(User1DTO user1DTO){

        // MyBatis 처리
        //mapper.insert(user1DTO);

        // Spring JDBC 처리
        dao.insert(user1DTO);
    };
    public User1DTO getUser(String userId){
        //return mapper.select(userId);
        return dao.select(userId);
    };
    public List<User1DTO> getUsers(){
        //return mapper.selectAll();
        return dao.selectAll();
    };
    public void update(User1DTO user1DTO){

        //mapper.update(user1DTO);
        dao.update(user1DTO);
    };
    public void delete(String userId){

        //mapper.delete(userId);
        dao.delete(userId);
    };
}
