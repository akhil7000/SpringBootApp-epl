package com.football.epl.service;

import com.football.epl.model.PersonalInfo;
import com.football.epl.model.Players;
import com.football.epl.model.Team;
import com.football.epl.repository.PersonalInfoRepository;
import com.football.epl.repository.PlayerRepository;
import com.football.epl.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonalInfoService implements IPersonalInfoService {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    PersonalInfoRepository personalInfoRepository;


    @Override
    public String checkHealthPersonalInfoService() {
        return "PersonalInfo Server is up - from service";
    }

    @Override
    public Iterable<PersonalInfo> getPersonalInfoUsingPlayerId(int playerId) {
        return personalInfoRepository.findByPlayerId(playerId);
    }

    @Override
    public Optional<PersonalInfo> getPersonalInfoUsingId(int personalInfoId) {
        return personalInfoRepository.findById(personalInfoId);
    }

    @Override
    public Iterable<PersonalInfo> getPersonalInfoUsingPlayerName(String playerName) {
        return personalInfoRepository.findByPlayerPlayerName(playerName);
    }

    @Override
    public PersonalInfo setPersonalInfo(PersonalInfo personalInfo) {
        Integer playerId=personalInfo.getPlayerId();
        Optional<Players> player = playerRepository.findById(playerId);
        player.get().setPlayerPersonalInfo(personalInfo);
        return personalInfoRepository.save(personalInfo);
    }

}
