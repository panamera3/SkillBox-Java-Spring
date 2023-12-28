package com.example.MyBookShopApp.exceptions;

public class BookstoreApiWrongParameterException extends RuntimeException {
    public BookstoreApiWrongParameterException(String message) {
        super(message);
    }
}
