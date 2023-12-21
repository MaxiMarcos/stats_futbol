
package com.futboldatos.jugadores.service;

import com.futboldatos.jugadores.dto.JugadorDTO;
import com.futboldatos.jugadores.model.Equipo;
import com.futboldatos.jugadores.repository.IEquipoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipoService implements IEquipoService{

    @Autowired
    private IEquipoRepository equipoRepo; 
    
    
    @Override
    public List<Equipo> traerEquipos() {
    
        return equipoRepo.findAll();
    }

    @Override
    public void crearEquipo(Equipo equipo) {
        
        equipoRepo.save(equipo);
    }

    @Override
    public boolean borrarEquipo(Long id) {
    Optional<Equipo> equipo = equipoRepo.findById(id);

    if (equipo.isPresent()) {
        equipoRepo.deleteById(id);
        return true; // Indica que se eliminó el equipo con éxito
    } else {
        return false; // Indica que no se encontró un equipo con el ID proporcionado
    }
}

    @Override
    public Equipo buscarEquipo(Long id) {
        Equipo equipo = equipoRepo.findById(id).orElse(null);
        return equipo;
    }

    @Override
    public void editarEquipo(Long idOriginal, String nombreNuevo, String paisNuevo, List jugadoresNuevos) {
        
        Equipo equipo = this.buscarEquipo(idOriginal);
        equipo.setNombre(nombreNuevo);
        equipo.setPais(paisNuevo);
        equipo.setListaJugadores(jugadoresNuevos);
        
        this.crearEquipo(equipo);
    }

    
}
