package tech.bootcamp.desafio.ada.services.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.bootcamp.desafio.ada.entities.Character;
import tech.bootcamp.desafio.ada.entities.Player;
import tech.bootcamp.desafio.ada.entities.enums.CharacterTypeEnum;
import tech.bootcamp.desafio.ada.entities.enums.PreviusStepTextEnum;
import tech.bootcamp.desafio.ada.exception.PreviousStepNotStartedException;
import tech.bootcamp.desafio.ada.exception.RollAlreadyDoneException;
import tech.bootcamp.desafio.ada.exception.SecondPlayerNotAMonsterException;
import tech.bootcamp.desafio.ada.payloads.request.CreateTableRequest;
import tech.bootcamp.desafio.ada.repositories.PlayerRepository;
import tech.bootcamp.desafio.ada.services.CharacterService;
import tech.bootcamp.desafio.ada.services.PlayerService;
import tech.bootcamp.desafio.ada.utils.DiceRollerUtil;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {
    private final CharacterService characterService;
    private final PlayerRepository playerRepository;

    @Override
    public List<Player> createPlayers(CreateTableRequest createTableRequest, boolean isAgainstMachine) {
        List<Player> players = new ArrayList<>();
        Player machine = new Player();

        players.add(buildPlayer(createTableRequest.getPlayerOneCharacterId(), createTableRequest.getPlayerOneName()));

        if(isAgainstMachine) {
            validIfTheSecondCharacterIsAMonster(characterService.getCharacterById(createTableRequest.getPlayerTwoCharacterId()));
            players.add(buildPlayer(createTableRequest.getPlayerTwoCharacterId(), createTableRequest.getPlayerTwoName()));
        }
        else{
            Character monsterBot = characterService.getOneRandomMonster();

            machine.setPlayerName("machine");
            machine.setCharacter(monsterBot);
            machine.setCharacterActualHealthPoints(monsterBot.getHealthPoints());
            players.add(machine);
        }

        List<Player> savedPlayer = playerRepository.saveAll(players);

        return savedPlayer;
    }

    @Override
    public Player updatePlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public List<Player> setPlayersIniciative(List<Player> players) {
        validIfIsInitiativeRound(players.get(0));

        Integer playerOneIniciative = 0;
        Integer playerTwoIniciative= 0;

        do {
            playerOneIniciative = DiceRollerUtil.rollDice(20);
            playerTwoIniciative = DiceRollerUtil.rollDice(20);
        } while (playerOneIniciative == playerTwoIniciative);

        players.get(0).setPlayerIniciative(playerOneIniciative);
        players.get(1).setPlayerIniciative(playerTwoIniciative);

        return playerRepository.saveAll(players);
    }

    private Player buildPlayer(String characterId, String playerName){
        Player player = new Player();

        Character character = characterService.getCharacterById(characterId);
        player.setCharacterActualHealthPoints(character.getHealthPoints());
        player.setPlayerName(playerName);
        player.setCharacter(character);

        return player;
    }

    private void validIfTheSecondCharacterIsAMonster(Character character){
        if (character.getType().equals(CharacterTypeEnum.Monster))
            throw new SecondPlayerNotAMonsterException();
    }


    private void validIfIsInitiativeRound(Player player){
        if (player.getPlayerIniciative() != null)
            throw new RollAlreadyDoneException();
    }
}
