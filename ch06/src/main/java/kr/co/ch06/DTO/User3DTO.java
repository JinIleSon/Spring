package kr.co.ch06.DTO;

import kr.co.ch06.entity.User3;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User3DTO {

    private String userId;
    private String userName;
    private String birth;
    private int age;

    public User3 toEntity(){
        return User3.builder()
                .userId(userId)
                .userName(userName)
                .birth(birth)
                .age(age)
                .build();
    }
}
