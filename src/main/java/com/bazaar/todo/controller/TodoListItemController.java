package com.bazaar.todo.controller;

import com.bazaar.todo.dto.TodoListItemDto;
import com.bazaar.todo.exceptions.TodoListItemNotFoundException;
import com.bazaar.todo.service.TodoListItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/v1/todo-list-items")
public class TodoListItemController {

    @Autowired
    private TodoListItemService todoListItemService;

    public TodoListItemController() {}
    public TodoListItemController(TodoListItemService todoListItemService) {
        this.todoListItemService = todoListItemService;
    }

    @GetMapping("/{todoListItemId}")
    TodoListItemDto getTodoListItem(@PathVariable Long todoListItemId) {
        return todoListItemService.getTodoListItem(todoListItemId);
    }

}
