package com.todorkrastev.gym.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RegisterDTO {

    private String username;
    private String email;
    private String password;

    public RegisterDTO() {
    }

    @NotBlank(message = "Username must not be null and must contain at least one non-whitespace character!")
    @Size(min = 1, message = "Username must have at least 1 character!")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Email(regexp = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$", message = "Enter valid email address!")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
