package com.todorkrastev.gym.repository;

import com.todorkrastev.gym.model.entity.Exercise;
import com.todorkrastev.gym.model.entity.enums.ExerciseCategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    List<Exercise> findByExerciseCategoryName(ExerciseCategoryName exerciseCategoryName);
}
