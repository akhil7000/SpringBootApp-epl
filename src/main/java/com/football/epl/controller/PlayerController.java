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


    @GetMapping("getTeam/{teamId}/getPlayers")
    @ApiOperation(value = "Retreives all the players from the db for a {teamId}",
            notes= "Players class is used as a model",
            response = Players.class)
    public Iterable<Players> getPlayers(@PathVariable int teamId){
        return playerService.getPlayers(teamId);
    }

    @GetMapping("getTeam/{teamId}/getPlayersUsingName/{name}")
    @ApiOperation(value = "Retreives all the players from the db using {teamId} & {name}",
            notes= "Players class is used as a model",
            response = Players.class)
    public Optional<Players> getPlayersUsingName(@PathVariable int teamId, @PathVariable String name){
        return playerService.getPlayersUsingName(teamId,name);
    }

    @GetMapping("getTeam/{teamId}/getPlayersUsingJerseyNo/{no}")
    @ApiOperation(value = "Retreives all the players from the db using {teamId} & {no}",
            notes= "Players class is used as a model",
            response = Players.class)
    public Optional<Players> getPlayersUsingJerseyNo(@PathVariable int teamId, @PathVariable int no){
        return playerService.getPlayersUsingJerseyNo(teamId,no);
    }

    @PostMapping("/addPlayers")
    @ApiOperation(value = "Saves the player to the db",
            notes= "Players class is used as a model",
            response = Players.class)
    public Players setPlayer(@RequestBody Players player){
        return playerService.setPlayer(player);
    }

    @DeleteMapping("/deletePlayer/{id}")
    @ApiOperation(value = "Deletes the player from the db using {id}",
            notes= "Players class is used as a model")
    public void deletePlayer(@PathVariable int id) {
        playerService.deletePlayer(id);
    }
}

