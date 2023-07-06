package com.springproject.library.controller;

import com.springproject.library.domain.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarLivro (@RequestBody @Valid DadosCadastraLivro dados, UriComponentsBuilder uriBuilder) {
        var livro = new Livro(dados);
        repository.save(livro);

        var uri = uriBuilder.path("/livro/{id}").buildAndExpand(livro.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosListagemLivro(livro));
    }

    @GetMapping("/ativos")
    public ResponseEntity<Page<DadosListagemLivro>> listarLivrosAtivos(@PageableDefault(size = 5, sort = {"id"}) Pageable paginacao) {
        var page = repository.findAllByDisponivelTrue(paginacao).map(DadosListagemLivro::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/inativos")
    public ResponseEntity<Page<DadosListagemLivro>> listarLivrosInativos(@PageableDefault(size = 5, sort = {"id"}) Pageable paginacao) {
        var page = repository.findAllByDisponivelFalse(paginacao).map(DadosListagemLivro::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizaLivro (@RequestBody @Valid DadosAtualizaLivro dados) {
        var livro = repository.getReferenceById(dados.id());
        livro.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosListagemLivro(livro));
    }

    @DeleteMapping("/desativar/{id}")
    @Transactional
    public ResponseEntity inativarLivro(@PathVariable Long id) {
        var livro = repository.getReferenceById(id);
        livro.inativar();

        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/ativar/{id}")
    @Transactional
    public ResponseEntity ativarLivro(@PathVariable Long id) {
        var livro = repository.getReferenceById(id);
        livro.ativar();

        return ResponseEntity.noContent().build();
    }

}
