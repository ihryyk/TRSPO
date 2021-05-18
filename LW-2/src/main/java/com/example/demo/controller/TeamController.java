package com.example.demo.controller;

import com.example.demo.model.Team;
import com.example.demo.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
@AllArgsConstructor
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/all")
    public List<Team> getTeams() {
        return teamService.getTeams();
    }

    @PostMapping
    public void saveTeam(@RequestBody Team team) {
        teamService.saveTeam(team);
    }

    @PostMapping("/{teamId}/add-player")
    public void addPlayer(@PathVariable long teamId, @RequestParam long playerId) {
        teamService.addPlayer(teamId, playerId);
    }

    @PostMapping("/{teamId}/add-coach")
    public void addCoach(@PathVariable long teamId, @RequestParam long coachId) {
        teamService.addCoach(teamId, coachId);
    }

    @GetMapping("/{id}")
    public Team findById(@PathVariable long id) {
        return teamService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable long id) {
        teamService.deleteTeam(id);
    }
}
