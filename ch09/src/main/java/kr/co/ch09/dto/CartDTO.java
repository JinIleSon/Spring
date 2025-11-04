package kr.co.ch09.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import kr.co.ch09.entity.Cart;
import kr.co.ch09.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDTO {

    private int cartid;
    private String userid;

    // JsonIgnore하면 데이터 수신 처리도 불가, JsonProperty로 수신 처리 허용
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int pno;

    private int quantity;

    // 추가필드
    private ProductDTO product;

    public Cart toEntity() {

        Product product = Product.builder().pno(pno).build();

        return Cart.builder()
                .cartid(cartid)
                .userid(userid)
                .product(product)
                .quantity(quantity)
                .build();
    }
}
