package pk.edu.uitu.SpringBootDemo.product.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pk.edu.uitu.SpringBootDemo.Command;
import pk.edu.uitu.SpringBootDemo.product.ProductRepository;
import pk.edu.uitu.SpringBootDemo.product.model.Product;
import pk.edu.uitu.SpringBootDemo.product.model.ProductDTO;
import pk.edu.uitu.SpringBootDemo.product.model.UpdateProductCommand;
import java.util.Optional;

@Service
public class UpdateProductService implements Command<UpdateProductCommand, ProductDTO> {

    private final ProductRepository productRepository;

    public UpdateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponseEntity<ProductDTO> execute(UpdateProductCommand command) {
        Optional<Product> productOptional = productRepository.findById(command.getId());
        if (productOptional.isPresent()) {
            Product product = command.getProduct();
            product.setId(command.getId());
            productRepository.save(product);
            return ResponseEntity.ok(new ProductDTO(product));
        }
        return null;
    }
}
