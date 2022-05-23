package com.bazaar.todo.entity;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TodoListItem {
    public TodoListItem() {
    }

    public TodoListItem( String title) {
        this.title = title;
    }

    public TodoListItem(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    @Id
    @GeneratedValue
    private Long id;
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
