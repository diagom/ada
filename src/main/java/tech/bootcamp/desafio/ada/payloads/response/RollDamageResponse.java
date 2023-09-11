package tech.bootcamp.desafio.ada.payloads.response;

import lombok.Data;
import tech.bootcamp.desafio.ada.entities.Dice;

import java.util.List;

@Data
public class RollDamageResponse {

    private List<Dice> diceRolls;

    private String attackerName;
    private String defenderName;
    private String rollDefender;
    private String rollAttacker;
    private String totalRollDefender;
    private String totalRollAttacker;
    private String damageTotalDamage;
    private Boolean wasAttackSuccessful;
    private Boolean isRoundFinished;
}
