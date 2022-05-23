package com.bazaar.todo.controller;

import com.bazaar.todo.model.TodoItem;
import com.bazaar.todo.model.TodoListItem;
import com.bazaar.todo.repository.TodoItemRepository;
import com.bazaar.todo.repository.TodoListItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/v1/todo-items")
public class TodoItemController {
    @Autowired
    TodoItemRepository todoItemRepository;

    @Autowired
    TodoListItemRepository todoListItemRepository;

    @GetMapping
    List<TodoItem> getTodoItems(@RequestParam int todoListItemId){
//        TodoListItem todoListItem=todoListItemRepository
//                .findById(1)
//                .orElseThrow(() -> new EntityNotFoundException("Invalid TodoListItem ID"));
//        todoItemRepository.save(new TodoItem(1,"hello","hello",todoListItem));
//        todoItemRepository.save(new TodoItem(1,"hello","hello",todoListItem));
        List<TodoItem> t=todoItemRepository.findByTodoListItemId(todoListItemId);

        return t;
    }

}
