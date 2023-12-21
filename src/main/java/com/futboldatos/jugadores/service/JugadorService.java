/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.futboldatos.jugadores.service;


import com.futboldatos.jugadores.model.Jugador;
import com.futboldatos.jugadores.repository.IJugadorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class JugadorService implements IJugadorService {

    @Autowired
    private IJugadorRepository jugadorRepo; 
    
    @Override
    public List<Jugador> traerJugadores() {
        
        return jugadorRepo.findAll();
    }

    @Override
    public void crearJugador(Jugador jugador) {
   
        double asistenciasPJ = this.promedioAsistenciasPorPartido(jugador.getAsistencias(), jugador.getPartidosJugados());
        jugador.setAsistPorPJ(asistenciasPJ);
        double golesPJ = this.promedioGolesPorPartido(jugador.getGoles(), jugador.getPartidosJugados());
        jugador.setGolesPorPJ(golesPJ);
        jugadorRepo.save(jugador);
    }

    @Override
    public boolean borrarJugador(Long id) {
        Optional <Jugador> optionalJugador = jugadorRepo.findById(id);
        
        if (optionalJugador.isPresent()) {
        jugadorRepo.deleteById(id);
        return true;
    } else {
        return false;
    }
   
    }

    @Override
    public void editarJugador(Long idOriginal, String nombreNuevo, String posicionNuevo, int edadNuevo, int pjNuevo, int golesNuevo, int asistNuevo, double golesPorPJNuevo,
                             double asistPorPJNuevo, int añoDebutNuevo, String nacionalidadNuevo, int PartidosSeleccionNuevo) {
        
        Jugador jugadorNuevo = this.buscarJugador(idOriginal);
        
        double promGoles = this.promedioGolesPorPartido(golesNuevo, pjNuevo);
        double promAsist = this.promedioAsistenciasPorPartido(asistNuevo, pjNuevo);
       
        jugadorNuevo.setNombreCompleto(nombreNuevo);
        jugadorNuevo.setEdad(edadNuevo);
        jugadorNuevo.setPosicion(posicionNuevo);
        jugadorNuevo.setPartidosJugados(pjNuevo);
        jugadorNuevo.setGoles(golesNuevo);
        jugadorNuevo.setAsistencias(asistNuevo);
        jugadorNuevo.setGolesPorPJ(promGoles);
        jugadorNuevo.setAsistPorPJ(promAsist);
        jugadorNuevo.setAñoDebut(añoDebutNuevo);
        jugadorNuevo.setNacionalidad(nacionalidadNuevo);
        jugadorNuevo.setPartidosSeleccion(PartidosSeleccionNuevo);
        
        this.crearJugador(jugadorNuevo);
    }

    @Override
    public Jugador buscarJugador(Long id) {
        Jugador jugador = jugadorRepo.findById(id).orElse(null);
        return jugador;
    }

    @Override
    public double promedioGolesPorPartido(int goles, int partidosJugados) {
    if (partidosJugados == 0) {
        return 0;
    } return (double) goles / partidosJugados;
    
}

    @Override
    public double promedioAsistenciasPorPartido(int asist, int partidosJugados) {
        
    if (partidosJugados == 0) {
        return 0;
    } return (double)asist / partidosJugados;
    }
}
    