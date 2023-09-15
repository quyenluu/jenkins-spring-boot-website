package com.example.springbootwebsite.controllers;

import com.example.springbootwebsite.models.Todo;
import com.example.springbootwebsite.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class TodoController {
    @Autowired
    private TodoService todoService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    /*
    * @RequestParam dùng để đánh dấu một biến là request param trong request gửi lên server.
    * Nó sẽ gán dữ liệu của param-name tương ứng vào biến
    */
    @RequestMapping("/listTodo")
    public String listTodo(Model model, @RequestParam(value = "limit", required = false) Integer limit) {
        // Trả về đối tượng todoList
        model.addAttribute("todoList", todoService.findAll(limit));
        // Trả về template "listTodo.html"
        return "listTodo";
    }

    // Chuyển đến template "addTodo.html"
    @GetMapping("/addTodo")
    public String addTodo(Model model) {
        model.addAttribute("todo", new Todo());
        return "addTodo";
    }

    /*
    * @ModelAttribute đánh dấu đối tượng Todo được gửi lên bởi Form Request
    */
    @PostMapping("/addTodo")
    public String addTodo(@ModelAttribute Todo todo) {
        return Optional.ofNullable(todoService.add(todo))
                .map(t -> "success")// Trả về success nếu save thành công
                .orElse("failed"); // Trả về failed nếu không thành công
    }
}
