package com.todorkrastev.gym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// Remove "Using default security password" on Spring Boot
// https://stackoverflow.com/questions/30761253/remove-using-default-security-password-on-spring-boot/41856630#41856630
// (exclude = {SecurityAutoConfiguration.class })
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class GymApplication {

    public static void main(String[] args) {
        SpringApplication.run(GymApplication.class, args);
    }
}
