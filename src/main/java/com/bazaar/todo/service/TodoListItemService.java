package com.bazaar.todo.service;

import com.bazaar.todo.dto.CreateTodoListItemRequestDto;
import com.bazaar.todo.dto.CreateTodoListItemResponseDto;
import com.bazaar.todo.dto.GetTodoListItemsDto;
import com.bazaar.todo.dto.TodoListItemDto;
import com.bazaar.todo.entity.TodoListItem;
import com.bazaar.todo.exceptions.TodoListItemNotFoundException;
import com.bazaar.todo.repository.TodoListItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
        List<TodoListItem> todoListItems = todoListItemRepositry.findAll();
        //mapping logic

        GetTodoListItemsDto returnObject = new GetTodoListItemsDto();
        List<TodoListItemDto> todoListItemDtos = new ArrayList<>();
        todoListItems.forEach(todoListItem -> todoListItemDtos.add(new TodoListItemDto(todoListItem.getId(),todoListItem.getTitle())));
        returnObject.setItems(todoListItemDtos);

        return returnObject;
    }

    public TodoListItemDto createTodoListItems(CreateTodoListItemRequestDto body) {
//        TodoListItem todoListItem= new TodoListItem(body.getTitle());
//        todoListItemRepositry.save(todoListItem);
//        return new CreateTodoListItemResponseDto<String>("New Todo Added","Sucsess");

        return null;
    }
}
