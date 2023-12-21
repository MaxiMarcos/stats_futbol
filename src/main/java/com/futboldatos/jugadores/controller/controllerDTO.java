
package com.futboldatos.jugadores.controller;

import com.futboldatos.jugadores.dto.JugadorDTO;
import com.futboldatos.jugadores.model.Equipo;
import com.futboldatos.jugadores.model.Jugador;
import com.futboldatos.jugadores.service.IEquipoService;
import com.futboldatos.jugadores.service.IJugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class controllerDTO {
    
        
    @Autowired
    private IEquipoService equipoServ;
    @Autowired
    private IJugadorService jugadorServ;
       
    @GetMapping ("/estadistica/{id}") // lo que se podrá ver en vista
    public ResponseEntity<JugadorDTO> prueba(@PathVariable Long id){


        Jugador jugador = jugadorServ.buscarJugador(id);
       Equipo equipo = equipoServ.buscarEquipo(id);
        
        double asistenciasPJ = this.promedioAsistenciasPorPartido(jugador.getAsistencias(), jugador.getPartidosJugados());
        
        double golesPJ = this.promedioGolesPorPartido(jugador.getGoles(), jugador.getPartidosJugados());
        
        
        JugadorDTO jugDto = new JugadorDTO();
        
        jugDto.setId_jug(jugador.getId_jug());
        jugDto.setNombreCompleto(jugador.getNombreCompleto());
        jugDto.setAsistPorPJ(asistenciasPJ);
        jugDto.setGolesPorPJ(golesPJ);
        jugDto.setAsistencias(jugador.getAsistencias());
        jugDto.setGoles(jugador.getGoles());
        jugDto.setEdad(jugador.getEdad());
        jugDto.setPartidosJugados(jugador.getPartidosJugados());
        jugDto.setEquipo(equipo.getNombre());
        jugDto.setNacionalidad(jugador.getNacionalidad());

         return ResponseEntity.ok(jugDto);
    }
     
     
     public double promedioGolesPorPartido(int goles, int partidosJugados) {
    if (partidosJugados == 0) {
        return 0;
    } return (double) goles / partidosJugados;
    }
    
    public double promedioAsistenciasPorPartido(int asist, int partidosJugados) {
        
    if (partidosJugados == 0) {
        return 0;
    } return (double)asist / partidosJugados;
    }
}