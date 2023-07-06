package com.springproject.library.domain;

public record DadosListagemLivro(Long id, String titulo, String autor, String editora, Integer ano) {

    public DadosListagemLivro(Livro livro) {
        this(livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getEditora(), livro.getAno());
    }
}
