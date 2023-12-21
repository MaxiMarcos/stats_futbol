/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.futboldatos.jugadores.controller;


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
import org.springframework.web.bind.annotation.RequestParam;
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
        
        jugador.setGolesPorPJ(0);
        jugador.setAsistPorPJ(0);
        
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
   
    @PutMapping ("/jugador/modificar/{idOriginal}")
    public Jugador editarJugador(@PathVariable Long idOriginal,
            @RequestParam(required=false, name = "nombreCompleto") String nombreNuevo,
            @RequestParam(required=false, name = "posicion") String posicionNuevo,
            @RequestParam(required=false, name = "edad") int edadNuevo,
            @RequestParam(required=false, name = "partidosJugados")int pjNuevo,
            @RequestParam(required=false, name = "goles")int golesNuevo,
            @RequestParam(required=false, name = "asistencias")int asistNuevo,
            //@RequestParam(required=false, name = "golesPorPJ")double golesPorPJNuevo,
           //@RequestParam(required=false, name= "asistPorPJ") double asistPorPJNuevo,
            @RequestParam(required=false, name = "añoDebut") int añoDebutNuevo,
            @RequestParam(required=false, name = "nacionalidad")String nacionalidadNuevo,
            @RequestParam(required=false, name = "partidosSeleccion")int partidosSeleccionNuevo) {

        jugadorServ.editarJugador(idOriginal,nombreNuevo, posicionNuevo, edadNuevo, pjNuevo, golesNuevo, asistNuevo, 0, 0, añoDebutNuevo, nacionalidadNuevo, partidosSeleccionNuevo);
        Jugador jugador = jugadorServ.buscarJugador(idOriginal);   
        return jugador;
        
    }
    
    
}