package com.bazaar.todo.dto;

public class CreateTodoListItemRequestDto {
    private String title;


    public CreateTodoListItemRequestDto() {
    }

    public CreateTodoListItemRequestDto(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int hashCode() {
        return getClass().hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;

        if  ( obj == null || getClass() != obj.getClass() ){
            return false;
        }
        CreateTodoListItemRequestDto other = (CreateTodoListItemRequestDto) obj;

        return title != null &&
                title.equals(other.getTitle());
    }
}
