package com.todorkrastev.gym.init;

import com.todorkrastev.gym.service.impl.RoleServiceImpl;
import com.todorkrastev.gym.service.impl.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppInit implements CommandLineRunner {

    private final RoleServiceImpl roleService;
    private final UserServiceImpl userService;

    public AppInit(RoleServiceImpl roleService, UserServiceImpl userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.roleService.init();
        this.userService.init();
    }
}
