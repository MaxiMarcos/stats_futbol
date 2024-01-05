
package com.footballstats.players.controller;

import com.footballstats.players.dto.PlayerTeamDTO;
import com.footballstats.players.model.Team;
import com.footballstats.players.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.footballstats.players.service.ITeamService;
import com.footballstats.players.service.IPlayerService;

@RestController
public class ControllerDTO {
    
        
    @Autowired
    private ITeamService equipoServ;
    @Autowired
    private IPlayerService jugadorServ;
       
    
    //Esto debe ir en vista html
    
    @GetMapping ("/estadistica/{id}")
    public ResponseEntity<PlayerTeamDTO> prueba(@PathVariable Long id){


        Player player = jugadorServ.findPlayer(id);
        Team team = equipoServ.findTeam(id);

        PlayerTeamDTO jugDto = new PlayerTeamDTO();

        jugDto.setId_jug(player.getId_jug());
        jugDto.setName(player.getName());
        jugDto.setAssistAverage(player.getAssistAverage());
        jugDto.setGoalsAverage(player.getGoalsAverage());
        jugDto.setAssist(player.getAssist());
        jugDto.setGoals(player.getGoals());
        jugDto.setAge(player.getAge());
        jugDto.setGames(player.getGames());
        jugDto.setTeam(team.getName());
        jugDto.setNationality(player.getNationality());
        
         return ResponseEntity.ok(jugDto);
         
    }
     
     
}