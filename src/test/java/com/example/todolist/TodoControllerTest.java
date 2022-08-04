package com.example.todolist;

import com.example.todolist.entity.TodoItem;
import com.example.todolist.repository.TodoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

@SpringBootTest
@AutoConfigureMockMvc
public class TodoControllerTest {

    @Autowired
    MockMvc client;
    @Resource
    TodoRepository todoRepository;

    @BeforeEach
    public void cleanDB(){
        todoRepository.deleteAll();
    }

    @Test
    public void should_return_all_todos_when_perform_get_given_todos() throws Exception {

        //given
        todoRepository.save(new TodoItem(null,"test1",false));
        todoRepository.save(new TodoItem(null,"test2",false));

        //when
        client.perform(MockMvcRequestBuilders.get("/todo"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.*",hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").isNumber());

        //then
        List<TodoItem> todoItems = todoRepository.findAll();
        assertThat(todoItems).hasSize(2);
    }

    @Test
    public void should_return_added_todo_item_when_perform_post_given_new_todo_item() throws Exception {
        //given
        String context = "Test Context add";

        //when & then
        client.perform(MockMvcRequestBuilders.post("/todo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(context))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNumber())
                .andExpect(MockMvcResultMatchers.jsonPath("$.context",equalTo(context)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.done").value(false));

    }
}
