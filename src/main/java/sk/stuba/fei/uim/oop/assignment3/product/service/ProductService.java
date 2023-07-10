package sk.stuba.fei.uim.oop.assignment3.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.data.ProductRepository;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.Amount;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductAddRequestBody;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductUpdateRequestBody;

import java.util.List;


@Service
public class ProductService implements IProductService{
    @Autowired
    private ProductRepository repository;




    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product createNewProduct(ProductAddRequestBody newProduct) {
        var product = new Product(newProduct);
        repository.save(product);
        return product;
    }

    @Override
    public Product getProduct(long id) {
        return repository.getOne(id);
    }

    @Override
    public Product updateProduct(long id, ProductUpdateRequestBody productUpdateRequestBody) {
        var oldProduct = repository.getOne(id);
        oldProduct.setName(productUpdateRequestBody.getName() != null ? productUpdateRequestBody.getName() : oldProduct.getName());
        oldProduct.setAmount(productUpdateRequestBody.getAmount() != null ? productUpdateRequestBody.getAmount() : oldProduct.getAmount());
        oldProduct.setDescription(productUpdateRequestBody.getDescription() != null ? productUpdateRequestBody.getDescription() : oldProduct.getDescription());
        oldProduct.setPrice(productUpdateRequestBody.getPrice() != null ? productUpdateRequestBody.getPrice() : oldProduct.getPrice());
        oldProduct.setUnit(productUpdateRequestBody.getUnit() != null ? productUpdateRequestBody.getUnit() : oldProduct.getUnit());
        repository.save(oldProduct);
        return oldProduct;
    }

    @Override
    public void deleteProduct(long id) {
        repository.delete(getProduct(id));
    }

    @Override
    public Amount getProductAmount(long id) {
        return new Amount(repository.getOne(id).getAmount());
    }

    @Override
    public Amount addProductAmount(long id, long newProductAmount) {
        var selectedProduct = getProduct(id);
        var newAmount = new Amount(selectedProduct.getAmount() + newProductAmount);
        selectedProduct.setAmount(newAmount.getAmount());
        repository.save(selectedProduct);
        return newAmount;
    }
}
