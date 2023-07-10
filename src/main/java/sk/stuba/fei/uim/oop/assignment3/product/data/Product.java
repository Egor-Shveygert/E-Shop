package sk.stuba.fei.uim.oop.assignment3.product.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductAddRequestBody;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String description;
    Long amount;
    String unit;
    Long price;

    public Product(ProductAddRequestBody newProduct) {
        this.name = newProduct.getName();
        this.description = newProduct.getDescription();
        this.amount = newProduct.getAmount();
        this.unit = newProduct.getUnit();
        this.price = newProduct.getPrice();
    }
}
