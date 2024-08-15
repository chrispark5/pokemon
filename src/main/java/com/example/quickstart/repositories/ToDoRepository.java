package com.example.quickstart.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.quickstart.entities.ToDo;

public interface ToDoRepository extends CrudRepository<ToDo, Integer> {
}
