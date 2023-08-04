package com.example.todolist.dtos;

import com.example.todolist.domain.Priority;

import java.time.LocalDate;

public record ToDoListRegisterDTO(
        String title,
        String description,
        LocalDate expiration,
        Priority priority) {
}
