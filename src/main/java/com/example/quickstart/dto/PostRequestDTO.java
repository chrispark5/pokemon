package com.example.quickstart.dto;

public class PostRequestDTO {

    private String title;
    private String body;

    // Constructors, getters, and setters...
    public PostRequestDTO() {
    }

    public PostRequestDTO(String title, String body) {
        this.title = title;
        this.body = body;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
