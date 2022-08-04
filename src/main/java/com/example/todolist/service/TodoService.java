package com.example.todolist.service;

import com.example.todolist.common.GlobalException;
import com.example.todolist.common.TodoException;
import com.example.todolist.entity.TodoItem;
import com.example.todolist.repository.TodoRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Resource
    private TodoRepository todoRepository;

    public List<TodoItem> getAllTodoItems(){
        return Optional.of(todoRepository.findAll())
                .orElseThrow(()->new GlobalException(TodoException.GET_TODOS_FAILED));
    }

    public TodoItem addTodoItem(TodoItem todoItem){
        return Optional.of(todoRepository.save(todoItem))
                .orElseThrow(()->new GlobalException(TodoException.ADD_TODO_FAILED));
    }

    public TodoItem updateTodoItem(Integer id,TodoItem toUpdateTodoItem){
        TodoItem findTodoItem = todoRepository.findById(id).orElseThrow(()->new GlobalException(TodoException.TODO_NOT_FOUND));
        findTodoItem.setContext(toUpdateTodoItem.getContext());
        findTodoItem.setDone(toUpdateTodoItem.getDone());
        return todoRepository.save(findTodoItem);
    }
    public void deleteTodoItem(Integer id){
        todoRepository.deleteById(id);
    }
}
