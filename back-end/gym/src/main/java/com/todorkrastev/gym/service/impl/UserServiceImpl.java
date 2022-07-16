package com.todorkrastev.gym.service.impl;

import com.todorkrastev.gym.repository.UserRepository;
import com.todorkrastev.gym.service.UserService;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
