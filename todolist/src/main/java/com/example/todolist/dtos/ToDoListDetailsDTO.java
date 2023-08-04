package com.example.todolist.dtos;

import com.example.todolist.domain.Priority;
import com.example.todolist.domain.ToDoList;

import java.time.LocalDate;

public record ToDoListDetailsDTO(
        Long id,
        String title,
        String description,
        LocalDate expiration,
        Priority priority,
        Boolean status) {

    public ToDoListDetailsDTO(ToDoList toDoList) {
        this(toDoList.getId(), toDoList.getTitle(), toDoList.getDescription(), toDoList.getExpiration(),
                toDoList.getPriority(), toDoList.getStatus());
    }
}
