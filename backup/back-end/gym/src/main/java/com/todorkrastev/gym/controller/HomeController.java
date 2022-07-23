package com.todorkrastev.gym.controller;

import com.todorkrastev.gym.model.dto.ActivityDTO;
import com.todorkrastev.gym.service.ActivityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

// TODO: try cross origin with http://localhost:5500/
@CrossOrigin
@RestController
public class HomeController {

    private final ActivityService activityService;

    public HomeController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ActivityDTO>> getAllActivities() {
        return ResponseEntity
                .ok(this.activityService.findAll());
    }

    @GetMapping("/activities/{id}")
    public ResponseEntity<ActivityDTO> getActivityById(@PathVariable("id") Long activityId) {
        Optional<ActivityDTO> getActivity = this.activityService.getActivityById(activityId);

        if (getActivity.isEmpty()) {
            return ResponseEntity.
                    notFound().
                    build();
        } else {
            return ResponseEntity.
                    ok(getActivity.get());
        }
    }

    @PostMapping("/activities")
    public ResponseEntity<ActivityDTO> createActivity(@RequestBody ActivityDTO newActivity, UriComponentsBuilder uriComponentsBuilder) {
        Long newActivityId = this.activityService.createActivity(newActivity);

        return ResponseEntity.
                created(uriComponentsBuilder.path("/activities/{id}").
                        build(newActivityId)).
                build();
    }

    @PutMapping("/activities/{id}")
    public ResponseEntity<ActivityDTO> editActivityById(@PathVariable("id") Long activityId, @RequestBody ActivityDTO activityDTO) {
        boolean isActivityEdited = this.activityService.editActivityById(activityId, activityDTO);

        //TODO: Make a validation if the admin is doing the change

        //TODO: Find out how to return the response to the front end

        //TODO: I need to return a message as a string whether the operation was successful or not

        return null;
    }

    @DeleteMapping("/activities/{id}")
    public ResponseEntity<ActivityDTO> deleteActivityById(@PathVariable("id") Long activityId) {
        this.activityService.deleteActivityById(activityId);

        return ResponseEntity
                .noContent()
                .build();
    }
}
