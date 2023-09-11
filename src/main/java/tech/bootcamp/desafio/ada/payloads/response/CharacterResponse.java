package tech.bootcamp.desafio.ada.payloads.response;

import lombok.Data;

@Data
public class CharacterResponse {

    private Long id;
    private String type;
    private String name;
    private String healthPoints;
    private String strength;
    private String defence;
    private String agility;
    private String damageDice;
    private String diceType;
}
