package com.bazaar.todo.controller;

import com.bazaar.todo.dto.DeleteTodoListItemRequestDto;
import com.bazaar.todo.dto.GetTodoListItemRequestDto;
import com.bazaar.todo.dto.PostTodoListItemRequestDto;
import com.bazaar.todo.service.TodoListItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/v1/todo-list-items")
public class TodoListItemController {

    @Autowired
    TodoListItemService todoListItemService;

    @GetMapping
    ResponseEntity<List<GetTodoListItemRequestDto>> getTodoListItem(){

        List<GetTodoListItemRequestDto> getTodoListItemRequestDtos =todoListItemService.getAllListItems();
        return new ResponseEntity<List<GetTodoListItemRequestDto>>(getTodoListItemRequestDtos,HttpStatus.OK);
    }

    @PostMapping
    Boolean createTodoListItem(@RequestBody PostTodoListItemRequestDto body){
        return todoListItemService.createTodoListItem(body);
    }

    @DeleteMapping
    Boolean deleteTodoListItem(@RequestBody DeleteTodoListItemRequestDto body){
        return todoListItemService.deleteTodoListItem(body);
    }


}
