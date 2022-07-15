package com.todorkrastev.gym.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "activities")
public class Activity extends BaseEntity {

    private String title;
    private String description;
    private String file;

    //TODO: How to store in the database picture
    //TODO: If you are running out of time, just add to the database urls.

    public Activity() {
    }

    @Column(name = "title", nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "description", nullable = false, columnDefinition = "TINYTEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "file", nullable = false)
    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
