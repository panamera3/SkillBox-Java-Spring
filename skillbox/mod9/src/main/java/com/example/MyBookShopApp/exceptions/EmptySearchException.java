package com.example.MyBookShopApp.exceptions;

public class EmptySearchException extends RuntimeException {
    public EmptySearchException(String message) {
        super(message);
    }
}
