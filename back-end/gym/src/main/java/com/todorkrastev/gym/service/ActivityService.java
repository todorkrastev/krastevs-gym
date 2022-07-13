package com.todorkrastev.gym.service;

import com.todorkrastev.gym.model.dto.activity.FindAllDTO;

import java.util.List;

public interface ActivityService {
    List<FindAllDTO> findAll();
}
