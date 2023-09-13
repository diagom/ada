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

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinColumn(name = "round" )
        private List<Round> roundsPlayed;

        @OneToMany(fetch = FetchType.EAGER)
        @JoinColumn(name = "player")
        private List<Player> players;

        @Column(name = "winner")
        private String winner ;

        @Column(name = "who_is_attacking")
        private String whoIsAttacking;

        @Column(name = "is_against_machine")
        private boolean isAgainstMachine;

        @Column(name = "is_the_game_over")
        private boolean isTheGameOver;
}
