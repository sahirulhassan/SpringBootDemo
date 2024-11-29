package pk.edu.uitu.SpringBootDemo.product.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pk.edu.uitu.SpringBootDemo.Query;
import pk.edu.uitu.SpringBootDemo.product.ProductRepository;
import pk.edu.uitu.SpringBootDemo.product.model.Product;
import pk.edu.uitu.SpringBootDemo.product.model.ProductDTO;

import java.util.List;

@Service
public class GetProductsService implements Query<Void, List<ProductDTO>> {

    private final ProductRepository productRepository;

    public GetProductsService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public ResponseEntity<List<ProductDTO>> execute(Void input) {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS = products.stream().map(ProductDTO::new).toList();
        return ResponseEntity.status(HttpStatus.OK).body(productDTOS);
    }
}