package com.football.epl.service;

import com.football.epl.model.Team;

import java.util.Optional;

public interface ITeamService {
    String checkHealthTeamService();
    Iterable<Team> getTeams();
    Optional<Team> getTeamNameUsingId(int id);
    Optional<Team> getTeamNameUsingRanking(int ranking);

    Team setTeam(Team team);

    void deleteTeam(int id);

    Optional<Team> getTeamNameUsingName(String name);
}
