/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.footballstats.players.controller;


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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.footballstats.players.service.ITeamService;
import com.footballstats.players.service.IPlayerService;

@RestController
public class ControllerTeam {
    
    @Autowired
    private ITeamService equipoServ;
    @Autowired
    private IPlayerService jugadorServ;
    
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
    
    @GetMapping("/players")
    public ResponseEntity<List<Player>> getPlayers() {
        List<Player> players = jugadorServ.getPlayers();

        if (players.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(players, HttpStatus.OK);
        }
    }
    
    @GetMapping("/players/{id}")
    public ResponseEntity<Player> findPlayer(@PathVariable Long id) {
        
        Player player = jugadorServ.findPlayer(id);
          if (player!=null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(player, HttpStatus.OK);
        }
        
    }

    
    @PostMapping ("/teams") 
    public ResponseEntity <String> createTeam(@RequestBody Team team) {
        
        equipoServ.createTeam(team);
        return new ResponseEntity<>("El equipo fue creado exitosamente", HttpStatus.OK);
    }
    
    @PostMapping ("/players") 
    public ResponseEntity <String> createPlayer(@RequestBody Player player) {
       
        jugadorServ.createPlayer(player);
        return new ResponseEntity<>("El jugador fue creado exitosamente", HttpStatus.OK);
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
    
    @DeleteMapping ("/players/{id}")
    public ResponseEntity <String> deletePlayer(@PathVariable Long id) {
       
        boolean removed = jugadorServ.deletePlayer(id);
        if(removed) {
            return new ResponseEntity<>("El jugador fue borrado exitosamente", HttpStatus.OK);
        } else {
        return new ResponseEntity<>("El jugador con ese id no existe", HttpStatus.NOT_FOUND);
    }
        
    }
   
   
    @PutMapping ("/jugador/modificar/{idOriginal}")
    public Player editPlayer(@PathVariable Long idOriginal,
            @RequestParam(required=false, name = "name") String newName,
            @RequestParam(required=false, name = "position") String newPosition,
            @RequestParam(required=false, name = "age") int newAge,
            @RequestParam(required=false, name = "games")int newGames,
            @RequestParam(required=false, name = "goals")int newGoals,
            @RequestParam(required=false, name = "assist")int newAssist,
            @RequestParam(required=false, name = "firstGame") int newFirstGame,
            @RequestParam(required=false, name = "nationality")String newNationality,
            @RequestParam(required=false, name = "gamesNationalTeam")int newGamesNationalTeam) {

        jugadorServ.editPlayer(idOriginal,newName, newPosition, newAge, newGames, newGoals, newAssist, newFirstGame, newNationality, newGamesNationalTeam);
        Player player = jugadorServ.findPlayer(idOriginal);   
        return player;
        
    }
    
    
}