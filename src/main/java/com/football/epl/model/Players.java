package com.football.epl.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;

/** This is Players Table which has a 1-1 relationship with PersonalInfo Table
 *  and M-1 relationship with Team Table
 **/
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

    @JsonIgnore
    @OneToOne(mappedBy = "player")
    PersonalInfo personalInfo;

    @Column(name="player_name")
    String playerName;
    @Column(name="player_age")
    int playerAge;

    public void setPlayerPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo=personalInfo;
        personalInfo.setPlayer(this);
    }


}
