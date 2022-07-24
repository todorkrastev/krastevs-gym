package com.todorkrastev.gym.service.impl;

import com.todorkrastev.gym.model.dto.CourseDTO;
import com.todorkrastev.gym.model.entity.Course;
import com.todorkrastev.gym.repository.CourseRepository;
import com.todorkrastev.gym.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    public CourseServiceImpl(CourseRepository courseRepository, ModelMapper modelMapper) {
        this.courseRepository = courseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CourseDTO> findAll() {
        return this.courseRepository
                .findAll()
                .stream()
                .map(course -> this.modelMapper.map(course, CourseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Long createCourse(CourseDTO newCourse) {
        Course courseToSave = this.modelMapper.map(newCourse, Course.class);

        this.courseRepository.save(courseToSave);

        return courseToSave.getId();
    }
}
