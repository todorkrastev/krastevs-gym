package com.todorkrastev.gym.controller;

import com.todorkrastev.gym.model.dto.ExerciseByCategoryDTO;
import com.todorkrastev.gym.model.dto.ExerciseDTO;
import com.todorkrastev.gym.model.entity.enums.ExerciseCategoryName;
import com.todorkrastev.gym.service.ExerciseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

// TODO: try cross origin with http://localhost:5500/
@CrossOrigin
@RestController
@RequestMapping("/api/exercises")
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
    public ResponseEntity<ExerciseDTO> createExercise(@RequestBody ExerciseDTO newExercise,
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
                                                          @RequestBody ExerciseDTO exerciseDTO) {
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
        return ResponseEntity
                .ok(this.exerciseService.findByExerciseCategoryAbs(ExerciseCategoryName.ABS));
    }

    @GetMapping("/arms")
    public ResponseEntity<List<ExerciseByCategoryDTO>> getExerciseByCategoryArms() {
        return ResponseEntity
                .ok(this.exerciseService.findByExerciseCategoryArms(ExerciseCategoryName.ARMS));
    }

    @GetMapping("/back")
    public ResponseEntity<List<ExerciseByCategoryDTO>> getExerciseByCategoryBack() {
        return ResponseEntity
                .ok(this.exerciseService.findByExerciseCategoryBack(ExerciseCategoryName.BACK));
    }

    @GetMapping("/chest")
    public ResponseEntity<List<ExerciseByCategoryDTO>> getExerciseByCategoryChest() {
        return ResponseEntity
                .ok(this.exerciseService.findByExerciseCategoryChest(ExerciseCategoryName.CHEST));
    }

    @GetMapping("/legs")
    public ResponseEntity<List<ExerciseByCategoryDTO>> getExerciseByCategoryLegs() {
        return ResponseEntity
                .ok(this.exerciseService.findByExerciseCategoryLegs(ExerciseCategoryName.LEGS));
    }

    @GetMapping("/shoulders")
    public ResponseEntity<List<ExerciseByCategoryDTO>> getExerciseByCategoryShoulders() {
        return ResponseEntity
                .ok(this.exerciseService.findByExerciseCategoryShoulders(ExerciseCategoryName.SHOULDERS));
    }
}
