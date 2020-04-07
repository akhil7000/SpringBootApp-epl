package com.football.epl.controller;

import com.football.epl.model.PersonalInfo;
import com.football.epl.model.Players;
import com.football.epl.service.PersonalInfoService;
import com.football.epl.service.PlayerService;
import io.swagger.annotations.ApiOperation;
import org.aspectj.weaver.patterns.PerObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController

public class PersonalInfoController {

    @Autowired
    PersonalInfoService personalInfoService;

    @GetMapping("/checkHealthPersonalInfoService")
    @ApiOperation(value = "Checks the PersonalInfo Service")
    public String checkHealth(){
        return personalInfoService.checkHealthPersonalInfoService();

    }


    @GetMapping("/getAllPersonalInfo/{personalInfoId}")
    @ApiOperation(value = "Retreives all the players from the db for {personalInfoId}",
            notes= "PersonalInfo class is used as a model",
            response = PersonalInfo.class)
    public Optional<PersonalInfo> getPersonalInfoUsingId(@PathVariable int personalInfoId){
        return personalInfoService.getPersonalInfoUsingId(personalInfoId);
    }

    @GetMapping("/getPlayerUsingId/{playerId}/getAllPersonalInfo")
    @ApiOperation(value = "Retreives all the players from the db for {playerId}",
            notes= "PersonalInfo class is used as a model",
            response = PersonalInfo.class)
    public Iterable<PersonalInfo> getPersonalInfoUsingPlayerId(@PathVariable int playerId){
        return personalInfoService.getPersonalInfoUsingPlayerId(playerId);
    }

    @GetMapping("/getPlayerUsingName/{playerName}/getAllPersonalInfo")
    @ApiOperation(value = "Retreives all the players from the db for {playerName}",
            notes= "PersonalInfo class is used as a model",
            response = PersonalInfo.class)
    public Iterable<PersonalInfo> getPersonalInfoUsingPlayerName(@PathVariable String playerName){
        return personalInfoService.getPersonalInfoUsingPlayerName(playerName);
    }

    @PostMapping("/addPlayerPersonalInfo")
    @ApiOperation(value = "Saves the player's personal info to the db",
            notes= "PersonalInfo class is used as a model",
            response = PersonalInfo.class)
    public PersonalInfo setPlayer(@RequestBody PersonalInfo personalInfo){
        return personalInfoService.setPersonalInfo(personalInfo);
    }

}

