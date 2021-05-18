package com.example.demo.dao;

import com.example.demo.model.Coach;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CoachDao {
    private static List<Coach> coaches = new ArrayList<>();

    static {
        Coach coach = new Coach();
        coach.setId(1L);
        coach.setFirstName("Josep");
        coach.setLastName("Guardiola");
        coach.setSalary(10000);
        coach.setAge(45);
        coach.setExperience(20);

        coaches.add(coach);
    }

    public List<Coach> getAllCoaches() {
        return coaches;
    }

    public void saveCoach(Coach coach) {
        coaches.add(coach);
    }

    public Coach findById(long coachId) {
        return coaches.stream()
                .filter(c -> c.getId() == coachId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Coach not found!"));
    }
}
