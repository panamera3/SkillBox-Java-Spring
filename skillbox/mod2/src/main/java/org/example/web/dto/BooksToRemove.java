package org.example.web.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class BooksToRemove {

    @Pattern(regexp = "\\w+=\\w+")
    private String regEx;

    public String getRegEx() {
        return regEx;
    }

    public void setRegEx(String regEx) {
        this.regEx = regEx;
    }
}
