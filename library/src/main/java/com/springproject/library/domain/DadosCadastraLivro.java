package com.springproject.library.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastraLivro(
        @NotBlank
        String titulo,
        @NotBlank
        String autor,
        @NotBlank
        String editora,
        @NotNull
        Integer ano) {
}
