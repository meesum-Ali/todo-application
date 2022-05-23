package com.bazaar.todo;

import com.bazaar.todo.dto.GetTodoListItemsDto;
import com.bazaar.todo.dto.TodoListItemDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
//import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getTodoListItem_returnsTodoListItem() throws Exception {
        ResponseEntity<TodoListItemDto> response = restTemplate.getForEntity("/v1/todo-list-items/1", TodoListItemDto.class);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody().getId()).isEqualTo(1);
        Assertions.assertThat(response.getBody().getTitle()).isEqualTo("ABC");
    }

    @Test
    public void getTodoListItems_returnsAllTodoListItems() throws Exception {
        ResponseEntity<GetTodoListItemsDto> response = restTemplate.getForEntity("/v1/todo-list-items", GetTodoListItemsDto.class);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody().getItems().size()).isGreaterThan(0);
    }

    @Test
    public void InsertIsWorking(){
        // throw exception
    }
}
