package com.mahtzak.pizzeriamanagementapp.web.controllers;


import com.mahtzak.pizzeriamanagementapp.domain.model.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/jsp-test")
public class JspTestController {

    @GetMapping
    public String getTestPage(Principal principal, Model model) {
        String name = principal.getName();
        model.addAttribute("user", name);
        return "test";
    }
}
