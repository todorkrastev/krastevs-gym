package com.todorkrastev.gym.web;

import com.todorkrastev.gym.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

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
