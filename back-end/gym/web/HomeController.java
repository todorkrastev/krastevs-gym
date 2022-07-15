package com.todorkrastev.gym.web;

import com.todorkrastev.gym.model.dto.activity.EditActivityDTO;
import com.todorkrastev.gym.model.dto.activity.GetAllActivitiesDTO;
import com.todorkrastev.gym.service.ActivityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// TODO: try cross origin with http://localhost:5500/
@CrossOrigin
@RestController
public class HomeController {

    private final ActivityService activityService;

    public HomeController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/")
    public ResponseEntity<List<GetAllActivitiesDTO>> getAllActivities() {
        return ResponseEntity
                .ok(activityService.findAll());
    }
    
    @PutMapping("/activities/edit/{id}")
    public ResponseEntity<EditActivityDTO> editActivityDTO(@PathVariable("id") Long activityId, @RequestBody EditActivityDTO editActivityDTO) {
        boolean isActivityEdited = activityService.editActivityById(activityId, editActivityDTO);

        //TODO: Find out how to return the response to the front end
        //TODO: Should I use PUT or PATCH annotation when I am updating in the database

        return null;
    }
}
