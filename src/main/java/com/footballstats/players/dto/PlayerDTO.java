
package com.footballstats.players.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class PlayerDTO {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id_jug;
    private String name;
    private int age;
    private int games;
    private int goals;
    private int assist;
    private double goalsAverage;
    private double assistAverage;
    private String nationality;
    private String team;

    public PlayerDTO () {
    }

    public PlayerDTO(Long id_jug, String name, int age, int games, int goals, int assist, double goalsAverage, double assistAverage, String nationality, String team) {
        this.id_jug = id_jug;
        this.name = name;
        this.age = age;
        this.games = games;
        this.goals = goals;
        this.assist = assist;
        this.goalsAverage = goalsAverage;
        this.assistAverage = assistAverage;
        this.nationality = nationality;
        this.team = team;
    }

    

}
