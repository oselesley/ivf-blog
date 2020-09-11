package com.isaiahfreshblog.demo.controllers;

import com.isaiahfreshblog.demo.models.User;
import com.isaiahfreshblog.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class SigninController {
    private UserService userService;

    public SigninController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("invalid", null);
        return "signin";
    }

    @PostMapping("/login")
    public String login (HttpSession session, @Valid User user, Model model) {
        User gottenUser = userService.getUser(user.getEmail());
        if (gottenUser == null || !gottenUser.getPassword().equals(user.getPassword())) {
            model.addAttribute("invalid", "Invalid username or password");
            return "signin";
        }
        gottenUser.setPassword("");
        session.setAttribute("user", gottenUser);
        return "redirect:/posts/";
    }
}
