package tech.bootcamp.desafio.ada.payloads.response;

import lombok.Data;

@Data
public class RollDefendResponse {

    private String attackerName;
    private String defenderName;
    private String rollDefender;
    private String rollAttacker;
    private String totalRollDefender;
    private String totalRollAttacker;
    private Boolean wasAttackSuccessful;
    private Boolean isRoundFinished;
}
