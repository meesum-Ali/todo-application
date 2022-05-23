package com.bazaar.todo.controller;

import com.bazaar.todo.dto.GetTodoListItemsDto;
import com.bazaar.todo.dto.TodoListItemDto;
import com.bazaar.todo.exceptions.TodoListItemNotFoundException;
import com.bazaar.todo.service.TodoListItemService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TodoListItemController.class)
class TodoListItemControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    TodoListItemService todoListItemService;

    @Test
    void getTodoListItem() throws Exception {
        //arrange

        TodoListItemDto todoListItemDto = new TodoListItemDto(1L, "ABC");

        given(todoListItemService.getTodoListItem(anyLong())).willReturn(todoListItemDto);

        //act and assert
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/todo-list-items/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("title").value("ABC"));
    }

    @Test
    void getTodoListItems_returnsAllTodoListItems() throws Exception {

        GetTodoListItemsDto items = new GetTodoListItemsDto();

        List<TodoListItemDto> testItemsList = new ArrayList<TodoListItemDto>();
        TodoListItemDto todoListItemDto = new TodoListItemDto(1L, "ABC");
        testItemsList.add(todoListItemDto);


        items.setItems(testItemsList);

        given(todoListItemService.getTodoListItems()).willReturn(items);

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/todo-list-items"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("items", hasSize(1))).andDo(print());


    }

    @Test
    void getTodoListItem_notFound() throws Exception {
        given(todoListItemService.getTodoListItem(anyLong())).willThrow(new TodoListItemNotFoundException());
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/todo-list-items/1"))
                .andExpect(status().isNotFound());
    }



}