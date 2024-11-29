package pk.edu.uitu.SpringBootDemo.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pk.edu.uitu.SpringBootDemo.product.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
