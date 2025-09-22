package kr.co.ch06.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch06.DTO.User5DTO;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user5")
public class User5 {
    @Id
    private String userId;
    private String userName;
    private String birth;
    private int age;

    public User5DTO toDTO(){
        return User5DTO.builder()
                .userId(userId)
                .userName(userName)
                .age(age)
                .birth(birth)
                .build();
    }
}
