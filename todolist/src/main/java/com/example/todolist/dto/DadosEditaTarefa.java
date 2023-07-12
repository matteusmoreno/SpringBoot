package com.example.todolist.dto;

import com.example.todolist.domain.Prioridade;
import com.example.todolist.domain.Realizado;
import jakarta.validation.constraints.NotNull;

public record DadosEditaTarefa(
        @NotNull
        Long id,
        String nome,
        String descricao,
        Realizado realizado,
        Prioridade prioridade) {
}
