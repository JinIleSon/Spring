package kr.co.ch09.entity;

import jakarta.persistence.*;
import kr.co.ch09.dto.CartDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "CART")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartid;
    private String userid;
//    private int pno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pno")
    private Product product;

    private int quantity;

    public CartDTO toDTO() {
        return CartDTO.builder()
                .cartid(cartid)
                .userid(userid)
                .product(product.toDTO())
                .quantity(quantity)
                .build();
    }
}
