package com.todorkrastev.gym.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginDTO {
    private String usernameOrEmail;
    private String password;

    public LoginDTO() {
    }

    @NotBlank(message = "Username or Email must not be null and must contain at least one non-whitespace character!")
    @Size(min = 1, message = "Username or Email must have at least 1 character!")
    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    public void setUsernameOrEmail(String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
    }

    @NotBlank(message = "Password must not be null and must contain at least one non-whitespace character!")
    @Size(min = 5, message = "Password must have at least 5 character!")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
