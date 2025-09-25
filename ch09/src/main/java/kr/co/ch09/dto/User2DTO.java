package kr.co.ch08.dto;

import kr.co.ch08.entity.User2;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User2DTO {

    private String userId;
    private String userName;
    private int age;
    private String address;

    public User2 toEntity(){
        return User2.builder()
                .userId(userId)
                .userName(userName)
                .age(age)
                .address(address)
                .build();
    }
}
