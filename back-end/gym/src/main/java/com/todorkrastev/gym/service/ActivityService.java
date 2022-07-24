package com.todorkrastev.gym.service;

import com.todorkrastev.gym.model.dto.ActivityDTO;

import java.util.List;
import java.util.Optional;

public interface ActivityService {
    List<ActivityDTO> findAll();

    ActivityDTO getActivityById(Long activityId);

    ActivityDTO updateActivityById(Long activityId, ActivityDTO activityDTO);

    Long createActivity(ActivityDTO newActivity);

    void deleteActivityById(Long activityId);
}
