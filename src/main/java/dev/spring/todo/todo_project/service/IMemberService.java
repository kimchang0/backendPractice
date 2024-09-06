package dev.spring.todo.todo_project.service;

import dev.spring.todo.todo_project.model.Member;

public interface IMemberService {
    Member findByMemberWithIdPw(Member member);

    Member saveMember(Member member);
}
