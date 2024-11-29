package pk.edu.uitu.SpringBootDemo.product.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pk.edu.uitu.SpringBootDemo.Command;
import pk.edu.uitu.SpringBootDemo.product.ProductRepository;
import pk.edu.uitu.SpringBootDemo.product.model.Product;

import java.util.Optional;

@Service
public class DeleteProductService implements Command<Integer, Void> {

    private final ProductRepository productRepository;

    public DeleteProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Integer input) {
        Optional<Product> productOptional = productRepository.findById(input);
        if (productOptional.isPresent()) {
            productRepository.deleteById(input);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return null;
    }
}
