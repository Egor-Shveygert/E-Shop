package sk.stuba.fei.uim.oop.assignment3.product.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Override
    List<Product> findAll();

    @Override
    Optional<Product> findById(Long aLong);

    Product save(Product product);

}
