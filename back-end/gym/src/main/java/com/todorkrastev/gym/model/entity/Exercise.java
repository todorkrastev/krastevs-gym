package com.todorkrastev.gym.model.entity;

import com.todorkrastev.gym.model.entity.enums.ExerciseCategoryName;

import javax.persistence.*;

@Entity
@Table(name = "exercises")
public class Exercise extends BaseEntity {

    private String name;
    private ExerciseCategoryName exerciseCategoryName;
    private String file;

    //TODO: How to store in the database video
    //TODO: If you are running out of time, just add to the database urls.

    public Exercise() {
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "exercise_category_name", nullable = false)
    @Enumerated(EnumType.STRING)
    public ExerciseCategoryName getExerciseCategoryName() {
        return exerciseCategoryName;
    }

    public void setExerciseCategoryName(ExerciseCategoryName exerciseCategoryName) {
        this.exerciseCategoryName = exerciseCategoryName;
    }

    @Column(name = "file", nullable = false)
    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
