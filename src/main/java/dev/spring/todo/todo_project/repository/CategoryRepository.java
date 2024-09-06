package dev.spring.todo.todo_project.repository;

import dev.spring.todo.todo_project.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
