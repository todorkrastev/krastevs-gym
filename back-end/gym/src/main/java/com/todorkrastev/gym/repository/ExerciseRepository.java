package com.todorkrastev.gym.repository;

import com.todorkrastev.gym.model.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    @Query("SELECT e FROM Exercise e WHERE e.exerciseCategoryName = 'ABS' ")
    List<Exercise> findAllByCategoryNameAbs();

    @Query("SELECT e FROM Exercise e WHERE e.exerciseCategoryName = 'ARMS' ")
    List<Exercise> findAllByCategoryNameArms();

    @Query("SELECT e FROM Exercise e WHERE e.exerciseCategoryName = 'BACK' ")
    List<Exercise> findAllByCategoryNameBack();

    @Query("SELECT e FROM Exercise e WHERE e.exerciseCategoryName = 'CHEST' ")
    List<Exercise> findAllByCategoryNameChest();

    @Query("SELECT e FROM Exercise e WHERE e.exerciseCategoryName = 'LEGS' ")
    List<Exercise> findAllByCategoryNameLegs();

    @Query("SELECT e FROM Exercise e WHERE e.exerciseCategoryName = 'SHOULDERS' ")
    List<Exercise> findAllByCategoryNameShoulders();
}
