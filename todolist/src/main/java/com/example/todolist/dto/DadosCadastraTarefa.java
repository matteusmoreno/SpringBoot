package com.example.todolist.dto;

import com.example.todolist.domain.Prioridade;
import com.example.todolist.domain.Realizado;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastraTarefa(
        @NotBlank
        String nome,
        @NotBlank
        String descricao,
        @NotNull
        Prioridade prioridade) {

}
