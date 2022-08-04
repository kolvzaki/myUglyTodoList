package com.example.todolist.entity;


import javax.persistence.*;

@Entity
@Table(name = "todo")
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "text")
    private String context;
    private Boolean done;


    public TodoItem() {
    }

    public TodoItem(String context) {
        this.id = null;
        this.context = context;
        this.done = false;
    }

    public TodoItem(Integer id, String context, Boolean done) {
        this.id = id;
        this.context = context;
        this.done = done;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
