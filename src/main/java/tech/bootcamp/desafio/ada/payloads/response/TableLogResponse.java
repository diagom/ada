package tech.bootcamp.desafio.ada.payloads.response;

import lombok.Data;
import tech.bootcamp.desafio.ada.entities.Round;

import java.util.List;

@Data
public class TableLogResponse {

    private Long id;
    private List<Round> roundsPlayed;
    private List<Character> character;
    private String playerOneName;
    private String playerTwoName;
    private String whoIsAttacking;
    private boolean isAgainstMachine;
    private String playerOneIniciative;
    private String playerTwoIniciative;
}
