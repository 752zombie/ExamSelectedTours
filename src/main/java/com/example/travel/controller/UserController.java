package com.example.travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {



    @GetMapping("/")
    public String index() {
        return "createUser";
    }

    @GetMapping("/createUser/{id}")
    public String activityPage(@PathVariable("id") Integer id) {
        return "createUser";
    }

}
