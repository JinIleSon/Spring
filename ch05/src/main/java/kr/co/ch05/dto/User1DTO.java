package kr.co.ch05.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User1DTO {

    private String userId;
    private String userName;
    private String birth;
    private int age;
}
