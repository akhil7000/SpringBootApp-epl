package com.football.epl.service;

import com.football.epl.model.Players;
import com.football.epl.model.Team;

import java.util.Optional;

public interface IPlayerService {
    String checkHealthPlayerService();
    Iterable<Players> getPlayers(int id);
    Optional<Players> getPlayersUsingJerseyNo(int teamId,int no);

    Players setPlayer(Players player);
    void deletePlayer(int no);

    Optional<Players> getPlayersUsingName(int teamId,String name);
}
