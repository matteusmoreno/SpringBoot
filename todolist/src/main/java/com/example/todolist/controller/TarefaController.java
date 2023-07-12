package com.example.todolist.controller;

import com.example.todolist.domain.Tarefa;
import com.example.todolist.dto.DadosCadastraTarefa;
import com.example.todolist.dto.DadosEditaTarefa;
import com.example.todolist.dto.DadosListagemTarefa;
import com.example.todolist.repository.TarefaRepository;
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
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarTarefa(@RequestBody @Valid DadosCadastraTarefa dados, UriComponentsBuilder uriBuilder) {
        var tarefa = new Tarefa(dados);
        repository.save(tarefa);

        var uri = uriBuilder.path("/tarefas/{id}").buildAndExpand(tarefa.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosListagemTarefa(tarefa));

    }

    @GetMapping("/listar")
    public ResponseEntity<Page<DadosListagemTarefa>> listarTodos(@PageableDefault(size = 5, sort = {"id"}) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemTarefa::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity detalharTarefa(@PathVariable Long id) {
        var tarefa = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosListagemTarefa(tarefa));
    }

    @PutMapping("/edita")
    @Transactional
    public ResponseEntity editaTarefa (@RequestBody @Valid DadosEditaTarefa dados) {
        var tarefa = repository.getReferenceById(dados.id());
        tarefa.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosListagemTarefa(tarefa));
    }

    @DeleteMapping("/deleta/{id}")
    @Transactional
    public ResponseEntity deletaTarefa(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
