package com.bazaar.todo.repository;

import com.bazaar.todo.model.TodoListItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface TodoListItemRepository extends JpaRepository<TodoListItem,Integer> {

}
