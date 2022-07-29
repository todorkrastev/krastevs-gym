package com.todorkrastev.gym.service;

public interface UserService {
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
