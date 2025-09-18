package kr.co.ch05.mapper;

import kr.co.ch05.dto.User5DTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface User5Mapper {
    public void insertUser5(User5DTO user5DTO);
    public List<User5DTO> selectAllUser5();
    public User5DTO selectUser5(String userId);
    public void updateUser5(User5DTO user5DTO);
    public void deleteUser5(String userId);
}
