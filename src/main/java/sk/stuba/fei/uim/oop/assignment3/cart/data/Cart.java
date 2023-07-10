package sk.stuba.fei.uim.oop.assignment3.cart.data;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @OneToMany
    List<CartList> shoppingList;
    Boolean payed;

    public Cart() {
        this.shoppingList = new ArrayList<>();
        this.payed = false;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", shoppingList=" + shoppingList +
                ", payed=" + payed +
                '}';
    }
}
