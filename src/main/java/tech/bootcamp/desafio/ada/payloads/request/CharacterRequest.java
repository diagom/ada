package tech.bootcamp.desafio.ada.payloads.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import tech.bootcamp.desafio.ada.entities.enums.CharacterTypeEnum;

@Data
public class CharacterRequest {

    private @NotNull CharacterTypeEnum type;
    private @NotNull String name;
    private @NotNull Integer healthPoints;
    private @NotNull Integer strength;
    private @NotNull Integer defence;
    private @NotNull Integer agility;
    private @NotNull Integer damageDice;
    private @NotNull Integer diceType;
}
