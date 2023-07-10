package sk.stuba.fei.uim.oop.assignment3.product.service;

import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.Amount;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductAddRequestBody;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductUpdateRequestBody;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();
    Product createNewProduct(ProductAddRequestBody newProduct);
    Product getProduct(long id);
    Product updateProduct(long id, ProductUpdateRequestBody productUpdateRequestBody);
    void deleteProduct(long id);
    Amount getProductAmount(long id);
    Amount addProductAmount(long id, long newProductAmount);
}
