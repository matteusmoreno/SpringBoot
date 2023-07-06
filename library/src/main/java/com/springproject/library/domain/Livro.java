package com.springproject.library.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "livros")
@Entity(name = "Livro")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Livro {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String autor;
    private String editora;
    private Integer ano;
    private boolean disponivel;

    public Livro(DadosCadastraLivro dados) {
        this.titulo = dados.titulo();
        this.autor = dados.autor();
        this.editora = dados.editora();
        this.ano = dados.ano();
    }

    public void atualizarInformacoes(DadosAtualizaLivro dados) {
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if (dados.autor() != null) {
            this.autor = dados.autor();
        }
        if (dados.editora() != null) {
            this.editora = dados.editora();
        }
        if (dados.ano() != null) {
            this.ano = dados.ano();
        }
    }

    public void inativar() {
        this.disponivel = false;
    }

    public void ativar() {
        this.disponivel = true;
    }
}
