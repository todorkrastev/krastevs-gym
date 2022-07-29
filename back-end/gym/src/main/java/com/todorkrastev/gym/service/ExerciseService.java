package com.todorkrastev.gym.service;

import com.todorkrastev.gym.model.dto.ExerciseByCategoryDTO;
import com.todorkrastev.gym.model.dto.ExerciseDTO;

import java.util.List;

public interface ExerciseService {
    List<ExerciseByCategoryDTO> findAll();

    Long createExercise(ExerciseDTO newExercise);

    ExerciseDTO updateExerciseById(Long exerciseId, ExerciseDTO exerciseDTO);

    void deleteExerciseById(Long exerciseId);

    List<ExerciseByCategoryDTO>  findByExerciseCategoryAbs();

    List<ExerciseByCategoryDTO> findByExerciseCategoryArms();

    List<ExerciseByCategoryDTO> findByExerciseCategoryBack();

    List<ExerciseByCategoryDTO> findByExerciseCategoryChest();

    List<ExerciseByCategoryDTO> findByExerciseCategoryLegs();

    List<ExerciseByCategoryDTO> findByExerciseCategoryShoulders();

}
