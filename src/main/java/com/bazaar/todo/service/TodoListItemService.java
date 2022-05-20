package com.bazaar.todo.service;

import com.bazaar.todo.dto.TodoListItemDto;
import com.bazaar.todo.exceptions.TodoListItemNotFoundException;
import com.bazaar.todo.repository.TodoListItemRepository;

import java.util.ArrayList;
import java.util.List;

public class TodoListItemService {

    private TodoListItemRepository todoListItemRepositry;

    public TodoListItemService(TodoListItemRepository todoListItemRepository) {
        this.todoListItemRepositry = todoListItemRepository;
    }

    public TodoListItemDto getTodoListItem(int todoListItemId) {
        TodoListItemDto todoListItem = todoListItemRepositry.findById(todoListItemId);

        if(todoListItem == null) {
            throw new TodoListItemNotFoundException();
        }
        return todoListItem;
    }
}
