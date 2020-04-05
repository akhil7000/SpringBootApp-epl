package com.football.epl.service;

import com.football.epl.model.Team;
import com.football.epl.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamService implements ITeamService {

    @Autowired
    TeamRepository teamRepository;


    @Override
    public String checkHealthTeamService() {
        return "Team Server is up - from service";
    }

    @Override
    public Iterable<Team> getTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Optional<Team> getTeamNameUsingId(int id) {
        return teamRepository.findById(id);
    }

    @Override
    public Optional<Team> getTeamNameUsingRanking(int ranking) {
        return teamRepository.findByRanking(ranking);
    }

    @Override
    public Team setTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public void deleteTeam(int id) {
        teamRepository.deleteById(id);
    }
}
