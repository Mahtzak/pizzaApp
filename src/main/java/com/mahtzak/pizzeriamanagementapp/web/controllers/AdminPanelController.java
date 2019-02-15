package com.mahtzak.pizzeriamanagementapp.web.controllers;


import com.mahtzak.pizzeriamanagementapp.domain.repositories.UserRepository;
import com.mahtzak.pizzeriamanagementapp.domain.repositories.UserRoleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminPanelController {

    UserRepository userRepository;
    UserRoleRepository userRoleRepository;

    public AdminPanelController(UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @GetMapping
    public String processToAdminPanel(){
        return "administration-panel";
    }


    @GetMapping("/addEmployee")
    public String changesStatusToEmployee(Model model){
        model.addAttribute("users",userRoleRepository.findAll());
        return "change-user-status";
    }
}

