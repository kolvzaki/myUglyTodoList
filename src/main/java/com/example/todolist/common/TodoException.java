package com.example.todolist.common;

public enum TodoException {
    GET_TODOS_FAILED("Get todos failed!"),
    ADD_TODO_FAILED("Add todo item failed!"),
    DELETE_TODO_FAILED("Delete todo failed!"),
    TODO_NOT_FOUND("No such todo item!"),
    UPDATE_TOD_FAILED("Update todo failed!");

    private String message;

    TodoException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
