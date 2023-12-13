
package com.futboldatos.jugadores.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Equipo {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id_equipo;
    private String nombre;
    private String pais;
    @OneToMany
    @JoinTable(
              name = "relacion_equipo_jug",
            joinColumns = @JoinColumn (name = "FK_EQUIPO", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "FK_JUGADOR", nullable = false)
    )
    private List<Jugador> listaJugadores;

    public Equipo() {
    }

    public Equipo(Long id_equipo, String nombre, String pais, List<Jugador> listaJugadores) {
        this.id_equipo = id_equipo;
        this.nombre = nombre;
        this.pais = pais;
        this.listaJugadores = listaJugadores;
    }
    
    
}
