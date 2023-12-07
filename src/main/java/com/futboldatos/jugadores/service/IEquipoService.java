/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.futboldatos.jugadores.service;

import com.futboldatos.jugadores.model.Equipo;
import java.util.List;

public interface IEquipoService {
    
   public List<Equipo> traerEquipos();
   public void crearEquipo(Equipo equipo);
   public void borrarEquipo(Long id);
   public void editarEquipo(Equipo equipo);
   public Equipo buscarEquipo(Long id);
   
    
    
}
