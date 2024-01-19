package com.anjunath.task.Exception;

public class UserNotFoundException extends RuntimeException {


    public UserNotFoundException()
    {

    }
    public UserNotFoundException(String message)
    {
        super(message);
    }
}
