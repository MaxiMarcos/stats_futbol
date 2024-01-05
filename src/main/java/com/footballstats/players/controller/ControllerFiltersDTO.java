
package com.footballstats.players.controller;

import com.footballstats.players.model.Player;
import com.footballstats.players.service.IPlayerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerFiltersDTO {
    
    @Autowired
    private IPlayerService jugadorServ;
       
    
    
    @GetMapping("/players/position/goalsaverage")
    public ResponseEntity<List<Player>> getPlayersForGoals() {
        List<Player> players = jugadorServ.getPlayersWithHighGoalsAverage();

        if (players.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(players, HttpStatus.OK);
        }
    }
    
    @GetMapping("/players/assistaverage")
    public ResponseEntity<List<Player>> getPlayersForAssist() {
        List<Player> players = jugadorServ.getPlayersWithLowAssistAverage();

        if (players.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(players, HttpStatus.OK);
        }
    }
    
    @GetMapping("/players/attackers")
    public ResponseEntity<List<Player>> getAttackingPlayers() {
        List<Player> players = jugadorServ.getAttackingPlayers();

        if (players.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(players, HttpStatus.OK);
        }
    }
    
    @GetMapping("/players/defenders")
    public ResponseEntity<List<Player>> getDefensePlayers() {
        List<Player> players = jugadorServ.getDefensePlayers();

        if (players.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(players, HttpStatus.OK);
        }
    }
}