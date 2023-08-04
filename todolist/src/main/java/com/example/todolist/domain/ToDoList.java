package com.example.todolist.domain;

import com.example.todolist.dtos.ToDoListRegisterDTO;
import com.example.todolist.dtos.ToDoListUpdateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name = "ToDoList")
@Table(name = "toDoList")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ToDoList {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDate expiration;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    private Boolean status;

    public ToDoList(ToDoListRegisterDTO data) {
        this.title = data.title();
        this.description = data.description();
        this.expiration = data.expiration();
        this.priority = data.priority();
        this.status = true;
    }

    public void update(ToDoListUpdateDTO data) {
        if (data.title() != null) {
            this.title = data.title();
        }
        if (data.description() != null) {
            this.description = data.description();
        }
        if (data.expiration() != null) {
            this.expiration = data.expiration();
        }
        if (data.priority() != null) {
            this.priority = data.priority();
        }
    }

    public void desactivate() {
        this.status = false;
    }
}
