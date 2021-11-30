package com.example.travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {



    @GetMapping("/createUser")
    public String createUser() {
        return "createUser";
    }

    @GetMapping("/getUser/{id}")
    public String getUser(@PathVariable("id") Integer id) {
        return "createUser";
    }

    @GetMapping("/createAdmin")
    public String createAdmin() {
        return "createAdmin";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
