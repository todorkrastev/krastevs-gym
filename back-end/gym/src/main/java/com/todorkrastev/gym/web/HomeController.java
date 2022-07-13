package com.todorkrastev.gym.web;

import com.todorkrastev.gym.model.dto.activity.ActivityDTO;
import com.todorkrastev.gym.service.ActivityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class HomeController {

    private final ActivityService activityService;

    public HomeController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/")
    public List<ActivityDTO> findAll() {
        return this.activityService.findAll();
    }


}
