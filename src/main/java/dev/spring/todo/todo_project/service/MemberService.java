package dev.spring.todo.todo_project.service;

import dev.spring.todo.todo_project.model.Member;
import dev.spring.todo.todo_project.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService implements IMemberService{
    private final MemberRepository MemberRepository;

    @Override
    public Member findByMemberWithIdPw(Member member) {
        return MemberRepository.findByEmailAndPassword(member.getEmail(), member.getPassword());
    }

    @Override
    public Member saveMember(Member member) {
        return MemberRepository.save(member);
    }
}
