package com.football.epl.service;

import com.football.epl.model.PersonalInfo;
import com.football.epl.model.Players;

import java.util.Optional;

public interface IPersonalInfoService {
    String checkHealthPersonalInfoService();
    Iterable<PersonalInfo> getPersonalInfoUsingPlayerId(int id);

    Optional<PersonalInfo> getPersonalInfoUsingId(int personalInfoId);

    Iterable<PersonalInfo> getPersonalInfoUsingPlayerName(String playerName);

    PersonalInfo setPersonalInfo(PersonalInfo personalInfo);
}
