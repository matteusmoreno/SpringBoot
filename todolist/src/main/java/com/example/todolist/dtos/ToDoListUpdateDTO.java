package com.example.todolist.dtos;

import com.example.todolist.domain.Priority;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ToDoListUpdateDTO(
        @NotNull
        Long id,
        String title,
        String description,
        LocalDate expiration,
        Priority priority) {
}
