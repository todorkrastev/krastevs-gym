package com.todorkrastev.gym.service;

import com.todorkrastev.gym.model.dto.ExerciseByCategoryDTO;
import com.todorkrastev.gym.model.dto.ExerciseDTO;
import com.todorkrastev.gym.model.entity.enums.ExerciseCategoryName;

import java.util.List;

public interface ExerciseService {
    List<ExerciseByCategoryDTO> findAll();

    Long createExercise(ExerciseDTO newExercise);

    ExerciseDTO updateExerciseById(Long exerciseId, ExerciseDTO exerciseDTO);

    void deleteExerciseById(Long exerciseId);

    List<ExerciseByCategoryDTO> findByExerciseCategoryAbs(ExerciseCategoryName abs);

    List<ExerciseByCategoryDTO> findByExerciseCategoryArms(ExerciseCategoryName arms);

    List<ExerciseByCategoryDTO> findByExerciseCategoryBack(ExerciseCategoryName back);

    List<ExerciseByCategoryDTO> findByExerciseCategoryChest(ExerciseCategoryName chest);

    List<ExerciseByCategoryDTO> findByExerciseCategoryLegs(ExerciseCategoryName legs);

    List<ExerciseByCategoryDTO> findByExerciseCategoryShoulders(ExerciseCategoryName shoulders);

}
