package com.mahtzak.pizzeriamanagementapp.web.controllers;


import com.mahtzak.pizzeriamanagementapp.domain.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/oldregister")
public class RegisterController {

    @GetMapping
    public String prepareRegisterForm(Model model){
        model.addAttribute("user",new User());
        return "register-form";
    }

    @PostMapping
    public String registerUser(@Valid User user, BindingResult result,
                               HttpSession session){
        if(result.hasErrors()){
            return "register-form";
        }
        return "/";
    }
}
