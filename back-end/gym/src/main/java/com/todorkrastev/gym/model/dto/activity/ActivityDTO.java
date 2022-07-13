package com.todorkrastev.gym.model.dto.activity;

public class ActivityDTO {

    private String title;
    private String shortDescription;
    private String longDescription;

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

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }
}
