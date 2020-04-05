package com.football.epl.controller;

import com.football.epl.model.Players;
import com.football.epl.service.PlayerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController

public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping("/checkHealthPlayerService")
    @ApiOperation(value = "Checks the Player Service")
    public String checkHealth(){
        return playerService.checkHealthPlayerService();

    }


    @GetMapping("/getPlayers")
    @ApiOperation(value = "Retreives all the players from the db",
            notes= "Players class is used as a model",
            response = Players.class)
    public Iterable<Players> getPlayers(){
        return playerService.getPlayers();
    }

    @GetMapping("/getPlayersUsingJerseyNo/{no}")
    @ApiOperation(value = "Retreives all the players from the db using {no}",
            notes= "Players class is used as a model",
            response = Players.class)
    public Optional<Players> getPlayersUsingJerseyNo(@PathVariable int no){
        return playerService.getPlayersUsingJerseyNo(no);
    }

    @PostMapping("/addPlayers")
    @ApiOperation(value = "Saves the player to the db",
            notes= "Players class is used as a model",
            response = Players.class)
    public Players setPlayer(@RequestBody Players player){
        return playerService.setPlayer(player);
    }

    @DeleteMapping("/deletePlayer/{id}")
    @ApiOperation(value = "Deletes the player from the db",
            notes= "Players class is used as a model")
    public void deletePlayer(@PathVariable int id) {
        playerService.deletePlayer(id);
    }
}

