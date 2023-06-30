package pruductspringboot3.crud.domain.product;

import jakarta.validation.constraints.NotNull;

public record ProductsUpdateDto(
        @NotNull
        Long id,
        String name,
        String price_in_cents) {
}
