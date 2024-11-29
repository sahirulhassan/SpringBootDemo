package pk.edu.uitu.SpringBootDemo.product.model;

import lombok.Getter;

@Getter
public class UpdateProductCommand {
    private int id;
    private Product product;

    public UpdateProductCommand(int id, Product product) {
        this.id = id;
        this.product = product;
    }
}
