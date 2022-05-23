package com.bazaar.todo.repository;

import com.bazaar.todo.model.TodoItem;
import com.bazaar.todo.model.TodoListItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoItemRepository extends JpaRepository<TodoItem,Integer> {

    List<TodoItem> findByTodoListItemId(int a);
}
