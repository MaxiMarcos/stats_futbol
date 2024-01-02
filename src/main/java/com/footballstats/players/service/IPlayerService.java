/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.footballstats.players.service;

import com.footballstats.players.dto.EditPlayerDTO;
import com.footballstats.players.model.Player;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IPlayerService {
   
   public List<Player> getPlayers();
   public void createPlayer(Player player);
   public boolean deletePlayer(Long id);
   public void editPlayer(Long idOriginal, EditPlayerDTO playerDTO);
   public Player findPlayer(Long id);
   public double goalsAverage(int goals, int games);
   public double assistAverage(int assist, int games);
    
    
}

