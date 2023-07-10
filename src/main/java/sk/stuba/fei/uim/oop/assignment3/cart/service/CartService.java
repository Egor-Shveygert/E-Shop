package sk.stuba.fei.uim.oop.assignment3.cart.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart.data.CartList;
import sk.stuba.fei.uim.oop.assignment3.cart.data.CartRepository;
import sk.stuba.fei.uim.oop.assignment3.cart.web.body.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.service.ProductService;
import sk.stuba.fei.uim.oop.assignment3.product.web.body.ProductUpdateRequestBody;

@Service
public class CartService implements ICartService{
    @Autowired
    private CartRepository repository;

    @Autowired
    private ProductService productService;

    @Override
    public Cart createShoppingCart() {
        var cart = new Cart();
        repository.save(cart);
        return cart;
    }

    @Override
    public Cart getCart(long id) {
        return repository.getOne(id);
    }

    @Override
    public void deleteCart(long id) throws NotFoundException {
        try {
            var selectedCart = repository.getOne(id);
            System.out.println(selectedCart);
            repository.delete(selectedCart);
        } catch (Exception e) {
            throw new NotFoundException("Cart not found with id: " + id);
        }
    }


    @Override
    public Cart addProductToCart(long cartId, ProductRequest productRequest) throws IllegalOperationException {

        var cart = repository.getOne(cartId);
        try {
            System.out.println(cart);
        }
        catch (Exception e) {
            throw new NotFoundException("Cart not found with id: " + cartId);
        }
        if (cart.getPayed()) {
            throw new IllegalOperationException();
        }
        var selectedProduct = productService.getProduct(productRequest.getProductId());
        try {
            System.out.println(selectedProduct);
        }
        catch (Exception e) {
            throw new NotFoundException("Product not found with id: " + productRequest.getProductId());
        }
        var isProductInCart = cart.getShoppingList().stream()
                .filter(product -> product.getProductId().equals(productRequest.getProductId()))
                .findFirst();
        if (isProductInCart.isPresent() && selectedProduct.getAmount() >= productRequest.getAmount()) {
            var cartList = isProductInCart.get();
            cartList.setAmount(cartList.getAmount() + productRequest.getAmount());
        } else if (isProductInCart.isEmpty() && selectedProduct.getAmount() >= productRequest.getAmount()){
            cart.getShoppingList().add(new CartList(selectedProduct.getId(), productRequest.getAmount()));
        }
        else {
            throw new IllegalOperationException();
        }
        productService.addProductAmount(selectedProduct.getId(), -productRequest.getAmount());
        productService.updateProduct(selectedProduct.getId(), new ProductUpdateRequestBody());
        return cart;

    }

    @Override
    public long payForCart(long cartId) throws IllegalOperationException {
        var cart = getCart(cartId);
        try {
            System.out.println(cart);
        }
        catch (Exception e) {
            throw new NotFoundException("Cart is already payed with id: " + cartId);

        }
        if (cart.getPayed()) {
            throw new IllegalOperationException();
        }
        long money = 0;
        for (CartList cartListItem : cart.getShoppingList()) {
            Product product = productService.getProduct(cartListItem.getProductId());
            Long itemPrice = cartListItem.getAmount() * product.getPrice();
            money += itemPrice;
        }
        cart.setPayed(true);
        return money;
    }
}