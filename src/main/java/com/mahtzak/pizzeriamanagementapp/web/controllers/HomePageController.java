package com.mahtzak.pizzeriamanagementapp.web.controllers;


import com.mahtzak.pizzeriamanagementapp.domain.model.Comment;
import com.mahtzak.pizzeriamanagementapp.domain.repositories.CommentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomePageController {

    CommentRepository commentRepository;

    public HomePageController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @ModelAttribute("allComments")
    public List<Comment> allComments() {
        return commentRepository.getAllComments();
    }

    @GetMapping
    public String landingSite(){
        return "landing-site";
    }
}
