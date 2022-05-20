package com.bazaar.todo.service;

import com.bazaar.todo.dto.TodoListItemDto;
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
        given(todoListItemRepository.findById(1)).willReturn(new TodoListItemDto(1,"ABC"));
        TodoListItemDto todoListItemDto = todoListItemService.getTodoListItem(1);
        assertThat(todoListItemDto.getId()).isEqualTo(1);
        assertThat(todoListItemDto.getTitle()).isEqualTo("ABC");
    }

    @Test
    void getTodoListItem_notFound() throws Exception {
        given(todoListItemRepository.findById(1)).willReturn(null);
        try {
            todoListItemService.getTodoListItem(1);
        }
        catch (Exception ex) {
            assertThat(ex.getClass()).isEqualTo(TodoListItemNotFoundException.class);
        }
    }
}
