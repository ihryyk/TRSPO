package com.example.demo.service;

import com.example.demo.dao.CoachDao;
import com.example.demo.model.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachService {
    @Autowired
    private CoachDao coachDao;

    public List<Coach> getAllCoaches() {
        return coachDao.getAllCoaches();
    }

    public void saveCoach(Coach coach) {
        coachDao.saveCoach(coach);
    }

    public Coach findById(long id) {
        return coachDao.findById(id);
    }
}
