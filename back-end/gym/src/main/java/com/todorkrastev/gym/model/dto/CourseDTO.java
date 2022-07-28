package com.todorkrastev.gym.model.dto;

import com.todorkrastev.gym.model.entity.enums.CourseCategoryName;
import com.todorkrastev.gym.model.entity.enums.RoomCategoryName;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class CourseDTO {
    private CourseCategoryName courseCategoryName;
    private RoomCategoryName roomCategoryName;
    private LocalDateTime dateTime;

    public CourseDTO() {
    }

    @NotNull(message = "You must select the category!")
    public CourseCategoryName getCourseCategoryName() {
        return courseCategoryName;
    }

    public void setCourseCategoryName(CourseCategoryName courseCategoryName) {
        this.courseCategoryName = courseCategoryName;
    }

    @NotNull(message = "You must select the category!")
    public RoomCategoryName getRoomCategoryName() {
        return roomCategoryName;
    }

    public void setRoomCategoryName(RoomCategoryName roomCategoryName) {
        this.roomCategoryName = roomCategoryName;
    }

    @NotNull(message = "You must select the date and time!")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @FutureOrPresent(message = "The date must be an instant, date or time in the present or in the future!")
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
