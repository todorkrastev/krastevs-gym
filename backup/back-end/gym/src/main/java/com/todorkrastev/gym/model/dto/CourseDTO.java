package com.todorkrastev.gym.model.dto;

import com.todorkrastev.gym.model.entity.enums.CourseCategoryName;
import com.todorkrastev.gym.model.entity.enums.RoomCategoryName;

import java.time.LocalDateTime;

public class CourseDTO {
    private CourseCategoryName courseCategoryName;
    private RoomCategoryName roomCategoryName;
    private LocalDateTime dateTime;

    public CourseDTO() {
    }

    public CourseCategoryName getCourseCategoryName() {
        return courseCategoryName;
    }

    public void setCourseCategoryName(CourseCategoryName courseCategoryName) {
        this.courseCategoryName = courseCategoryName;
    }

    public RoomCategoryName getRoomCategoryName() {
        return roomCategoryName;
    }

    public void setRoomCategoryName(RoomCategoryName roomCategoryName) {
        this.roomCategoryName = roomCategoryName;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
