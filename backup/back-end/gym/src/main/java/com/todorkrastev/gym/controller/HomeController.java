package com.todorkrastev.gym.controller;

import com.todorkrastev.gym.model.dto.ActivityDTO;
import com.todorkrastev.gym.service.ActivityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

// TODO: try cross origin with http://localhost:5500/
@CrossOrigin
@RestController
@RequestMapping("/api")
public class HomeController {

    private final ActivityService activityService;

    public HomeController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping
    public ResponseEntity<List<ActivityDTO>> getAllActivities() {
        return ResponseEntity
                .ok(this.activityService.findAll());
    }

    @GetMapping("/activities/{id}")
    public ResponseEntity<ActivityDTO> getActivityById(@PathVariable("id") Long activityId) {
        return ResponseEntity.ok(this.activityService.getActivityById(activityId));
    }

    @PostMapping("/activities")
    public ResponseEntity<ActivityDTO> createActivity(@RequestBody ActivityDTO newActivity,
                                                      UriComponentsBuilder uriComponentsBuilder) {
        Long newActivityId = this.activityService.createActivity(newActivity);

        return ResponseEntity
                .created(uriComponentsBuilder.path("/api/activities/{id}")
                        .build(newActivityId))
                .build();
    }

    @PutMapping("/activities/{id}")
    public ResponseEntity<ActivityDTO> updateActivityById(@PathVariable("id") Long activityId,
                                                          @RequestBody ActivityDTO activityDTO) {
        //TODO: Make a validation if the admin is doing the change

        ActivityDTO activityResponse = this.activityService.updateActivityById(activityId, activityDTO);

        return ResponseEntity.ok(activityResponse);
    }

    @DeleteMapping("/activities/{id}")
    public ResponseEntity<ActivityDTO> deleteActivityById(@PathVariable("id") Long activityId) {
        this.activityService.deleteActivityById(activityId);

        return ResponseEntity
                .noContent()
                .build();
    }
}
