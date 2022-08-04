package com.example.todolist.controller;

import com.example.todolist.entity.TodoItem;
import com.example.todolist.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/todo")
public class TodoController {
    @Resource
    private TodoService todoService;

    @GetMapping
    public List<TodoItem> getAllTodoItems(){
        return todoService.getAllTodoItems();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TodoItem addTodoItem(@RequestBody TodoItem todoItem){
        return todoService.addTodoItem(todoItem);
    }

    @PutMapping("/{id}")
    public TodoItem updateTodoItem(@PathVariable Integer id, @RequestBody TodoItem toUpdateTodoItem){
        return todoService.updateTodoItem(id,toUpdateTodoItem);
    }
}
