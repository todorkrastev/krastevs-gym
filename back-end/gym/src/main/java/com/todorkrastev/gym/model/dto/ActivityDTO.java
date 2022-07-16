package com.todorkrastev.gym.model.dto;

public class ActivityDTO {

    private String title;
    private String description;
    private String file;

    //TODO: add field picture when you find out how to store pictures in the database
    //TODO: first you need to add the field in model -> entity -> Activity.java


    public ActivityDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
