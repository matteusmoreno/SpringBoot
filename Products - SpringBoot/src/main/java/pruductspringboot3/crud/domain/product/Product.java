package pruductspringboot3.crud.domain.product;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "product")
@Entity(name = "Product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String price_in_cents;
    private boolean status;

    public Product(ProductsPostDto products) {
        this.name = products.name();
        this.price_in_cents = products.price_in_cents();
        this.status = true;
    }

    public void updateInfos(ProductsUpdateDto product) {
        if (product.name() != null) {
            this.name = product.name();
        }

        if (product.price_in_cents() != null) {
            this.price_in_cents = product.price_in_cents();
        }

    }

    public void inactivate() {
        this.status = false;
    }
}
