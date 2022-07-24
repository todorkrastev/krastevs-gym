package com.todorkrastev.gym.service;

import com.todorkrastev.gym.model.dto.CourseDTO;

import java.util.List;

public interface CourseService {
    List<CourseDTO> findAll();

    Long createCourse(CourseDTO newCourse);

    CourseDTO updateCourseById(Long courseId, CourseDTO courseDTO);

    void deleteCourseById(Long courseId);
}
