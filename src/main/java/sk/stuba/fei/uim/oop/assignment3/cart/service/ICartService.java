package sk.stuba.fei.uim.oop.assignment3.cart.service;

import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart.web.body.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotEnoughAmount;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

public interface ICartService {
    Cart createShoppingCart();
    Cart getCart(long id);
    void deleteCart(long id) throws NotFoundException;
    Cart addProductToCart(long cartId, ProductRequest productIdRequest) throws NotFoundException, NotEnoughAmount, IllegalOperationException;
    long payForCart(long cartId) throws IllegalOperationException;
}
