package kr.co.ch05.mapper;

import kr.co.ch05.dto.User2DTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface User2Mapper {

    public void insertUser2(User2DTO user2DTO);
    public List<User2DTO> selectAllUser2();
    public User2DTO selectUser2(String userId);
    public void updateUser2(User2DTO user2DTO);
    public void deleteUser2(String userId);
}
