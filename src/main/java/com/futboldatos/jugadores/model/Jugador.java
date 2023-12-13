
package com.futboldatos.jugadores.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Jugador {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id_jug;
    private String nombreCompleto;
    private String posicion;
    private int edad;
    private int partidosJugados;
    private int goles;
    private int asistencias;
    private double golesPorPJ;
    private double asistPorPJ;
    private int añoDebut;
    private String nacionalidad;
    private int partidosSeleccion;

    public Jugador() {
    }

    public Jugador(Long id_jug, String nombreCompleto, String posicion, int edad, int partidosJugados, int goles, int asistencias, double golesPorPJ, double asistPorPJ, int añoDebut, String nacionalidad, int partidosSeleccion) {
        this.id_jug = id_jug;
        this.nombreCompleto = nombreCompleto;
        this.posicion = posicion;
        this.edad = edad;
        this.partidosJugados = partidosJugados;
        this.goles = goles;
        this.asistencias = asistencias;
        this.golesPorPJ = golesPorPJ;
        this.asistPorPJ = asistPorPJ;
        this.añoDebut = añoDebut;
        this.nacionalidad = nacionalidad;
        this.partidosSeleccion = partidosSeleccion;
    }


}
