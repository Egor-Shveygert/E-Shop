package sk.stuba.fei.uim.oop.assignment3.cart.data;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
public class CartList {
    @Id
    Long productId;
    Long amount;

    public CartList(Long productId, Long amount) {
        this.productId = productId;
        this.amount = amount;
    }
}
