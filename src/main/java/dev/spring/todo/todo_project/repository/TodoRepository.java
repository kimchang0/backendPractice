package dev.spring.todo.todo_project.repository;

import dev.spring.todo.todo_project.model.Member;
import dev.spring.todo.todo_project.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findTodosByMemberId(Long memberId);
}
