package com.mahtzak.pizzeriamanagementapp.web.controllers;


import com.mahtzak.pizzeriamanagementapp.domain.repositories.UserRoleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/employees")
public class EmployeeManagementController {

    UserRoleRepository userRoleRepository;

    public EmployeeManagementController(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @GetMapping
    public String seeAllEmployees(Model model){
        model.addAttribute("employees",userRoleRepository.findAllUsersByRole("ROLE_EMPLOYEE"));
        return "all-employees";
    }
}
