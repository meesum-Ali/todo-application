package com.bazaar.todo.model;

import javax.persistence.*;

@Entity
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    @ManyToOne
    @JoinColumn(name = "TODOLISTITEM_ID", referencedColumnName = "id")
    private TodoListItem todoListItem;

    public TodoItem() {
    }


    public TodoItem(int id, String title, String description, TodoListItem todoListItem) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.todoListItem = todoListItem;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TodoListItem getTodoListItem() {
        return todoListItem;
    }

    public void setTodoListItem(TodoListItem todoListItem) {
        this.todoListItem = todoListItem;
    }
}
