package pk.edu.uitu.SpringBootDemo.product.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pk.edu.uitu.SpringBootDemo.Query;
import pk.edu.uitu.SpringBootDemo.product.ProductRepository;
import pk.edu.uitu.SpringBootDemo.product.model.Product;
import pk.edu.uitu.SpringBootDemo.product.model.ProductDTO;

import java.util.Optional;

@Service
public class GetProductService implements Query<Integer, ProductDTO> {

    private final ProductRepository productRepository;

    public GetProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(Integer input) {
        Optional<Product> productOptional = productRepository.findById(input);
        if (productOptional.isPresent()) {
            return ResponseEntity.ok(new ProductDTO(productOptional.get()));
        }
        return null;
    }
}
