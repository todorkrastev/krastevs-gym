package com.todorkrastev.gym.service.impl;

import com.todorkrastev.gym.exception.ResourceNotFoundException;
import com.todorkrastev.gym.model.dto.ActivityDTO;
import com.todorkrastev.gym.model.entity.Activity;
import com.todorkrastev.gym.repository.ActivityRepository;
import com.todorkrastev.gym.service.ActivityService;
import org.modelmapper.ModelMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;
    private final ModelMapper modelMapper;

    public ActivityServiceImpl(ActivityRepository activityRepository, ModelMapper modelMapper) {
        this.activityRepository = activityRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ActivityDTO> findAll() {

        return this.activityRepository
                .findAll()
                .stream()
                .map(activity -> this.modelMapper.map(activity, ActivityDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ActivityDTO getActivityById(Long activityId) {
        Activity activity = this.activityRepository.findById(activityId).orElseThrow(() -> new ResourceNotFoundException("Activity", "id", activityId));

        return this.modelMapper.map(activity, ActivityDTO.class);

        /*
        return this.activityRepository
                .findById(activityId)
                .map(activity ->
                        this.modelMapper
                                .map(activity, ActivityDTO.class));

         */
    }

    @Override
    public Long createActivity(ActivityDTO newActivity) {
        Activity activityToSave = this.modelMapper.map(newActivity, Activity.class);

        this.activityRepository.save(activityToSave);

        return activityToSave.getId();
    }


    @Override
    public ActivityDTO updateActivityById(Long activityId, ActivityDTO activityDTO) {

        //TODO: Make a validation if the admin is doing the change

        Activity activity = this.activityRepository.findById(activityId).orElseThrow(() -> new ResourceNotFoundException("Activity", "id", activityId));

        activity.setTitle(activityDTO.getTitle());
        activity.setDescription(activityDTO.getDescription());
        activity.setFile(activityDTO.getDescription());

        Activity updatedActivity = this.activityRepository.save(activity);

        return this.modelMapper.map(updatedActivity, ActivityDTO.class);
    }

    @Override
    public void deleteActivityById(Long activityId) {
        Activity activity = this.activityRepository.findById(activityId).orElseThrow(() -> new ResourceNotFoundException("Activity", "id", activityId));

        this.activityRepository.delete(activity);
    }
}
