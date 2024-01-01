
package com.footballstats.players.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id_jug;
    private String name;
    private String position;
    private int age;
    private int games;
    private int goals;
    private int assist;
    private double goalsAverage;
    private double assistAverage;
    private int firstGame;
    private String nationality;
    private int gameNationalTeam;

    
}
