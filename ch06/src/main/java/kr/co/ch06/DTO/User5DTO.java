package kr.co.ch06.DTO;

import kr.co.ch06.entity.User5;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User5DTO {

    private String userId;
    private String userName;
    private String birth;
    private int age;

    public User5 toEntity(){
        return User5.builder()
                .userId(userId)
                .userName(userName)
                .birth(birth)
                .age(age)
                .build();
    }
}
