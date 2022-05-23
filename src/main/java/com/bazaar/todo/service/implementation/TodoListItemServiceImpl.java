package com.bazaar.todo.service.implementation;

import com.bazaar.todo.dto.DeleteTodoListItemRequestDto;
import com.bazaar.todo.dto.GetTodoListItemRequestDto;
import com.bazaar.todo.dto.PostTodoListItemRequestDto;
import com.bazaar.todo.model.TodoListItem;
import com.bazaar.todo.repository.TodoListItemRepository;
import com.bazaar.todo.service.TodoListItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoListItemServiceImpl implements TodoListItemService {

    @Autowired
    TodoListItemRepository todoListItemRepository;

    @Override
    public List<GetTodoListItemRequestDto> getAllListItems() {
        List<TodoListItem> todoListItems = todoListItemRepository.findAll();

        //Mapper Part
        List<GetTodoListItemRequestDto> getTodoListItemRequestDtos = new ArrayList<>();
        todoListItems.forEach(
                s-> getTodoListItemRequestDtos.add(new GetTodoListItemRequestDto(s.getId(),s.getTitle()))
        );


        return getTodoListItemRequestDtos;
    }

    @Override
    @Transactional
    public Boolean createTodoListItem(PostTodoListItemRequestDto body) {
        TodoListItem todoListItem= new TodoListItem(body.getTitle());
        todoListItemRepository.save(todoListItem);
        return Boolean.TRUE;
    }

    @Override
    @Transactional
    public Boolean deleteTodoListItem(DeleteTodoListItemRequestDto body) {
        TodoListItem todoListItem=todoListItemRepository
                .findById(body.getId())
                .orElseThrow(() -> new EntityNotFoundException("Invalid TodoListItem ID"));

        todoListItemRepository.delete(todoListItem);
        return Boolean.TRUE;
    }
}
