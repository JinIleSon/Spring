package kr.co.ch05.mapper;

import kr.co.ch05.dto.User3DTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface User3Mapper {
    public void insert3DTO(User3DTO user3DTO);
    public List<User3DTO> selectAll3DTO();
    public User3DTO select3DTO(String userId);
    public void update3DTO(User3DTO user3DTO);
    public void delete3DTO(String userId);
}
