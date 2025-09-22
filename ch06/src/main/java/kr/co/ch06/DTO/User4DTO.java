package kr.co.ch06.DTO;

import kr.co.ch06.entity.User4;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User4DTO {
    private String userId;
    private String userName;
    private String birth;
    private int age;

    public User4 toEntity(){
        return User4.builder()
                .userId(userId)
                .userName(userName)
                .birth(birth)
                .age(age)
                .build();
    }
}
