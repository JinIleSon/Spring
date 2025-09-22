package kr.co.ch06.entity;
import jakarta.persistence.*;


import kr.co.ch06.DTO.User1DTO;
import lombok.*;

@Getter
//@Setter // Entity는 Setter 불변성을 위해 금지
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity // Entity 객체 선언 어노테이션
@Table(name = "User1") // 이 엔티티 클래스가 어떤 데이터베이스 테이블과 매핑되는지 지정하는 어노테이션이다.
public class User1 {

    @Id // PK 컬럼 선언
    private String userId;

    @Column(name = "userName") // 매핑 컬럼, 일반적으로 생략
    private String userName;
    private String birth;
    private int age;

    // DTO 변환 메서드 정의
    public User1DTO toDTO(){
        return User1DTO.builder()
                .userId(userId)
                .userName(userName)
                .birth(birth)
                .age(age)
                .build();
    }
}
