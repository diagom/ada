package tech.bootcamp.desafio.ada.services;

import tech.bootcamp.desafio.ada.payloads.response.PlayTableRoundResponse;

public interface RoundService {

    PlayTableRoundResponse rollAttack(String tableId);

    PlayTableRoundResponse rollDefend(String tableId);

    PlayTableRoundResponse rollDamage(String tableId);

}
