package com.example.todolist.common;

public class GlobalException extends RuntimeException{

    private static final String ERROR_MESSAGE = "Error occurred in system.";

    public GlobalException() {
        super(ERROR_MESSAGE);
    }

    public GlobalException(String message) {
        super(message);
    }

    public GlobalException(TodoException todoException){
        super(todoException.getMessage());
    }

}
