package com.example.demo.dao;

import com.example.demo.model.Player;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlayerDao {
    private static List<Player> players= new ArrayList<>();

    static {
        Player firstPlayer = new Player();
        firstPlayer.setId(1L);
        firstPlayer.setFirstName("Cristiano");
        firstPlayer.setLastName("Ronaldo");
        firstPlayer.setAge(36);
        firstPlayer.setSalary(10000);
        firstPlayer.setSkill(90);
        firstPlayer.setPosition("Forward");
        firstPlayer.setNumber(7);

        Player secondPlayer = new Player();
        secondPlayer.setId(2L);
        secondPlayer.setFirstName("Lionel");
        secondPlayer.setLastName("Messi");
        secondPlayer.setAge(34);
        secondPlayer.setSalary(80000);
        secondPlayer.setSkill(92);
        secondPlayer.setPosition("Forward");
        secondPlayer.setNumber(10);

        players.add(firstPlayer);
        players.add(secondPlayer);

    }

    public List<Player> getPlayers (){
        return players;
    }

    public void addPlayer (Player player) {
        players.add(player);
    }

    public Player findById (long id){
        return players.stream().
                filter(p -> p.getId() == id).
                findFirst().
                orElseThrow(() -> new RuntimeException("Player not found"));
    }

    public void deletePlayer (long id){
        Player player = findById(id);
        players.remove(player);
    }

    public void updatePlayer (long id, Player newPlayer){
        Player oldPlayer = findById(id);

        oldPlayer.setNumber(newPlayer.getNumber());
        oldPlayer.setPosition(newPlayer.getPosition());
        oldPlayer.setSkill(newPlayer.getSkill());
        oldPlayer.setFirstName(newPlayer.getFirstName());
        oldPlayer.setLastName(newPlayer.getLastName());
        oldPlayer.setAge(newPlayer.getAge());
        oldPlayer.setSalary(newPlayer.getSalary());
    }
}
