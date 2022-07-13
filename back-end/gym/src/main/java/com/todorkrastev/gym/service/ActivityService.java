package com.todorkrastev.gym.service;

import com.todorkrastev.gym.model.dto.activity.ActivityDTO;

import java.util.List;

public interface ActivityService {
    List<ActivityDTO> findAll();
}
