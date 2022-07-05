package com.todorkrastev.gym.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("/register")
    public String register(Model model) {
        return "register";
    }

    @GetMapping("/users/login")
    public String login() {
        return "login";
    }

}
