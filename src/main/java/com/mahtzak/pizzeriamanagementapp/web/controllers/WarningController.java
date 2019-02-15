package com.mahtzak.pizzeriamanagementapp.web.controllers;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class WarningController implements ErrorController {

    @RequestMapping(path = "/errorNotUsed", method = {RequestMethod.GET, RequestMethod.POST})
    public String redirectAfterError(){
        return "error-site";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
