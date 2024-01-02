/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.footballstats.players.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class EditPlayerDTO {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id_jug;
    private String name;
    private String position;
    private int age;
    private int games;
    private int goals;
    private int assist;
    private int firstGame;
    private String nationality;
    private int gameNationalTeam;
    
}

