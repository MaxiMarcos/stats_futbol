/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.footballstats.players.service;

import com.footballstats.players.dto.PlayerDTO;
import com.footballstats.players.model.Team;
import java.util.List;

public interface ITeamService {
    
   public List<Team> getTeams();
   public void createTeam(Team team);
   public boolean deleteTeam(Long id);
   public void editTeam(Long idOriginal, String newName, String newCountry, List newPlayers);
   public Team findTeam(Long id);
   
    
    
}
