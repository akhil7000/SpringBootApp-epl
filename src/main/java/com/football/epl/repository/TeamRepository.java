package com.football.epl.repository;

import com.football.epl.model.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends CrudRepository<Team,Integer> {

    @Query("from Team where ranking = (:ranking)")
    public Optional<Team> findByRanking(@Param("ranking") Integer ranking);

    Optional<Team> findByTeamName(String name);
}
