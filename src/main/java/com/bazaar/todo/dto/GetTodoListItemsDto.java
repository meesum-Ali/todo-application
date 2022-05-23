package com.bazaar.todo.dto;

import java.util.List;

public class GetTodoListItemsDto {
    private List<TodoListItemDto> items;

    public GetTodoListItemsDto(){}
    public GetTodoListItemsDto(List<TodoListItemDto> items) {
        this.items = items;
    }

    public void setItems(List<TodoListItemDto> items) {
        this.items = items;
    }

    public List<TodoListItemDto> getItems() {
        return this.items;
    }
}
