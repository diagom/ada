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
        @OneToMany
        @JoinColumn(name = "character")
        private List<Character> character;

        @Column(name = "player_one_name")
        private String playerOneName;
        @Column(name = "player_two_name")
        private String playerTwoName;
        @Column(name = "who_is_attacking")
        private String whoIsAttacking;
        @Column(name = "is_against_machine")
        private boolean isAgainstMachine;
        @Column(name = "player_one_iniciative")
        private Integer playerOneIniciative;
        @Column(name = "player_two_iniciative")
        private Integer playerTwoIniciative;
}
