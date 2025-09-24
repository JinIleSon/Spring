package kr.co.ch08.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch08.dto.User2DTO;
import lombok.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_user2")
public class User2 {

    @Id
    private String userId;
    private String userName;
    private int age;
    private String address;

    public User2DTO toDTO(){
        return User2DTO.builder()
                .userId(userId)
                .userName(userName)
                .age(age)
                .address(address)
                .build();
    }
}
