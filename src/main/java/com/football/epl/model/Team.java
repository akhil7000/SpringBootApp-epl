package com.football.epl.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

//    public Team(){}

//    public Team(String teamName) {
////        this.teamName=teamName;
////
////    }

    @Column(name="ranking")
    int teamRanking;


    public void setTeamPlayer(Players player) {
        playerSet=new HashSet<Players>();
        playerSet.add(player);
        player.setTeam(this);
    }
}
