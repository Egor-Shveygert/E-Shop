package sk.stuba.fei.uim.oop.assignment3.cart.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.cart.service.ICartService;
import sk.stuba.fei.uim.oop.assignment3.cart.web.body.CartResponse;
import sk.stuba.fei.uim.oop.assignment3.cart.web.body.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotEnoughAmount;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ICartService service;

    @PostMapping()
    public ResponseEntity<CartResponse> createCart() {
        return new ResponseEntity<>(new CartResponse(service.createShoppingCart()), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CartResponse getList(@PathVariable("id") Long id) throws NotFoundException {
        try {
            return new CartResponse(service.getCart(id));
        }
        catch (Exception e) {
            throw new NotFoundException("Cart not found with id: " + id);
        }
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) throws NotFoundException {
        try {
            this.service.deleteCart(id);
        }
        catch (Exception e) {
            throw new NotFoundException("Cart not found with id: " + id);
        }
    }

    @PostMapping(value = "/{id}/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CartResponse> addProductToCart(@PathVariable("id") Long cartID, @RequestBody ProductRequest body) throws NotFoundException, IllegalOperationException, NotEnoughAmount {
        var res = new CartResponse(service.addProductToCart(cartID, body));
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/pay")
    public String pay(@PathVariable("id") Long cartId) throws NotFoundException, IllegalOperationException {
        var res = service.payForCart(cartId);
        return String.valueOf(res);
    }

}
