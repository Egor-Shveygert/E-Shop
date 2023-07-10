package sk.stuba.fei.uim.oop.assignment3.cart.web.body;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart.data.CartList;

import java.util.List;

@Getter
@Setter
@Data

public class CartResponse {
    private Long id;
    private List<CartList> shoppingList;
    private Boolean payed;

    public CartResponse(Cart cart) {
        this.id = cart.getId();
        this.shoppingList = cart.getShoppingList();
        this.payed = cart.getPayed();
    }
}
