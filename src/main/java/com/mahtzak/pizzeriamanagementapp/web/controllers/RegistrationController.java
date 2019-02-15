package com.mahtzak.pizzeriamanagementapp.web.controllers;


import com.mahtzak.pizzeriamanagementapp.core.RegistrationService;
import com.mahtzak.pizzeriamanagementapp.domain.model.User;
import com.mahtzak.pizzeriamanagementapp.domain.repositories.UserRepository;
import com.mahtzak.pizzeriamanagementapp.web.dtos.RegistrationFormDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/*@Controller
@RequestMapping("/register")
public class RegistrationController {

    private RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String prepareRegistrationForm(Model model) {
        model.addAttribute("registrationForm", new RegistrationFormDTO());
        return "register-form";
    }

    @PostMapping
    public String registerUser(@Valid RegistrationFormDTO form, BindingResult result) {
        if(result.hasErrors()){
            return "register-form";
        }

        boolean success = registrationService.register(form);
        if (success) {
            return "redirect: /login";
        }else{
            result.rejectValue("email", null, "Coś poszło nie tak");
            return "register-form";
        }
    }

}*/

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private RegistrationService registrationService;
    private UserRepository userRepository;

    public RegistrationController(RegistrationService registrationService, UserRepository userRepository) {
        this.registrationService = registrationService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public String prepareRegistrationForm(Model model) {
        model.addAttribute("registrationForm", new RegistrationFormDTO());
        return "register-form";
    }

    @PostMapping
    public String registerUser(@ModelAttribute("registrationForm") @Valid RegistrationFormDTO form, BindingResult result) {
        if (result.hasErrors()) {
            return "register-form";
        }
        User userByEmail = userRepository.findFirstByEmail(form.getEmail());
        User userByUsername = userRepository.findFirstByUsername(form.getUsername());

        if (userByEmail != null || userByUsername != null ||
                !form.getPassword().equals(form.getConfirmedPassword())){
            if(userByEmail != null) {
                result.rejectValue("email", null,
                        "Podany email już istnieje w bazie");
            }
            if (userByUsername != null) {
                result.rejectValue("username", null,
                        "Podana nazwa użytkownika jest już zajęta");
            }
            if (!form.getPassword().equals(form.getConfirmedPassword())){
                result.rejectValue("confirmedPassword", null,
                        "Nie powtórzono poprawnie hasła");
            }
            return "register-form";
        }

        boolean success = registrationService.register(form);
        if (success) {
            return "redirect:/login";
        }
        else {
            result.rejectValue("email", null, "Coś poszło nie tak. Spróbuj ponownie");
            return "register-form";
        }
    }
}

//działam
