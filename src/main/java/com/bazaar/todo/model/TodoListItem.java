package com.bazaar.todo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class TodoListItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    @OneToMany(mappedBy = "todoListItem")
    private List<TodoItem> todoItems;



    public TodoListItem(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public TodoListItem(String title) {
        this.title = title;
    }

    public TodoListItem() {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void setTodoItems(List<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }
}
