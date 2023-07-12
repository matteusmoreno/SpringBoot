package com.example.todolist.dto;

import com.example.todolist.domain.Prioridade;
import com.example.todolist.domain.Realizado;
import com.example.todolist.domain.Tarefa;

public record DadosListagemTarefa(Long id, String nome, String descricao, Realizado realizado, Prioridade prioridade) {

    public DadosListagemTarefa(Tarefa tarefa) {
        this(tarefa.getId(), tarefa.getNome(), tarefa.getDescricao(), tarefa.getRealizado(), tarefa.getPrioridade());
    }
}
