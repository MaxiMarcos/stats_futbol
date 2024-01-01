
package com.footballstats.players.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id_team;
    private String name;
    private String country;
    @OneToMany
    @JoinTable(
              name = "relacion_equipo_jug",
            joinColumns = @JoinColumn (name = "FK_EQUIPO", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "FK_JUGADOR", nullable = false)
    )
    private List<Player> listPlayers;
    
}
