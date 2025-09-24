package kr.co.ch08.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_user5")
public class User5 {

    @Id
    private int ano;
    private String userName;
    private int age;
    private String gender; // M, F
    private LocalDateTime regDate;
}
