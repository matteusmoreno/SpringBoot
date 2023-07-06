package com.springproject.library.domain;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizaLivro(
        @NotNull
        Long id,
        String titulo,
        String autor,
        String editora,
        Integer ano) {
}
