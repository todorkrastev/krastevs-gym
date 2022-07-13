package com.todorkrastev.gym.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/register")
    public ModelAndView register(ModelAndView modelAndView) {
        modelAndView.addObject("message", "Welcome");
        modelAndView.setViewName("register");
        return modelAndView;

    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
