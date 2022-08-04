package com.example.todolist.common;

public enum ServiceException {
    GET_TODOS_FAILED("Get todos failed!"),
    ADD_TODO_FAILED("Add todo item failed!"),
    DELETE_TODO_FAILED("Delete todo failed!"),
    UPDATE_TOD_FAILED("Update todo failed!");
    private String message;

    ServiceException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
