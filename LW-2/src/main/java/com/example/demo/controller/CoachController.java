package com.example.demo.controller;

import com.example.demo.model.Coach;
import com.example.demo.service.CoachService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coaches")
@AllArgsConstructor
public class CoachController {
    @Autowired
    private CoachService coachService;

    @GetMapping("/all")
    public List<Coach> getAllCoaches() {
        return coachService.getAllCoaches();
    }

    @PostMapping
    public void saveCoach(@RequestBody Coach coach) {
        coachService.saveCoach(coach);
    }

    @GetMapping("/{id}")
    public Coach findById(@PathVariable long id) {
        return coachService.findById(id);
    }
}
