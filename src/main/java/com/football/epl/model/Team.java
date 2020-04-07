package com.football.epl.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/** This is Team Table which has a 1-M relationship
 *  with Players Table
 **/
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "playerSet")
@Entity
@Table(name="team_info")
public class Team {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="team_id")
    int teamId;

    @JsonIgnore
    @OneToMany(mappedBy = "team")
    Set<Players> playerSet;

    @Column(name="team_name")
    String teamName;

    @Column(name="ranking")
    int teamRanking;

    public void setTeamPlayer(Players player) {
        playerSet=new HashSet<Players>();
        playerSet.add(player);
        player.setTeam(this);
    }
}
