package com.mahtzak.pizzeriamanagementapp.web.controllers;


import com.mahtzak.pizzeriamanagementapp.domain.model.User;
import com.mahtzak.pizzeriamanagementapp.domain.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
@RequestMapping("/login")
public class LoginController {

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    public LoginController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String redirectToLoginSite(Model model){
        model.addAttribute("user", new User());
        return "login-form";
    }


//    @PostMapping
    public String loginUser (@Valid User user, BindingResult result,
                             HttpSession session, Model model){
        if (result.hasErrors()){
            return "login-form";
        }

        String encryptedPassword=passwordEncoder.encode(user.getPassword());
        User DBUser = userRepository.findByEmailAndPassword(user.getEmail(),
                encryptedPassword);
        if(DBUser==null){
            return "login-form";
        }else{
            session.setAttribute("user", user);
            return "redirect:/";
        }
    }
}
