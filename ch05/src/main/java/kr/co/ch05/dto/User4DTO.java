package kr.co.ch05.dto;

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
}
