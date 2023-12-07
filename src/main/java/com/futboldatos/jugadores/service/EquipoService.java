
package com.futboldatos.jugadores.service;

import com.futboldatos.jugadores.model.Equipo;
import com.futboldatos.jugadores.repository.IEquipoRepository;
import java.util.List;
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
    public void borrarEquipo(Long id) {
        equipoRepo.deleteById(id);
    }

    @Override
    public Equipo buscarEquipo(Long id) {
        Equipo equipo = equipoRepo.findById(id).orElse(null);
        return equipo;
    }

    @Override
    public void editarEquipo(Equipo equipo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
