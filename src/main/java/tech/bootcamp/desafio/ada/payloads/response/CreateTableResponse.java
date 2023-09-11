package tech.bootcamp.desafio.ada.payloads.response;

import lombok.Data;

@Data
public class CreateTableResponse {

    private Long id;
    private String playerOneCharacter;
    private String playerOneName;
    private String playerTwoCharacter;
    private String playerTwoName;
    private boolean isAgainstMachine;
}
