package com.bazaar.todo.dto;

public class DeleteTodoListItemRequestDto {

    private int id;

    public DeleteTodoListItemRequestDto(int id) {
        this.id = id;
    }

    public DeleteTodoListItemRequestDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
