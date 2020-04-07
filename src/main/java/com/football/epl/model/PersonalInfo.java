package com.football.epl.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;

/** This is PersonalInfo Table which has a 1-1 relationship
 *  with Players Table
**/
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "personal_info")
public class PersonalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="info_id")
    int personalInfoId;

    @Column(name="mobile_no")
    String playerMobileNo;

    @Column(name="email_id")
    String playerEmailId;

    @Column(name="address")
    String playerAddress;

    @Column(name="player_id",insertable = false, updatable = false)
    int playerId;

    @OneToOne
    @JoinColumn(name = "player_id")
    Players player;

}
