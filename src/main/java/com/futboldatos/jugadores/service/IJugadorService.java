/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.futboldatos.jugadores.service;

import com.futboldatos.jugadores.model.Jugador;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IJugadorService {
   
   public List<Jugador> traerJugadores();
   public void crearJugador(Jugador Jugador);
   public boolean borrarJugador(Long id);
   public void editarJugador(Long idOriginal, String nombreNuevo, String posicionNuevo, int edadNuevo, int pjNuevo, int golesNuevo, int asistNuevo,
                            double golesPorPJNuevo, double asistPorPJNuevo, int añoDebutNuevo, String nacionalidadNuevo, int partidosSeleccionNuevo);
   public Jugador buscarJugador(Long id);
   public double promedioGolesPorPartido(int goles, int partidosJugados);
    
    
}

