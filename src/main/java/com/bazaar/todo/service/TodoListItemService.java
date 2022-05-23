package com.bazaar.todo.service;

import com.bazaar.todo.dto.DeleteTodoListItemRequestDto;
import com.bazaar.todo.dto.GetTodoListItemRequestDto;
import com.bazaar.todo.dto.PostTodoListItemRequestDto;

import java.util.List;

public interface TodoListItemService {

    List<GetTodoListItemRequestDto> getAllListItems();

    Boolean createTodoListItem(PostTodoListItemRequestDto body);

    Boolean deleteTodoListItem(DeleteTodoListItemRequestDto body);
}
