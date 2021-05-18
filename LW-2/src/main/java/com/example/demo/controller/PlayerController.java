package com.example.demo.controller;

import com.example.demo.model.Player;
import com.example.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/all")
    public List<Player> getPlayers(){
        return playerService.getPlayers();
    }

    @GetMapping("/{id}")
    public Player findById(@PathVariable long id) { return playerService.findById(id); };

    @PostMapping
    public void addPlayer(@RequestBody Player player){
        playerService.addPlayer(player);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer (@PathVariable long id) {playerService.deletePlayer(id);}

    @PutMapping("/{id}")
    public void updatePlayer(@PathVariable long id, @RequestBody Player newPlayer) { playerService.updatePlayer(id, newPlayer); }

}
