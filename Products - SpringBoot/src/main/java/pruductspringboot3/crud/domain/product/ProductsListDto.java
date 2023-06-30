package pruductspringboot3.crud.domain.product;

public record ProductsListDto(Long id, String name, String price_in_cents) {

    public ProductsListDto(Product product) {
        this(product.getId(), product.getName(), product.getPrice_in_cents());
    }
}
