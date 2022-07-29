package com.todorkrastev.gym.service;

import com.todorkrastev.gym.model.dto.ActivityDTO;

import java.util.List;

public interface ActivityService {
    List<ActivityDTO> findAll();

    ActivityDTO getActivityById(Long activityId);

    ActivityDTO updateActivityById(Long activityId, ActivityDTO activityDTO);

    Long createActivity(ActivityDTO newActivity);

    void deleteActivityById(Long activityId);
}
