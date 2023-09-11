package tech.bootcamp.desafio.ada.payloads.response;

import lombok.Data;

@Data
public class RollAttackResponse {

    private String attackerName;
    private String rollAttacker;
    private String totalRollAttacker;
    private Boolean wasAttackSuccessful;
}
