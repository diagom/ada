package tech.bootcamp.desafio.ada.payloads.response;

import jakarta.persistence.Column;
import lombok.Data;
import tech.bootcamp.desafio.ada.entities.Player;
import tech.bootcamp.desafio.ada.entities.Round;

import java.util.List;

@Data
public class PlayTableRoundResponse {
    private Long id;
    private List<Player> players;
    private String whoIsAttacking;
    private List<Round> roundsPlayed;
    private boolean isAgainstMachine;
    private boolean isTheGameOver;
    private String winner;
}
