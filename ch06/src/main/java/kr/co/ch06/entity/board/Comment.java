package kr.co.ch06.entity.board;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@ToString(exclude = {"article"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cno;
    //private int ano; // Article과 1대다 관계
    // 따라서 Article을 불러옴

    @ManyToOne(fetch = FetchType.LAZY) // Comment 관점 다대일 관계 // 관계 설정
    @JoinColumn(name = "ano")          // FK 이름 설정
    private Article article;

    private String content;
    private String author;

    @CreationTimestamp
    private LocalDateTime wdate;

}
