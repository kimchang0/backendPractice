package dev.spring.todo.todo_project.repository;

import dev.spring.todo.todo_project.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByEmailAndPassword(String email, String password);
}
