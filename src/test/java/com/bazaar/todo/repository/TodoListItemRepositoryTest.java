package com.bazaar.todo.repository;

import com.bazaar.todo.entity.TodoListItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TodoListItemRepositoryTest {
    @Autowired
    private TodoListItemRepository repository;
    @Autowired
    private TestEntityManager testEntityManager;
    @Test
    public void getTodoListItem() throws Exception {
        TodoListItem savedTodoListItem = testEntityManager.persistFlushFind(new TodoListItem("ABC"));
        Optional<TodoListItem> todoListItem = repository.findById(savedTodoListItem.getId());
        assertThat(todoListItem.get().getTitle()).isEqualTo("ABC");
        assertThat(todoListItem.get().getId()).isEqualTo(savedTodoListItem.getId());
    }
}