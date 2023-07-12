package com.example.todolist.domain;

import com.example.todolist.dto.DadosCadastraTarefa;
import com.example.todolist.dto.DadosEditaTarefa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tarefas")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Tarefa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private Realizado realizado = Realizado.CRIADO;
    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;


    public Tarefa(DadosCadastraTarefa dados) {
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.prioridade = dados.prioridade();
    }

    public void atualizarInformacoes(DadosEditaTarefa dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.descricao() != null) {
            this.descricao = dados.descricao();
        }
        if (dados.realizado() != null) {
            this.realizado = dados.realizado();
        }
        if (dados.prioridade() != null) {
            this.prioridade = dados.prioridade();
        }
    }
}
