package com.todorkrastev.gym.service;

import com.todorkrastev.gym.model.dto.RegisterDTO;

public interface UserService {
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    void init();

    void registerUser(RegisterDTO registerDTO);
}
