package com.bazaar.todo.repository;

import com.bazaar.todo.dto.TodoListItemDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class TodoListItemRepositoryTest {

    @Autowired
    private TodoListItemRepository repository;

    @Test
    public void getTodoListItem() throws Exception {
        TodoListItemDto todoListItemDto = repository.findById(1);
        assertThat(todoListItemDto.getTitle()).isE
    }
}