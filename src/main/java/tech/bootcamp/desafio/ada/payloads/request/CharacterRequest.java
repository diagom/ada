package tech.bootcamp.desafio.ada.payloads.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CharacterRequest {

    private @NotNull String type;
    private @NotNull String name;
    private @NotNull String healthPoints;
    private @NotNull String strength;
    private @NotNull String defence;
    private @NotNull String agility;
    private @NotNull String damageDice;
    private @NotNull String daceType;
}
