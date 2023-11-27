package com.example.MyBookShopApp.data;

public class SearchWordDto {

    private String example;
    private String example2;

    public SearchWordDto(String example, String example2) {
        this.example = example;
        this.example2 = example2;
    }

    public String getExample2() {
        return example2;
    }

    public void setExample2(String example2) {
        this.example2 = example2;
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
