package com.example.clientes.services.exceptions;

public class DatabaseException extends RuntimeException{

    public DatabaseException(String message){
        super(message);
    }
}