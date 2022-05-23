package com.bazaar.todo.service;

import com.bazaar.todo.dto.GetTodoListItemsDto;
import com.bazaar.todo.dto.TodoListItemDto;
import com.bazaar.todo.entity.TodoListItem;
import com.bazaar.todo.exceptions.TodoListItemNotFoundException;
import com.bazaar.todo.repository.TodoListItemRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
@ExtendWith(MockitoExtension.class)
public class TodoListItemServiceTest {
    @Mock
    private TodoListItemRepository todoListItemRepository;

    private TodoListItemService todoListItemService;

    @BeforeEach
    public void setUp() throws Exception {
        this.todoListItemService = new TodoListItemService(todoListItemRepository);
    }

    @Test
    void getTodoListItem() throws Exception {
        given(todoListItemRepository.findById(1L)).willReturn(Optional.of(new TodoListItem(1L, "ABC")));
        TodoListItemDto todoListItemDto = todoListItemService.getTodoListItem(1L);
        assertThat(todoListItemDto.getId()).isEqualTo(1);
        assertThat(todoListItemDto.getTitle()).isEqualTo("ABC");
    }

    @Test
    void getTodoListItem_notFound() throws Exception {
        given(todoListItemRepository.findById(1L)).willReturn(null);
        try {
            todoListItemService.getTodoListItem(1L);
        }
        catch (Exception ex) {
            assertThat(ex.getClass()).isEqualTo(TodoListItemNotFoundException.class);
        }
    }

    @Test
    void getAllTodoListItems_returnAllTodoListItems(){
        //assign
        List<TodoListItem> todoListItems= new ArrayList<TodoListItem>();
        todoListItems.add(new TodoListItem(1L, "ABC"));
        given(todoListItemRepository.findAll()).willReturn((todoListItems));

        //act and assert
        GetTodoListItemsDto getTodoListItemsDto =todoListItemService.getTodoListItems();
        assertThat(getTodoListItemsDto.getItems().size()).isEqualTo(1);
        assertThat(getTodoListItemsDto.getItems().get(0).getTitle()).isEqualTo("ABC");
    }
}
