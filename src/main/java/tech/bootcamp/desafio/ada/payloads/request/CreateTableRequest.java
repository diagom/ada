package tech.bootcamp.desafio.ada.payloads.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateTableRequest {

    private @NotNull String playerOneCharacterId;
    private @NotNull String playerOneName;
    private String playerTwoCharacterId;
    private String playerTwoName;
}
