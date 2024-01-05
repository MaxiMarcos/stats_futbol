
package com.footballstats.players.service;

import com.footballstats.players.dto.EditPlayerDTO;
import com.footballstats.players.model.Player;
import java.util.List;


public interface IPlayerService {
   
   public List<Player> getPlayers();
   public void createPlayer(Player player);
   public boolean deletePlayer(Long id);
   public void editPlayer(Long idOriginal, EditPlayerDTO playerDTO);
   public Player findPlayer(Long id);
   public double goalsAverage(int goals, int games);
   public double assistAverage(int assist, int games);
   public List<Player> getPlayersWithHighGoalsAverage();
   public List<Player> getPlayersWithHighAssistAverage();
   public List<Player> getAttackingPlayers();
   public List<Player> getDefensePlayers();
}

