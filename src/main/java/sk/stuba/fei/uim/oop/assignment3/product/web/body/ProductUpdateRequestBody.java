package sk.stuba.fei.uim.oop.assignment3.product.web.body;

import lombok.Getter;

@Getter
public class ProductUpdateRequestBody {
    private String name;
    private String description;
    private Long amount;
    private String unit;
    private Long price;
}
