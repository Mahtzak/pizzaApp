package com.mahtzak.pizzeriamanagementapp.web.controllers;


import com.mahtzak.pizzeriamanagementapp.domain.model.Comment;
import com.mahtzak.pizzeriamanagementapp.domain.model.User;
import com.mahtzak.pizzeriamanagementapp.domain.repositories.CommentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/comment")
public class CommentController {

    CommentRepository commentRepository;

    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @GetMapping("/add")
    public String commentForm(Model model){
        model.addAttribute("comment",new Comment());
        return "add-comment";
    }

    @PostMapping("/add")
    public String saveComment(@ModelAttribute("comment") @Valid Comment comment,
                              BindingResult result, @SessionAttribute(name = "user") User user){
        if(result.hasErrors()){
            return "add-comment";
        }
        comment.setUser(user);
        comment.setCreated(LocalDateTime.now());
        commentRepository.save(comment);
        return "landing-site";
    }
}
