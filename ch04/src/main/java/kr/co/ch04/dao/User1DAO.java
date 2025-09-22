package kr.co.ch04.dao;

import kr.co.ch04.dto.User1DTO;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class User1DAO {

    private final JdbcTemplate jdbcTemplate;

    public void insert(User1DTO user1DTO){
        String sql = "insert into user1 values (?, ?, ?, ?)";

        Object[] params = {
                user1DTO.getUserId(),
                user1DTO.getUserName(),
                user1DTO.getBirth(),
                user1DTO.getAge()

        };
        jdbcTemplate.update(sql, params); // executeUpdate() 설정
    }

    public User1DTO select(String userId){
        String sql = "select * from user1 where userId = ?";

        return jdbcTemplate.queryForObject(sql, new User1RowMapper(), userId);
    }

    public List<User1DTO> selectAll(){
        String sql = "select * from user1";
        return jdbcTemplate.query(sql, new User1RowMapper());
    }

    public void update(User1DTO user1DTO){
        String sql = "update user1 set userName = ?, birth = ?, age = ? where userId = ?";

        Object[] params = {
                user1DTO.getUserName(), // 순서 맞추기
                user1DTO.getBirth(),
                user1DTO.getAge(),
                user1DTO.getUserId()
        };
        jdbcTemplate.update(sql, params); // executeUpdate() 설정
    }

    public void delete(String userId){
        String sql = "delete from user1 where userId = ?";

        jdbcTemplate.update(sql, userId);
    }
}
