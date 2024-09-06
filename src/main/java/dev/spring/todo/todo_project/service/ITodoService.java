package dev.spring.todo.todo_project.service;

import dev.spring.todo.todo_project.model.Category;
import dev.spring.todo.todo_project.model.Todo;

import java.util.List;

public interface ITodoService {
    List<Category> getCategory();

    List<Todo> getAllTodoByMemberId(Long memberId);
}
