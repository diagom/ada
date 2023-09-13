package tech.bootcamp.desafio.ada.services.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tech.bootcamp.desafio.ada.entities.Character;
import tech.bootcamp.desafio.ada.entities.Dice;
import tech.bootcamp.desafio.ada.entities.PlayTable;
import tech.bootcamp.desafio.ada.entities.Player;
import tech.bootcamp.desafio.ada.entities.Round;
import tech.bootcamp.desafio.ada.payloads.response.PlayTableRoundResponse;
import tech.bootcamp.desafio.ada.repositories.RoundRepository;
import tech.bootcamp.desafio.ada.services.PlayTableService;
import tech.bootcamp.desafio.ada.services.PlayerService;
import tech.bootcamp.desafio.ada.services.RoundService;
import tech.bootcamp.desafio.ada.utils.DiceRollerUtil;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoundServiceImpl implements RoundService {
    private final RoundRepository roundRepository;
    private final PlayTableService playTableService;
    private final PlayerService playerService;
    private final ModelMapper modelMapper;

    @Override
    public PlayTableRoundResponse rollAttack(String tableId) {
        PlayTable playTable = playTableService.getTableById(tableId);
        Dice rollAttack = DiceRollerUtil.getRolledDice(12);
        List<Round> rounds = playTable.getRoundsPlayed();
        Player attacker = getWhoIsRound(playTable, true);

        Round newRound = new Round();

        newRound.setAttackerName(attacker.getPlayerName());
        newRound.setDiceRolls(new ArrayList<>());
        newRound.setRollAttacker(rollAttack.getDiceRollResult());
        newRound.setIsRoundFinished(false);
        newRound.setIsRoundFinished(false);
        newRound.setTotalRollAttacker(rollAttack.getDiceRollResult() +
                attacker.getCharacter().getAgility() +
                attacker.getCharacter().getStrength());

        rounds.add(newRound);
        playTable.setRoundsPlayed(rounds);

        roundRepository.save(newRound);

        return playTableService.updateTable(playTable);
    }

    @Override
    public PlayTableRoundResponse rollDefend(String tableId) {
        PlayTable playTable = playTableService.getTableById(tableId);
        Dice rollDefend = DiceRollerUtil.getRolledDice(12);
        List<Round> rounds = playTable.getRoundsPlayed();
        Player defender = getWhoIsRound(playTable, false);

        Round DefendRound = rounds.get(rounds.size() - 1);

        DefendRound.setDefenderName(defender.getPlayerName());
        DefendRound.setRollDefender(rollDefend.getDiceRollResult());
        DefendRound.setTotalRollDefender(rollDefend.getDiceRollResult() +
                defender.getCharacter().getAgility() +
                defender.getCharacter().getDefence());
        DefendRound.setWasAttackSuccessful(DefendRound.getTotalRollAttacker() > DefendRound.getTotalRollDefender());
        DefendRound.setIsRoundFinished(DefendRound.getTotalRollAttacker() < DefendRound.getTotalRollDefender());

        rounds.set(rounds.size() - 1, DefendRound);

        roundRepository.save(DefendRound);

        return modelMapper.map(playTableService.getTableById(tableId), PlayTableRoundResponse.class);
    }

    @Override
    public PlayTableRoundResponse rollDamage(String tableId) {
        PlayTable playTable = playTableService.getTableById(tableId);
        List<Round> rounds = playTable.getRoundsPlayed();
        Round damageRound = rounds.get(rounds.size() - 1);
        Player defender = getWhoIsRound(playTable, false);
        Character attacker = getWhoIsRound(playTable, true).getCharacter();
        List<Dice> rollDamage = DiceRollerUtil.rollMultipleDice(attacker.getDiceType(), attacker.getDamageDice());
        Integer totalRollDamage = DiceRollerUtil.sumDiceResults(rollDamage);

        damageRound.setIsRoundFinished(true);
        damageRound.setTotalDamage(totalRollDamage);
        defender.setCharacterActualHealthPoints(defender.getCharacterActualHealthPoints() - totalRollDamage);
        playTable.setWhoIsAttacking(defender.getPlayerName());

        playerService.updatePlayer(defender);
        roundRepository.save(damageRound);

        return playTableService.updateTable(validIfTheGameOver(playTable, defender));
    }

    private Player getWhoIsRound(PlayTable playTable, boolean isAttacking){

        if(isAttacking){
            return playTable.getPlayers().stream()
                    .filter(player -> playTable.getWhoIsAttacking().equals(player.getPlayerName()))
                    .findAny()
                    .orElse(null);
        }else{
            return playTable.getPlayers().stream()
                    .filter(player -> !playTable.getWhoIsAttacking().equals(player.getPlayerName()))
                    .findAny()
                    .orElse(null);
        }
    }

    private PlayTable validIfTheGameOver(PlayTable playTable, Player player){
        boolean theGameHaveAWinner = player.getCharacterActualHealthPoints() <= 0;

        if(theGameHaveAWinner) {
            playTable.setTheGameOver(true);
            playTable.setWinner(player.getPlayerName());
        }

        return playTable;
    }
}
