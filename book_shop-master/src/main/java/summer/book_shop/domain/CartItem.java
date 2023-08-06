package summer.book_shop.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItem {

    private Long id;
    private Long bookId;
    private int quantity;
    private Long cartId;

    public CartItem() {}

    public CartItem(Long id, Long bookId, int quantity, Long cartId) {
        this.id = id;
        this.bookId = bookId;
        this.quantity = quantity;
        this.cartId = cartId;
    }

}
