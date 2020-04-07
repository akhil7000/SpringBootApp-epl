package com.football.epl.repository;

import com.football.epl.model.PersonalInfo;
import com.football.epl.model.Players;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonalInfoRepository extends CrudRepository<PersonalInfo,Integer> {

    Iterable<PersonalInfo> findByPlayerId(int id);

    Iterable<PersonalInfo> findByPlayerPlayerName(String playerName);
}
