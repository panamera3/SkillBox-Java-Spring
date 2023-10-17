package org.example.app.exceptions;

public class BookShelftLoginException extends Exception {

    private final String message;

    public BookShelftLoginException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
