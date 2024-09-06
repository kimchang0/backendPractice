package dev.spring.todo.todo_project.controller;

import dev.spring.todo.todo_project.model.Category;
import dev.spring.todo.todo_project.model.Todo;
import dev.spring.todo.todo_project.service.ITodoService;
import dev.spring.todo.todo_project.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {

    private final ITodoService todoService;

    @GetMapping
    public String showTodoPage (HttpServletRequest req, Model model) {
        HttpSession session = req.getSession();
        if(session.getAttribute("memberId") == null) {
            return "member/loginPage";
        } else {
            List<Category> categories = todoService.getCategory();
            model.addAttribute("categories", categories);
            List<Todo> todos = todoService.getAllTodoByMemberId((Long) session.getAttribute("memberId"));
            model.addAttribute("todos", todos);
            return "todo/todoListPage";
        }
    }

    public String addTodo (HttpServletRequest req, @RequestParam String title, @RequestParam String description, @RequestParam Long categoryId) {
        HttpSession session = req.getSession();
        if(session.getAttribute("memberId") == null) {
            return "member/loginPage";
        } else {

            return "redirect:/todo/todoListPage";
        }
    }

    public String updateTodo (HttpServletRequest req) {
        HttpSession session = req.getSession();
        if(session.getAttribute("memberId") == null) {
            return "member/loginPage";
        } else {
            return "redirect:/todo/todoListPage";
        }
    }

    public String deleteTodo (HttpServletRequest req) {
        HttpSession session = req.getSession();
        if(session.getAttribute("memberId") == null) {
            return "member/loginPage";
        } else {
            return "redirect:/todo/todoListPage";
        }
    }
}
