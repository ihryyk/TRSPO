package com.example.demo.dao;

import com.example.demo.model.Player;
import com.example.demo.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeamDao {
    private static List<Team> teams = new ArrayList<>();

    static {
        teams.add(new Team(1L, "Real", new ArrayList<>(), null));
        teams.add(new Team(2L, "Barcelona", new ArrayList<>(), null));
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void saveTeam(Team team) {
        teams.add(team);
    }

    public void addPlayer(Team team, Player player) {
        team.getPlayers().add(player);
    }

    public Team findById(long id) {
        return teams.stream()
                .filter(team -> team.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Team not found!"));
    }

    public void deleteTeam(long id) {
        Team team = findById(id);
        teams.remove(team);
    }
}
