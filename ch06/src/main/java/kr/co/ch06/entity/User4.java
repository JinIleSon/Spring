package kr.co.ch06.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch06.DTO.User4DTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "user4")
@Entity
@Builder
public class User4 {

    @Id
    private String userId;
    private String userName;
    private String birth;
    private int age;

    public User4DTO toDTO(){
        return User4DTO.builder()
                .userId(userId)
                .userName(userName)
                .birth(birth)
                .age(age)
                .build();
    }
}
