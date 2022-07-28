package com.todorkrastev.gym.model.dto;

import com.todorkrastev.gym.model.entity.enums.ExerciseCategoryName;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ExerciseDTO {
    private String name;
    private ExerciseCategoryName exerciseCategoryName;
    private String file;

    public ExerciseDTO() {
    }

    @NotBlank(message = "Name must not be null and must contain at least one non-whitespace character!")
    @Size(min = 1, message = "Name must have at least 1 character!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull(message = "You must select the category!")
    public ExerciseCategoryName getExerciseCategoryName() {
        return exerciseCategoryName;
    }

    public void setExerciseCategoryName(ExerciseCategoryName exerciseCategoryName) {
        this.exerciseCategoryName = exerciseCategoryName;
    }

    @NotNull(message = "You must select the file!")
    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
