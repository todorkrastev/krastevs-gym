package com.todorkrastev.gym.controller;

import com.todorkrastev.gym.model.dto.CourseDTO;
import com.todorkrastev.gym.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

// TODO: try cross origin with http://localhost:5500/
@CrossOrigin
@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCourses() {
        return ResponseEntity.ok(this.courseService.findAll());
    }

    @PostMapping("/add-course")
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO newCourse,
                                                  UriComponentsBuilder uriComponentsBuilder) {
        Long newCourseId = this.courseService.createCourse(newCourse);

        return ResponseEntity
                .created(uriComponentsBuilder.path("/courses/{id}")
                        .build(newCourseId))
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> updateCourseById(@PathVariable("id") Long courseId,
                                                      @RequestBody CourseDTO courseDTO) {
        //TODO: Make a validation if the admin is doing the change

        CourseDTO courseResponse = this.courseService.updateCourseById(courseId, courseDTO);

        return ResponseEntity.ok(courseResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CourseDTO> deleteCourseById(@PathVariable("id") Long courseId) {
        this.courseService.deleteCourseById(courseId);

        return ResponseEntity
                .noContent()
                .build();
    }
}
