package com.bazaar.todo.dto;

public class PostTodoListItemRequestDto {

    private String title;

    public PostTodoListItemRequestDto() {
    }

    public PostTodoListItemRequestDto(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
