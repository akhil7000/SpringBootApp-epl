package com.football.epl.repository;

import com.football.epl.model.Players;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Players,Integer> {
}
