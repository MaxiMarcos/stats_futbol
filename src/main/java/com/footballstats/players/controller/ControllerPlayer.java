/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.footballstats.players.controller;

import com.footballstats.players.dto.EditPlayerDTO;
import com.footballstats.players.model.Player;
import com.footballstats.players.service.IPlayerService;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerPlayer {
    
    @Autowired
    private IPlayerService jugadorServ;

    
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
    
    @PostMapping ("/players") 
    public ResponseEntity <String> createPlayer(@RequestBody Player player) {
       
        jugadorServ.createPlayer(player);
        return new ResponseEntity<>("El jugador fue creado exitosamente", HttpStatus.OK);
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
    
    @PutMapping ("/players/{idOriginal}")
    public Player editPlayer(@PathVariable Long idOriginal, @RequestBody EditPlayerDTO playerDTO) {

        jugadorServ.editPlayer(idOriginal, playerDTO);
        Player player = jugadorServ.findPlayer(idOriginal);   
        return player;
        
    }
    
    
    
}
