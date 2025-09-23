package kr.co.ch07.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "SC_USER")
public class User {

    @Id
    private String usId;
    private String pass;
    private String name;
    private int age;
    private String role;

    @CreationTimestamp
    private LocalDateTime regDate;

}
