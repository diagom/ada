package tech.bootcamp.desafio.ada.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Log")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "LogId", nullable = false)
    private Long id;

    @OneToMany
    @JoinColumn(name = "roundId")
    private List<Round> RoundsPlayed;

    @OneToMany
    @JoinColumn(name = "playerId")
    private List<Player> players;

    private String playerOneIniciative;
    private String playerTwoIniciative;

}
