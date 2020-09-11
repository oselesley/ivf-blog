package com.isaiahfreshblog.demo.controllers;

import com.isaiahfreshblog.demo.models.Post;
import com.isaiahfreshblog.demo.models.User;
import com.isaiahfreshblog.demo.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/posts")
public class PostController {
    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String getPosts(Model model, HttpSession session) {
        Object userObj = session.getAttribute("user");
        if (userObj == null) return "redirect:/auth/login";
        model.addAttribute("user", (User) userObj);
        model.addAttribute("posts", postService.getPosts());
        model.addAttribute("newpost", new Post());
        return "home";
    }

    @PostMapping("/new")
    public String newPost(HttpSession session, @Valid Post post) {
        Object userObj = session.getAttribute("user");
        if (userObj == null) return "redirect:/auth/login";
        postService.createPost(post);
        return "redirect:/posts/";
    }
}
