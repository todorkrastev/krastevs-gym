package com.todorkrastev.gym.controller;

import com.todorkrastev.gym.model.dto.ExerciseByCategoryDTO;
import com.todorkrastev.gym.model.dto.ExerciseDTO;
import com.todorkrastev.gym.service.ExerciseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

// TODO: try cross origin with http://localhost:5500/
@CrossOrigin
@RestController
@RequestMapping("/api/v1/exercises")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping
    public ResponseEntity<List<ExerciseByCategoryDTO>> getAllExercises() {
        return ResponseEntity
                .ok(this.exerciseService.findAll());
    }

    @PostMapping("/add-exercise")
    public ResponseEntity<ExerciseDTO> createExercise(@Valid @RequestBody ExerciseDTO newExercise,
                                                      UriComponentsBuilder uriComponentsBuilder) {
        //TODO: throw an exception if so tries to create the same exercise which is already in the DB

        Long newExerciseId = this.exerciseService.createExercise(newExercise);

        return ResponseEntity
                .created(uriComponentsBuilder.path("/api/exercises/{id}")
                        .build(newExerciseId))
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExerciseDTO> updateExerciseById(@PathVariable("id") Long exerciseId,
                                                          @Valid @RequestBody ExerciseDTO exerciseDTO) {
        //TODO: Make a validation if the admin is doing the change

        ExerciseDTO exerciseResponse = this.exerciseService.updateExerciseById(exerciseId, exerciseDTO);

        return ResponseEntity.ok(exerciseResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ExerciseDTO> deleteExerciseById(@PathVariable("id") Long exerciseId) {
        this.exerciseService.deleteExerciseById(exerciseId);

        return ResponseEntity
                .noContent()
                .build();
    }

    @GetMapping("/abs")
    public ResponseEntity<List<ExerciseByCategoryDTO>> getExerciseByCategoryAbs() {
        //TODO: Pagination and Sorting
        return ResponseEntity
                .ok(this.exerciseService.findByExerciseCategoryAbs());
    }

    @GetMapping("/arms")
    public ResponseEntity<List<ExerciseByCategoryDTO>> getExerciseByCategoryArms() {
        //TODO: Pagination and Sorting
        return ResponseEntity
                .ok(this.exerciseService.findByExerciseCategoryArms());
    }

    @GetMapping("/back")
    public ResponseEntity<List<ExerciseByCategoryDTO>> getExerciseByCategoryBack() {
        //TODO: Pagination and Sorting
        return ResponseEntity
                .ok(this.exerciseService.findByExerciseCategoryBack());
    }

    @GetMapping("/chest")
    public ResponseEntity<List<ExerciseByCategoryDTO>> getExerciseByCategoryChest() {
        //TODO: Pagination and Sorting
        return ResponseEntity
                .ok(this.exerciseService.findByExerciseCategoryChest());
    }

    @GetMapping("/legs")
    public ResponseEntity<List<ExerciseByCategoryDTO>> getExerciseByCategoryLegs() {
        //TODO: Pagination and Sorting
        return ResponseEntity
                .ok(this.exerciseService.findByExerciseCategoryLegs());
    }

    @GetMapping("/shoulders")
    public ResponseEntity<List<ExerciseByCategoryDTO>> getExerciseByCategoryShoulders() {
        //TODO: Pagination and Sorting
        return ResponseEntity
                .ok(this.exerciseService.findByExerciseCategoryShoulders());
    }
}
