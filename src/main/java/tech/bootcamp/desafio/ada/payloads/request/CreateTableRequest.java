package tech.bootcamp.desafio.ada.payloads.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateTableRequest {

    private @NotNull String playerOneCharacter;
    private @NotNull String playerOneName;
    private String playerTwoCharacter;
    private String playerTwoName;
}
