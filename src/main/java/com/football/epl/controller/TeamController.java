package com.football.epl.controller;

import com.football.epl.model.Team;
import com.football.epl.service.TeamService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TeamController {

    @Autowired
    TeamService teamService;

    @GetMapping("/checkHealthTeamService")
    @ApiOperation(value = "Checks the Team Service")
    public String checkHealth() {
        return teamService.checkHealthTeamService();
    }

    @GetMapping("/getTeams")
    @ApiOperation(value = "Retreives all the teams from the db",
            notes= "Team class is used as a model",
            response = Team.class)
    public Iterable<Team> getTeams(){
        return teamService.getTeams();
    }

    @GetMapping("/getTeamNameUsingRanking/{ranking}")
    @ApiOperation(value = "Retreives all the players from the db using {ranking}",
            notes= "Team class is used as a model",
            response = Team.class)
    public Optional<Team> getTeamNameUsingRanking(@PathVariable int ranking){
        return teamService.getTeamNameUsingRanking(ranking);
    }

    @GetMapping("/getTeamNameUsingId/{id}")
    @ApiOperation(value = "Retreives all the players from the db using {id}",
            notes= "Team class is used as a model",
            response = Team.class)
    public Optional<Team> getTeamNameUsingId(@PathVariable int id){
        return teamService.getTeamNameUsingId(id);
    }

    @PostMapping("/addTeam")
    @ApiOperation(value = "Saves the team to the db",
            notes= "Team class is used as a model",
            response = Team.class)
    public Team setTeam(@RequestBody Team team){
        return teamService.setTeam(team);
    }

    @DeleteMapping("/deleteTeam/{id}")
    @ApiOperation(value = "Deletes the player from the db",
            notes= "Players class is used as a model")
    public void deleteTeam(@PathVariable int id){
        teamService.deleteTeam(id);
    }

}
