package com.example.MyBookShopApp.data.dto;

public class SearchWordDto {

    private String example;

    public SearchWordDto(String example) {
        this.example = example;
    }

    public SearchWordDto() {
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getExample() {
        return example;
    }
}
