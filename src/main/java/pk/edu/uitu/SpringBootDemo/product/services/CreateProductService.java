package pk.edu.uitu.SpringBootDemo.product.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pk.edu.uitu.SpringBootDemo.Command;
import pk.edu.uitu.SpringBootDemo.product.ProductRepository;
import pk.edu.uitu.SpringBootDemo.product.model.Product;
import pk.edu.uitu.SpringBootDemo.product.model.ProductDTO;

@Service
public class CreateProductService implements Command<Product, ProductDTO> {

    private final ProductRepository productRepository;

    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(Product product) {
        Product savedProduct = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDTO(savedProduct));
    }
}