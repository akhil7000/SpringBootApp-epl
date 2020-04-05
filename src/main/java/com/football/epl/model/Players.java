package com.football.epl.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "players_info")
public class Players {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="player_id")
    int playerId;

    @Column(name="jersey_no")
    int jerseyNo;


    @Column(name="team_id",insertable = false, updatable = false)
    int teamId;

    @ManyToOne
    @JoinColumn(name = "team_id")
    Team team;

    @Column(name="player_name")
    String playerName;
    @Column(name="player_age")
    int playerAge;

//    public Players(){}

//    public Players(int teamId) {
//        this.teamId=teamId;
//
//    }


}
