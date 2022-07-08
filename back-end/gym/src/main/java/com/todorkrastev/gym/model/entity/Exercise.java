package com.todorkrastev.gym.model.entity;

import com.todorkrastev.gym.model.entity.enums.CategoryLevel;
import com.todorkrastev.gym.model.entity.enums.CategoryName;

import javax.persistence.*;

@Entity
@Table(name = "exercises")
public class Exercise extends BaseEntity {

    private String name;
    private String instruction;
    private CategoryName categoryName;
    private CategoryLevel categoryLevel;

    public Exercise() {
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "instruction", nullable = false)
    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    @Enumerated(EnumType.STRING)
    public CategoryName getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(CategoryName categoryName) {
        this.categoryName = categoryName;
    }

    @Enumerated(EnumType.STRING)
    public CategoryLevel getCategoryLevel() {
        return categoryLevel;
    }

    public void setCategoryLevel(CategoryLevel categoryLevel) {
        this.categoryLevel = categoryLevel;
    }
}
