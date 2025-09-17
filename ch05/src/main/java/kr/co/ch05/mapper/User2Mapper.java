package kr.co.ch05.mapper;

import kr.co.ch05.dto.User2DTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface User2Mapper {

    public void insertUser2(User2DTO user2DTO){}
    public List<User2DTO> selectAllUser2(String userId){
        return null;
    }
    selectUser2(){}
    updateUser2(){}
    deleteUser2(){}
}
