package com.example.todolist.repository;

import com.example.todolist.domain.ToDoList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {
    Page<ToDoList> findAllByStatusTrue(Pageable pagination);
}
