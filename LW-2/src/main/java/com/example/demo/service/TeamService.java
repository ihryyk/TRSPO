package com.example.demo.service;

import com.example.demo.dao.TeamDao;
import com.example.demo.model.Coach;
import com.example.demo.model.Player;
import com.example.demo.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamDao teamDao;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private CoachService coachService;

    public List<Team> getTeams() {
        return teamDao.getTeams();
    }

    public Team findById(long id) {
        return teamDao.findById(id);
    }

    public void saveTeam(Team team) {
        teamDao.saveTeam(team);
    }

    public void addPlayer(long teamId, long playerId) {
        Team team = findById(teamId);
        Player player = playerService.findById(playerId);

        teamDao.addPlayer(team, player);
    }

    public void addCoach(long teamId, long coachId) {
        Team team = findById(teamId);
        Coach coach = coachService.findById(coachId);

        team.setCoach(coach);
    }

    public void deleteTeam(long id) {
        teamDao.deleteTeam(id);
    }
}
