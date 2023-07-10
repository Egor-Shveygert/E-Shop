package sk.stuba.fei.uim.oop.assignment3.cart.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartListRepository extends JpaRepository<Cart, Long> {
    @Override
    List<Cart> findAll();

    @Override
    Optional<Cart> findById(Long aLong);
}
