package com.example.MyBookShopApp.errs;

public class NoUserFoundException extends Exception {
    public NoUserFoundException(String message) {
        super(message);
    }
}
