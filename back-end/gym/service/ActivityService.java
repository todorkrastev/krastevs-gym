package com.todorkrastev.gym.service;

import com.todorkrastev.gym.model.dto.activity.EditActivityDTO;
import com.todorkrastev.gym.model.dto.activity.GetAllActivitiesDTO;

import java.util.List;

public interface ActivityService {
    List<GetAllActivitiesDTO> findAll();

    boolean editActivityById(Long activityId, EditActivityDTO editActivityDTO);
}
