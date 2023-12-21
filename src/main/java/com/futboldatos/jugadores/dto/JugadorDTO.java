
package com.futboldatos.jugadores.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class JugadorDTO {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id_jug;
    private String nombreCompleto;
    private int edad;
    private int partidosJugados;
    private int goles;
    private int asistencias;
    private double golesPorPJ;
    private double asistPorPJ;
    private String nacionalidad;
    private String equipo;

    public JugadorDTO () {
    }

    public JugadorDTO(Long id_jug, String nombreCompleto, int edad, int partidosJugados, int goles, int asistencias, double golesPorPJ, double asistPorPJ, String nacionalidad) {
        this.id_jug = id_jug;
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.partidosJugados = partidosJugados;
        this.goles = goles;
        this.asistencias = asistencias;
        this.golesPorPJ = golesPorPJ;
        this.asistPorPJ = asistPorPJ;
        this.nacionalidad = nacionalidad;

    }


}
