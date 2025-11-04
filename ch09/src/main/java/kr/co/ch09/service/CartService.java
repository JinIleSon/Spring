package kr.co.ch09.service;

import kr.co.ch09.dto.CartDTO;
import kr.co.ch09.entity.Cart;
import kr.co.ch09.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    public CartDTO save(CartDTO cartDTO) {
        Cart cart = cartDTO.toEntity();
        Cart savedCart = cartRepository.save(cart);
        return savedCart.toDTO();
    }

    public List<CartDTO> findByUserid(String userid){

        List<Cart> cartList = cartRepository.findByUserid(userid);
        return cartList.stream().map(Cart :: toDTO).toList();
    }
}
