package com.todorkrastev.gym.web;

import com.todorkrastev.gym.model.dto.activity.FindAllDTO;
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
    public List<FindAllDTO> findAll() {
        return this.activityService.findAll();
    }


}
