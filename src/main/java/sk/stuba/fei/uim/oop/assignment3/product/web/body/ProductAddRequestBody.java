package sk.stuba.fei.uim.oop.assignment3.product.web.body;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProductAddRequestBody {
    private String name;
    private String description;
    private Long amount;
    private String unit;
    private Long price;
}
