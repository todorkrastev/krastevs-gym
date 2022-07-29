package com.todorkrastev.gym.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ActivityDTO {

    private String title;
    private String description;
    private String file;

    //TODO: add field picture when you find out how to store pictures in the database
    //TODO: first you need to add the field in model -> entity -> Activity.java


    public ActivityDTO() {
    }

    @NotBlank(message = "Title must not be null and must contain at least one non-whitespace character!")
    @Size(min = 1, message = "Title must have at least 1 character!")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NotBlank(message = "Description must not be null and must contain at least one non-whitespace character!")
    @Size(min = 1, message = "Description must have at least 1 character!")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotBlank(message = "File must not be null and must contain at least one non-whitespace character!")
    @Size(min = 1, message = "File must have at least 1 character!")
    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
