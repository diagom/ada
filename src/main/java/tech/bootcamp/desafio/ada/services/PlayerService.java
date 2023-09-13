package tech.bootcamp.desafio.ada.services;

import tech.bootcamp.desafio.ada.entities.Player;
import tech.bootcamp.desafio.ada.payloads.request.CreateTableRequest;

import java.util.List;

public interface PlayerService {

    List<Player> createPlayers(CreateTableRequest createTableRequest, boolean isAgainstMachine);
    Player updatePlayer(Player player);
    List<Player> setPlayersIniciative(List<Player> player);

}
