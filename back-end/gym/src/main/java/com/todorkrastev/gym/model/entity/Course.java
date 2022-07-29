package com.todorkrastev.gym.model.entity;

import com.todorkrastev.gym.model.entity.enums.CourseCategoryName;
import com.todorkrastev.gym.model.entity.enums.RoomCategoryName;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "courses")
public class Course extends BaseEntity {

    private CourseCategoryName courseCategoryName;
    private RoomCategoryName roomCategoryName;
    private LocalDateTime dateTime;

    public Course() {
    }

    @Column(name = "course_category_name", nullable = false)
    @Enumerated(EnumType.STRING)
    public CourseCategoryName getCourseCategoryName() {
        return courseCategoryName;
    }

    public void setCourseCategoryName(CourseCategoryName courseCategoryName) {
        this.courseCategoryName = courseCategoryName;
    }

    @Column(name = "room_category_name", nullable = false)
    @Enumerated(EnumType.STRING)
    public RoomCategoryName getRoomCategoryName() {
        return roomCategoryName;
    }

    public void setRoomCategoryName(RoomCategoryName roomCategoryName) {
        this.roomCategoryName = roomCategoryName;
    }

    @Column(name = "date_time", nullable = false)
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
