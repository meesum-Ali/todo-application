package com.bazaar.todo.controller;

import com.bazaar.todo.dto.CreateTodoListItemRequestDto;
import com.bazaar.todo.dto.CreateTodoListItemResponseDto;
import com.bazaar.todo.dto.GetTodoListItemsDto;
import com.bazaar.todo.dto.TodoListItemDto;
import com.bazaar.todo.exceptions.TodoListItemNotFoundException;
import com.bazaar.todo.service.TodoListItemService;
import com.google.gson.Gson;
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
import static org.mockito.ArgumentMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    void createTodoListItem() throws Exception {

        Gson gson = new Gson();
        String jsonString = gson.toJson(new CreateTodoListItemRequestDto("New Todo"));

        given(todoListItemService.createTodoListItems(any(CreateTodoListItemRequestDto.class)))
                .willReturn(new TodoListItemDto(1L,"kkk"));

        System.out.println("****");
        System.out.println(todoListItemService.createTodoListItems(new CreateTodoListItemRequestDto("nn")));
        System.out.println("****");

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/todo-list-items")
                        .contentType(MediaType.APPLICATION_JSON).content(jsonString))
                .andExpect(status().isOk())
                .andDo(print());
//                .andExpect(jsonPath("status").value("Success"));


    }


}