package kr.co.ch06.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch06.DTO.User1DTO;
import kr.co.ch06.DTO.User3DTO;
import lombok.*;
import org.springframework.stereotype.Service;

@Entity
@Getter
@Service
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user3")
public class User3 {

    @Id
    private String userId;
    private String userName;
    private String birth;
    private int age;

    public User3DTO toDTO() {
        return User3DTO.builder()
                .userId(userId)
                .userName(userName)
                .birth(birth)
                .age(age)
                .build();
    }
}
