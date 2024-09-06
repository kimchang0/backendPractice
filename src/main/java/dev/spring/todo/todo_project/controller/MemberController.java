package dev.spring.todo.todo_project.controller;

import dev.spring.todo.todo_project.model.Member;
import dev.spring.todo.todo_project.service.IMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequestMapping("/")
@Controller
@RequiredArgsConstructor
public class MemberController {
    private final IMemberService memberService;

    @GetMapping
    public String showMemberLoginPage() {
        return "member/loginPage";
    }

    @PostMapping("/login")
    public String memberLogin(@RequestParam String email, @RequestParam String password, HttpServletRequest req) {
        HttpSession session = req.getSession();
        Member member = Member.builder().email(email).password(password).build();
        Member selectedMember = memberService.findByMemberWithIdPw(member);
        session.setAttribute("memberId", selectedMember.getId());
        if(selectedMember == null) {
            return "member/loginPage";
        } else {
            return "redirect:/todo";
        }
    }

    @GetMapping("/logout")
    public String memberLogout(HttpServletRequest req) {
        HttpSession session = req.getSession();
        session.invalidate();
        return "/member/loginPage";
    }

    @GetMapping("/register")
    public String showMemberRegisterPage() {
        return "member/registerPage";
    }

    @PostMapping("/register")
    public String memberRegister(@RequestParam String email, @RequestParam String password) {
        Member member = Member.builder().email(email).password(password).build();
        Member registeredMember = memberService.saveMember(member);
        if(registeredMember == null) {
            return "회원가입 실패";
        } else {
            return "member/loginPage";
        }
    }


}
