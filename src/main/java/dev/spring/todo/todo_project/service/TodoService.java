package dev.spring.todo.todo_project.service;

import dev.spring.todo.todo_project.model.Category;
import dev.spring.todo.todo_project.model.Todo;
import dev.spring.todo.todo_project.repository.CategoryRepository;
import dev.spring.todo.todo_project.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService implements ITodoService{
    private final TodoRepository todoRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategory() {
        return  categoryRepository.findAll();
    }

    @Override
    public List<Todo> getAllTodoByMemberId(Long memberId) {
        return todoRepository.findTodosByMemberId(memberId);
    }
}
