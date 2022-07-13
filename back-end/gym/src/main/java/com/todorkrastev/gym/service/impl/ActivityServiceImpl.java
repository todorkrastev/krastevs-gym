package com.todorkrastev.gym.service.impl;

import com.todorkrastev.gym.model.dto.activity.FindAllDTO;
import com.todorkrastev.gym.repository.ActivityRepository;
import com.todorkrastev.gym.service.ActivityService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public List<FindAllDTO> findAll() {
        return this.activityRepository
                .findAll()
                .stream()
                .map(activity -> this.modelMapper.map(activity, FindAllDTO.class))
                .collect(Collectors.toList());
    }
}
