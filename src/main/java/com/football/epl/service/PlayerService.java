package com.football.epl.service;

import com.football.epl.model.Players;
import com.football.epl.model.Team;
import com.football.epl.repository.PlayerRepository;
import com.football.epl.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService implements IPlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    TeamRepository teamRepository;


    @Override
    public String checkHealthPlayerService() {
        return "Player Server is up - from service";
    }

    @Override
    public Iterable<Players> getPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Players> getPlayersUsingJerseyNo(int no) {
        return playerRepository.findById(no);
    }

    @Override
    public Players setPlayer(Players player) {
        Integer teamId=player.getTeamId();
        Optional<Team> team = teamRepository.findById(teamId);
        team.get().setTeamPlayer(player);
        return playerRepository.save(player);
    }

    @Override
    public void deletePlayer(int id) {
        playerRepository.deleteById(id);
    }
}
