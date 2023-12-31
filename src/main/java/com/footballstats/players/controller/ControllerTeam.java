/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.footballstats.players.controller;


import com.footballstats.players.dto.EditPlayerDTO;
import com.footballstats.players.model.Team;
import com.footballstats.players.model.Player;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.footballstats.players.service.ITeamService;
@RestController
public class ControllerTeam {
    
    @Autowired
    private ITeamService equipoServ;
    
    @GetMapping("/teams")
    public ResponseEntity<List<Team>> getTeams() {
        List<Team> teams = equipoServ.getTeams();

        if (teams.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(teams, HttpStatus.OK);
        }
    }
    
    @GetMapping("/teams/{id}")
    public ResponseEntity<Team> findTeam(@PathVariable Long id) {
        
        Team team = equipoServ.findTeam(id);
          if (team!=null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(team, HttpStatus.OK);
        }      
    }

    @PostMapping ("/teams") 
    public ResponseEntity <String> createTeam(@RequestBody Team team) {
        
        equipoServ.createTeam(team);
        return new ResponseEntity<>("El equipo fue creado exitosamente", HttpStatus.OK);
    }

    @DeleteMapping ("/teams/{id}")
    public ResponseEntity <String> deleteTeam(@PathVariable Long id) {
       
        boolean removed = equipoServ.deleteTeam(id);
        if(removed) {
            return new ResponseEntity<>("El equipo fue borrado exitosamente", HttpStatus.OK);
        } else {
        return new ResponseEntity<>("El equipo con ese id no existe", HttpStatus.NOT_FOUND);
    }
        
    } 
}