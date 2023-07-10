package sk.stuba.fei.uim.oop.assignment3.cart.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    @Override
    List<Cart> findAll();

    @Override
    Cart getOne(Long aLong);
}
