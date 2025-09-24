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
@Table(name = "t_user3")
public class User3 {

    @Id
    private String userId;
    private String userName;
    private String role;
    private LocalDateTime regDate;
}
