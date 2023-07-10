package sk.stuba.fei.uim.oop.assignment3.cart.web.body;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private Long productId;
    private Long amount;
}
