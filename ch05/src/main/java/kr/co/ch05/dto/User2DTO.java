package kr.co.ch05.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User2DTO {
    private String userId;
    private String userName;
    private String birth;
    private int age;
}
