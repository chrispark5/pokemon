package com.example.quickstart.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.quickstart.entities.ToDo;
import com.example.quickstart.repositories.ToDoRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ToDoController {

    private final ToDoRepository toDoRepository;

    public ToDoController(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @GetMapping("/todo")
    public Iterable<ToDo> findAllToDos() {
        return this.toDoRepository.findAll();
    }

    @PostMapping("/todo")
    public ToDo addOneToDo(@RequestBody ToDo todo) {
        return this.toDoRepository.save(todo);
    }

    @DeleteMapping("/todo/{id}")
    public void deleteToDoById(@PathVariable Integer id) {
        // Logic to delete to-do item by ID
        this.toDoRepository.deleteById(id);
    }

}
