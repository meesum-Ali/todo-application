package com.bazaar.todo.repository;

import com.bazaar.todo.entity.TodoListItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TodoListItemRepository extends JpaRepository<TodoListItem, Long> { }
