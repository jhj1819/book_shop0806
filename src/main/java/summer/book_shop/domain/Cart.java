package summer.book_shop.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Cart {

    private Long id;
    private Long userId;
    private List<CartItem> cartItems;


    public Cart() {}

    public Cart(Long id, Long userId) {
        this.id = id;
        this.userId = userId;
    }

}
