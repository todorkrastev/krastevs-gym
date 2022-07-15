package com.todorkrastev.gym.service.impl;

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
    public Optional<ActivityDTO> getActivityById(Long activityId) {
        return this.activityRepository
                .findById(activityId)
                .map(activity ->
                        this.modelMapper
                                .map(activity, ActivityDTO.class));
    }

    @Override
    public Long createActivity(ActivityDTO newActivity) {
        Activity activityToSave = this.modelMapper.map(newActivity, Activity.class);

        this.activityRepository.save(activityToSave);

        return activityToSave.getId();
    }


    @Override
    public boolean editActivityById(Long activityId, ActivityDTO activityDTO) {

        //TODO: Make a validation if the admin is doing the change

        Optional<Activity> activityToUpdate = this.activityRepository.findById(activityId);

        if (activityToUpdate.isEmpty()) {
            return false;
        }

        activityToUpdate.ifPresent(activity -> {
            activity.setTitle(activityDTO.getTitle());
            activity.setDescription(activityDTO.getDescription());
            activity.setFile(activityDTO.getFile());
        });

        Activity activity = modelMapper.map(activityToUpdate, Activity.class);

        this.activityRepository.save(activity);

        return true;
    }

    @Override
    public void deleteActivityById(Long activityId) {
        try {
            this.activityRepository.deleteById(activityId);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
    }
}
