package com.bazaar.todo;

import com.bazaar.todo.dto.GetTodoListItemRequestDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getTodoListItem_returnsTodoListItems() throws Exception {
        ResponseEntity<GetTodoListItemRequestDto> response = restTemplate.getForEntity("/v1/todo-list-items", GetTodoListItemRequestDto.class);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody().getId()).isEqualTo(1);
        Assertions.assertThat(response.getBody().getTitle()).isEqualTo("ABC");
    }

    @Test
    public void InsertIsWorking(){
        // throw exception
    }
}
