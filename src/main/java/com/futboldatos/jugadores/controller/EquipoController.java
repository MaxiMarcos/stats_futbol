/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.futboldatos.jugadores.controller;

import com.futboldatos.jugadores.dto.JugadorDTO;
import com.futboldatos.jugadores.model.Equipo;
import com.futboldatos.jugadores.model.Jugador;
import com.futboldatos.jugadores.service.IEquipoService;
import com.futboldatos.jugadores.service.IJugadorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EquipoController {
    
    @Autowired
    private IEquipoService equipoServ;
    @Autowired
    private IJugadorService jugadorServ;
    
     @GetMapping("/equipos/traer")
    public ResponseEntity<List<Equipo>> getEquipos() {
        List<Equipo> equipos = equipoServ.traerEquipos();

        if (equipos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(equipos, HttpStatus.OK);
        }
    }
    
    @GetMapping("/equipos/traer-uno")
    public ResponseEntity<Equipo> buscarEquipo(Long id) {
        
        Equipo equipo = equipoServ.buscarEquipo(id);
          if (equipo!=null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(equipo, HttpStatus.OK);
        }
        
    }
    
    @GetMapping("/jugador/traer")
    public ResponseEntity<List<Jugador>> getJugadores() {
        List<Jugador> jugadores = jugadorServ.traerJugadores();

        if (jugadores.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(jugadores, HttpStatus.OK);
        }
    }

    
    @PostMapping ("/equipos/crear") 
    public ResponseEntity <String> crearEquipo(@RequestBody Equipo equipo) {
        
        equipoServ.crearEquipo(equipo);
        return new ResponseEntity<>("El equipo fue creado exitosamente", HttpStatus.OK);
    }
    
    @PostMapping ("/jugador/crear") 
    public ResponseEntity <String> crearJugador(@RequestBody Jugador jugador) {
        
        jugadorServ.crearJugador(jugador);
        return new ResponseEntity<>("El jugador fue creado exitosamente", HttpStatus.OK);
    }
    
    
    @DeleteMapping ("/equipos/borrar/{id}")
    public ResponseEntity <String> borrarEquipo(@PathVariable Long id) {
       
        boolean eliminado = equipoServ.borrarEquipo(id);
        if(eliminado) {
            return new ResponseEntity<>("El equipo fue borrado exitosamente", HttpStatus.OK);
        } else {
        return new ResponseEntity<>("El equipo con ese id no existe", HttpStatus.NOT_FOUND);
    }
        
    }
   
    @PutMapping ("/equipos/modificar")
    public void editarEquipo(@RequestBody Equipo equipo) {
        
        equipoServ.crearEquipo(equipo);
    }
    
           
    @GetMapping ("/estadistica/{id}") // lo que podrá ver el cliente
    public JugadorDTO devolverDTO(@PathVariable Long id) {
        
        Jugador jugador = jugadorServ.buscarJugador(id);
        Equipo equipo = equipoServ.buscarEquipo(id);
        
        JugadorDTO jugDto = new JugadorDTO();
        
        jugDto.setId_jug(jugador.getId_jug());
        jugDto.setNombreCompleto(jugador.getNombreCompleto());
        jugDto.setAsistPorPJ(jugador.getAsistPorPJ());
        jugDto.setGolesPorPJ(jugador.getGolesPorPJ());
        jugDto.setAsistencias(jugador.getAsistencias());
        jugDto.setGoles(jugador.getGoles());
        jugDto.setEdad(jugador.getEdad());
        jugDto.setPartidosJugados(jugador.getPartidosJugados());
        jugDto.setEquipo(equipo.getNombre());
        jugDto.setNacionalidad(jugador.getNacionalidad());
        
        
        return jugDto;  
    }
    
}