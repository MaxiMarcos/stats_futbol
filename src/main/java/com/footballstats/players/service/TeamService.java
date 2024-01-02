
package com.footballstats.players.service;

import com.footballstats.players.dto.PlayerTeamDTO;
import com.footballstats.players.model.Team;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.footballstats.players.repository.ITeamRepository;

@Service
public class TeamService implements ITeamService{

    @Autowired
    private ITeamRepository equipoRepo; 
    
    
    @Override
    public List<Team> getTeams() {
    
        return equipoRepo.findAll();
    }

    @Override
    public void createTeam(Team team) {
        
        equipoRepo.save(team);
    }

    @Override
    public boolean deleteTeam(Long id) {
    Optional<Team> team = equipoRepo.findById(id);

    if (team.isPresent()) {
        equipoRepo.deleteById(id);
        return true; // Indica que se eliminó el equipo con éxito
    } else {
        return false; // Indica que no se encontró un equipo con el ID proporcionado
    }
}

    @Override
    public Team findTeam(Long id) {
        Team team = equipoRepo.findById(id).orElse(null);
        return team;
    }

    @Override
    public void editTeam(Long idOriginal, String newName, String newCountry, List newPlayers) {
        
        Team team = this.findTeam(idOriginal);
        team.setName(newName);
        team.setCountry(newCountry);
        team.setListPlayers(newPlayers);
        
        this.createTeam(team);
    }

    
}
