package tech.bootcamp.desafio.ada.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "player_id", nullable = false)
    private Long id;

    @Column(name = "player_name")
    private String playerName;

    @Column(name = "player_iniciative")
    private Integer playerIniciative;

    @Column(name = "character_actual_health_points")
    private Integer characterActualHealthPoints;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "character_id")
    private Character character;
}
