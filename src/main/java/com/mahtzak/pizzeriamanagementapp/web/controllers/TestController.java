package com.mahtzak.pizzeriamanagementapp.web.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")

public class TestController {

    @RequestMapping
    @ResponseBody
    public String hello(){
        return "hello, spring";
    }
}
