package pruductspringboot3.crud.domain.product;

import jakarta.validation.constraints.NotBlank;

public record ProductsPostDto(
        @NotBlank
        String name,
        @NotBlank
        String price_in_cents) {
}
