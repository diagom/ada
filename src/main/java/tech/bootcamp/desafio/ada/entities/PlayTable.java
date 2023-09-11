package tech.bootcamp.desafio.ada.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "play_table")
public class PlayTable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "LogId", nullable = false)
    private Long id;

    @OneToMany
    @JoinColumn(name = "playerId")
    private List<Player> players;

    @OneToMany
    @JoinColumn(name = "caracterId")
    private List<Character> character;

    private String whoIsAttacking;
    private boolean isAgainstMachine;
}
