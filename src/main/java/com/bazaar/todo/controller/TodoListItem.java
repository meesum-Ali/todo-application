package com.bazaar.todo.controller;

import com.bazaar.todo.dto.TodoListItemDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/v1/todo-list-items")
public class TodoListItem {

    @GetMapping
    ResponseEntity<TodoListItemDto> getTodoListItem(){
        TodoListItemDto todoListItem = new TodoListItemDto(1, "ABC");
        return new ResponseEntity<TodoListItemDto>(todoListItem,HttpStatus.OK);
    }
}
