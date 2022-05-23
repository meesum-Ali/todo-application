package com.bazaar.todo.repository;

import com.bazaar.todo.entity.TodoListItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;
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

    @Test
    public void getAllTodoListItems_returnGetAllTodoList(){

        Long savedTodoListItem1 = (Long) testEntityManager.persistAndGetId(new TodoListItem("QWE"));
        Long savedTodoListItem2 = (Long) testEntityManager.persistAndGetId(new TodoListItem("XYZ"));

        List<TodoListItem> todoListItems =repository.findAll();


        assertThat(todoListItems.size()).isGreaterThanOrEqualTo(2);
        assertThat(todoListItems.stream().filter(p->p.getId().equals(savedTodoListItem1)).findFirst().get().getTitle().equals("QWE"));
        assertThat(todoListItems.stream().filter(p->p.getId().equals(savedTodoListItem2)).findFirst().get().getTitle().equals("XYZ"));
    }
}