package com.bazaar.todo.dto;

public class CreateTodoListItemResponseDto <T>{
    private T response;
    private String status;

    public CreateTodoListItemResponseDto() {
    }

    public CreateTodoListItemResponseDto(T response, String status) {
        this.response = response;
        this.status = status;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int hashCode() {
        return getClass().hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;

        if  ( obj == null || getClass() != obj.getClass() ){
            return false;
        }
        CreateTodoListItemResponseDto other = (CreateTodoListItemResponseDto) obj;

        return status != null &&
                status.equals(other.getStatus());
    }

}
