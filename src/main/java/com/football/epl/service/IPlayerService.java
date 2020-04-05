package com.football.epl.service;

import com.football.epl.model.Players;
import com.football.epl.model.Team;

import java.util.Optional;

public interface IPlayerService {
    String checkHealthPlayerService();
    Iterable<Players> getPlayers();
    Optional<Players> getPlayersUsingJerseyNo(int no);

    Players setPlayer(Players player);
    void deletePlayer(int no);
}
