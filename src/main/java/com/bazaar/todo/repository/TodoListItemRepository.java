package com.bazaar.todo.repository;

import com.bazaar.todo.entity.TodoListItem;
import org.springframework.data.repository.CrudRepository;

public interface TodoListItemRepository extends CrudRepository<TodoListItem, Long> { }
