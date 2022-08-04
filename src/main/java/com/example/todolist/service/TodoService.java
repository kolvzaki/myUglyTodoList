package com.example.todolist.service;

import com.example.todolist.common.GlobalException;
import com.example.todolist.common.ServiceException;
import com.example.todolist.entity.TodoItem;
import com.example.todolist.repository.TodoRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Resource
    private TodoRepository todoRepository;

    public List<TodoItem> getAllTodoItems(){
        return Optional.of(todoRepository.findAll()).orElseThrow(()->new GlobalException(ServiceException.GET_TODOS_FAILED));
    }
}
