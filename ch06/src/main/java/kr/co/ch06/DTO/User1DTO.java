package kr.co.ch06.DTO;

import kr.co.ch06.entity.User1;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User1DTO {
    private String userId;
    private String userName;
    private String birth;
    private int age;

    // Entity 변환 메서드
    public User1 toEntity(){
        return User1.builder()
                .userId(userId)
                .userName(userName)
                .birth(birth)
                .age(age)
                .build();
    }
}
