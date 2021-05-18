package com.example.demo.service;

import com.example.demo.dao.PlayerDao;
import com.example.demo.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
     private PlayerDao playerDao;

    public List<Player> getPlayers (){
        return playerDao.getPlayers();
    }

    public void addPlayer (Player player) {
        playerDao.addPlayer(player);
    }

    public Player findById (long id) {return playerDao.findById(id);}

    public void deletePlayer (long id) {playerDao.deletePlayer(id);}

    public void updatePlayer (long id, Player player) {playerDao.updatePlayer(id, player);}
}
