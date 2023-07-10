package sk.stuba.fei.uim.oop.assignment3.product.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.service.IProductService;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.Amount;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductAddRequestBody;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductResponse;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductUpdateRequestBody;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResponse> creatProduct(@RequestBody ProductAddRequestBody body) {
        var res = new ProductResponse(service.createNewProduct(body));
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductResponse> getAllProducts() {
        return this.service.getAllProducts().stream()
                .map(ProductResponse::new)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductResponse getProduct(@PathVariable("id") Long productId) throws NotFoundException {
        try {
            var response =  new ProductResponse(service.getProduct(productId));
            return  response;
        }
        catch (Exception e) {
            System.out.println(e);
            throw new NotFoundException("Product not found with id: " + productId);
        }
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductResponse updateProduct(@PathVariable("id") Long productId, @RequestBody ProductUpdateRequestBody body) throws NotFoundException{
        try {
            return new ProductResponse(service.updateProduct(productId, body));
        }
        catch (Exception e) {
            throw new NotFoundException("Product not found with id: " + productId);
        }
    }

    @DeleteMapping(value = "/{id}")
    public void deleteBook(@PathVariable("id") Long productId) throws NotFoundException {
        try {
            var selectedProduct = getProduct(productId);
            this.service.deleteProduct(productId);
        }
        catch (Exception e) {
            throw new NotFoundException("Product not found with id: " + productId);
        }
    }

    @GetMapping(value = "/{id}/amount", produces = MediaType.APPLICATION_JSON_VALUE)
    public Amount getAmount(@PathVariable("id") Long productId) throws NotFoundException {
        try {
            return this.service.getProductAmount(productId);
        }
        catch (Exception e) {
            throw new NotFoundException("Product not found with id: " + productId);
        }
    }

    @PostMapping(value = "/{id}/amount", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Amount addProductAmount(@PathVariable("id") Long productId, @RequestBody Amount body) throws NotFoundException {
        try {
            return this.service.addProductAmount(productId, body.getAmount());
        }
        catch (Exception e) {
            throw new NotFoundException("Product not found with id: " + productId);
        }
    }
}
