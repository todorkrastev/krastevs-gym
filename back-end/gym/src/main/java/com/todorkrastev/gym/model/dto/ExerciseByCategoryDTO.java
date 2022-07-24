package com.todorkrastev.gym.model.dto;

import com.todorkrastev.gym.model.entity.enums.ExerciseCategoryName;

public class ExerciseByCategoryDTO {
    private String name;
    private String file;

    public ExerciseByCategoryDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
