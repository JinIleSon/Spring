package kr.co.ch06.entity.shop;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "SHOP_CUSTOMER")
public class Customer {

    @Id
    private String custId;
    private String custName;
    private int age;
    private String addr;

    @CreationTimestamp
    private LocalDateTime regDate;
}
