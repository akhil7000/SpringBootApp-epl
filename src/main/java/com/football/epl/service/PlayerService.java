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
    public Iterable<Players> getPlayers(int id) {
        return playerRepository.findByTeamId(id);
    }

    public Optional<Players> getPlayersUsingJerseyNo(int teamId,int no) {
        return playerRepository.findByJerseyNo(no).filter(player->player.getTeamId()==teamId);
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

    @Override
    public Optional<Players> getPlayersUsingName(int teamId,String name) {
        return playerRepository.findByPlayerName(name).filter(player->player.getTeamId()==teamId);
    }
}
