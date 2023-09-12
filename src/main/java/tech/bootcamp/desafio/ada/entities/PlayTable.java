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
        @Column(name = "play_table_id", nullable = false)
        private Long id;

        @OneToMany
        @JoinColumn(name = "round")
        private List<Round> roundsPlayed;

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinColumn(name = "player_id")
        private List<Player> players;

        @Column(name = "who_is_attacking")
        private String whoIsAttacking;

        @Column(name = "is_against_machine")
        private boolean isAgainstMachine;

}
