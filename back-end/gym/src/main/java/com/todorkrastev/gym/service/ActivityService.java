package com.todorkrastev.gym.service;

import com.todorkrastev.gym.model.dto.ActivityDTO;

import java.util.List;
import java.util.Optional;

public interface ActivityService {
    List<ActivityDTO> findAll();

    Optional<ActivityDTO> getActivityById(Long activityId);

    boolean editActivityById(Long activityId, ActivityDTO activityDTO);

    Long createActivity(ActivityDTO newActivity);

    void deleteActivityById(Long activityId);
}
