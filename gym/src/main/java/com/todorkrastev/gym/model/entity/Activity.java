package com.todorkrastev.gym.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "activities")
public class Activity extends BaseEntity {

    private String title;
    private String shortDescription;
    private String longDescription;

    //TODO: How to store in the database main and secondary pictures

    //private String mainPicture;
    //private Set<String> secondaryPictures;


    public Activity() {
    }

    @Column(name = "title", nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "short_description", nullable = false, columnDefinition = "TINYTEXT")
    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @Column(name = "long_description", nullable = false, columnDefinition = "TEXT")
    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }
}
