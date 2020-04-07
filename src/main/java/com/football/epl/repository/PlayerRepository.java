package com.football.epl.repository;

import com.football.epl.model.Players;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.imageio.spi.ServiceRegistry;
import java.util.Optional;

@Repository
public interface PlayerRepository extends CrudRepository<Players,Integer> {

    Optional<Players> findByPlayerName(String name);

    Iterable<Players> findByTeamId(int id);

    Optional<Players> findByJerseyNo(int no);
}
