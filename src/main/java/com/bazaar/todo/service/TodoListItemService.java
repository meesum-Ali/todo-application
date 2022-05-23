package com.bazaar.todo.service;

import com.bazaar.todo.dto.GetTodoListItemsDto;
import com.bazaar.todo.dto.TodoListItemDto;
import com.bazaar.todo.entity.TodoListItem;
import com.bazaar.todo.exceptions.TodoListItemNotFoundException;
import com.bazaar.todo.repository.TodoListItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TodoListItemService {

    @Autowired
    private TodoListItemRepository todoListItemRepositry;

    public TodoListItemService() {}

    public TodoListItemService(TodoListItemRepository todoListItemRepository) {
        this.todoListItemRepositry = todoListItemRepository;
    }

    public TodoListItemDto getTodoListItem(Long todoListItemId) {
        Optional<TodoListItem> todoListItem = todoListItemRepositry.findById(todoListItemId);

        if(todoListItem == null) {
            throw new TodoListItemNotFoundException();
        }

        TodoListItemDto todoListItemDto = new TodoListItemDto(todoListItem.get().getId(),
                todoListItem.get().getTitle());
        return todoListItemDto;
    }

    public GetTodoListItemsDto getTodoListItems() {
        Iterable<TodoListItem> todoListItems = todoListItemRepositry.findAll();

        return null;
    }
}
