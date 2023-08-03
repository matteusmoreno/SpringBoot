package com.xbank.account.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record RegisterAccountDTO(
        @NotBlank
        @Pattern(regexp = "\\d{4}")
        String agency,
        @NotBlank
        @Pattern(regexp = "\\d{5}\\-\\d{1}")
        String numberAccount,
        @NotNull
        Long clientId // Adicionando o ID do cliente aqui
) {
}
