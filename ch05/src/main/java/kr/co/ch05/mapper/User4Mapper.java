package kr.co.ch05.mapper;

import kr.co.ch05.dto.User4DTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface User4Mapper {
    public void insertUser4(User4DTO user4DTO);
    public List<User4DTO> selectAllUser4();
    public User4DTO selectUser4(String userId);
    public void updateUser4(User4DTO user4DTO);
    public void deleteUser4(String userId);
}
