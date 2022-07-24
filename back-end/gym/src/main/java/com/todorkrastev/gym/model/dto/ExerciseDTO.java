package com.todorkrastev.gym.model.dto;

import com.todorkrastev.gym.model.entity.enums.ExerciseCategoryName;

public class ExerciseDTO {
    private String name;
    private ExerciseCategoryName exerciseCategoryName;
    private String file;

    public ExerciseDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExerciseCategoryName getExerciseCategoryName() {
        return exerciseCategoryName;
    }

    public void setExerciseCategoryName(ExerciseCategoryName exerciseCategoryName) {
        this.exerciseCategoryName = exerciseCategoryName;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
