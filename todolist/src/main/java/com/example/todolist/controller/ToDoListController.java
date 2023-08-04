package com.example.todolist.controller;

import com.example.todolist.domain.ToDoList;
import com.example.todolist.dtos.ToDoListDetailsDTO;
import com.example.todolist.dtos.ToDoListListDTO;
import com.example.todolist.dtos.ToDoListRegisterDTO;
import com.example.todolist.dtos.ToDoListUpdateDTO;
import com.example.todolist.repository.ToDoListRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("todolist")
public class ToDoListController {

    private final ToDoListRepository repository;

    public ToDoListController(ToDoListRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid ToDoListRegisterDTO data, UriComponentsBuilder uriBuilder) {
        var toDoList = new ToDoList(data);
        repository.save(toDoList);

        var uri = uriBuilder.path("/todolist/{id}").buildAndExpand(toDoList.getId()).toUri();

        return ResponseEntity.created(uri).body(new ToDoListDetailsDTO(toDoList));
    }

    @GetMapping
    public ResponseEntity<Page<ToDoListListDTO>> list(@PageableDefault (size = 10, sort = {"expiration"})Pageable pagination) {
        var page = repository.findAllByStatusTrue(pagination).map(ToDoListListDTO::new);

        return ResponseEntity.ok(page);

    }

    @GetMapping("{id}")
    public ResponseEntity details(@PathVariable Long id) {
        var toDoList = repository.getReferenceById(id);

        return ResponseEntity.ok(new ToDoListDetailsDTO(toDoList));
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid ToDoListUpdateDTO data) {
        var toDoList = repository.getReferenceById(data.id());
        toDoList.update(data);

        return ResponseEntity.ok(new ToDoListDetailsDTO(toDoList));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity desactivate(@PathVariable Long id) {
        var toDoList = repository.getReferenceById(id);
        toDoList.desactivate();

        return ResponseEntity.noContent().build();
    }


}
