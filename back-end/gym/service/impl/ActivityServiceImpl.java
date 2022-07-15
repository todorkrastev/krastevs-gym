package com.todorkrastev.gym.service.impl;

import com.todorkrastev.gym.model.dto.activity.EditActivityDTO;
import com.todorkrastev.gym.model.dto.activity.GetAllActivitiesDTO;
import com.todorkrastev.gym.model.entity.Activity;
import com.todorkrastev.gym.repository.ActivityRepository;
import com.todorkrastev.gym.service.ActivityService;
import org.modelmapper.ModelMapper;
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
    public List<GetAllActivitiesDTO> findAll() {

        return this.activityRepository
                .findAll()
                .stream()
                .map(activity -> this.modelMapper.map(activity, GetAllActivitiesDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean editActivityById(Long activityId, EditActivityDTO editActivityDTO) {
        Optional<Activity> activityToUpdate = this.activityRepository.findById(activityId);

        activityToUpdate.ifPresent(activity -> {
            activity.setTitle(editActivityDTO.getTitle());
            activity.setDescription(editActivityDTO.getDescription());
            activity.setFile(editActivityDTO.getFile());
        });

        if (activityToUpdate.isPresent()) {
            Activity activity = modelMapper.map(activityToUpdate, Activity.class);

            this.activityRepository.save(activity);

            return true;
        }

        return false;
    }
}
