package com.xbank.adress;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AdressDTO(
        String logradouro,
        String bairro,
        @NotBlank
        @Pattern(regexp = "\\d{5}\\-\\d{3}")
        String cep,
        String localidade,
        String uf) {
}
