package com.todorkrastev.gym.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "activities")
public class Activity extends BaseEntity {

    private String title;
    private String shortDescription;
    private String longDescription;

    //TODO: How to store in the database picture
    //TODO: If you are running out of time, just add to the database urls.

    //private String picture;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return Objects.equals(title, activity.title) && Objects.equals(shortDescription, activity.shortDescription) && Objects.equals(longDescription, activity.longDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, shortDescription, longDescription);
    }

    @Override
    public String toString() {
        return "Activity{" +
                "title='" + title + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                '}';
    }
}
