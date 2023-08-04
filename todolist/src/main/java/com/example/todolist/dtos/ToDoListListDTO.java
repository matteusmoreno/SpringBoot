package com.example.todolist.dtos;

import com.example.todolist.domain.ToDoList;

import java.time.LocalDate;

public record ToDoListListDTO(
        String title,
        String description,
        LocalDate expiration,
        Boolean status) {

    public ToDoListListDTO(ToDoList toDoList) {
        this(toDoList.getTitle(), toDoList.getDescription(), toDoList.getExpiration(), toDoList.getStatus());
    }
}
