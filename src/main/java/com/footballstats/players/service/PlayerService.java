/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.footballstats.players.service;


import com.footballstats.players.dto.EditPlayerDTO;
import com.footballstats.players.model.Player;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.footballstats.players.repository.IPlayerRepository;

/**
 *
 * @author Usuario
 */
@Service
public class PlayerService implements IPlayerService {

    @Autowired
    private IPlayerRepository jugadorRepo; 
    
    @Override
    public List<Player> getPlayers() {
        
        return jugadorRepo.findAll();
    }

    @Override
    public void createPlayer(Player player) {
   
        double assistAverage = this.assistAverage(player.getAssist(), player.getGames());
        player.setAssistAverage(assistAverage);
        double goalsAverage = this.goalsAverage(player.getGoals(), player.getGames());
        player.setGoalsAverage(goalsAverage);
        jugadorRepo.save(player);
    }

    @Override
    public boolean deletePlayer(Long id) {
        Optional <Player> optionalJugador = jugadorRepo.findById(id);
        
        if (optionalJugador.isPresent()) {
        jugadorRepo.deleteById(id);
        return true;
    } else {
        return false;
    }
   
    }

    @Override
    public void editPlayer(Long idOriginal, EditPlayerDTO playerDTO) {
        
        Player newPlayer = this.findPlayer(idOriginal);
        
        double newGoalsAverage = this.goalsAverage(newPlayer.getGoals(), newPlayer.getGames());
        double newAssistAverage = this.assistAverage(newPlayer.getAssist(), newPlayer.getGames());
       
        newPlayer.setName(playerDTO.getName());
        newPlayer.setAge(playerDTO.getAge());
        newPlayer.setPosition(playerDTO.getPosition());
        newPlayer.setGames(playerDTO.getGames());
        newPlayer.setGoals(playerDTO.getGoals());
        newPlayer.setAssist(playerDTO.getAssist());
        newPlayer.setGoalsAverage(newGoalsAverage);
        newPlayer.setAssistAverage(newAssistAverage);
        newPlayer.setFirstGame(playerDTO.getFirstGame());
        newPlayer.setNationality(playerDTO.getNationality());
        newPlayer.setGameNationalTeam(playerDTO.getGameNationalTeam());
        
        this.createPlayer(newPlayer);
    }

    @Override
    public Player findPlayer(Long id) {
        Player player = jugadorRepo.findById(id).orElse(null);
        return player;
    }

    @Override
    public double goalsAverage(int goals, int games) {
    if (games == 0) {
        return 0;
    } return (double) goals / games;

    
}

    @Override
    public double assistAverage(int assist, int games) { // resolución en controller
        
    if (games == 0) {
        return 0;
    } return (double)assist / games;
    }
}
    