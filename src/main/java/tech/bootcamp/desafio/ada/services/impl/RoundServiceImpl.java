package tech.bootcamp.desafio.ada.services.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tech.bootcamp.desafio.ada.entities.Character;
import tech.bootcamp.desafio.ada.entities.Dice;
import tech.bootcamp.desafio.ada.entities.PlayTable;
import tech.bootcamp.desafio.ada.entities.Player;
import tech.bootcamp.desafio.ada.entities.Round;
import tech.bootcamp.desafio.ada.entities.enums.AttackErrorTextEnum;
import tech.bootcamp.desafio.ada.entities.enums.PreviusStepTextEnum;
import tech.bootcamp.desafio.ada.exception.AttackRoundException;
import tech.bootcamp.desafio.ada.exception.PreviousStepNotStartedException;
import tech.bootcamp.desafio.ada.payloads.response.PlayTableRoundResponse;
import tech.bootcamp.desafio.ada.repositories.RoundRepository;
import tech.bootcamp.desafio.ada.services.DiceRollService;
import tech.bootcamp.desafio.ada.services.PlayTableService;
import tech.bootcamp.desafio.ada.services.PlayerService;
import tech.bootcamp.desafio.ada.services.RoundService;
import tech.bootcamp.desafio.ada.utils.DiceRollerUtil;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoundServiceImpl implements RoundService {
    private final RoundRepository roundRepository;
    private final PlayTableService playTableService;
    private final DiceRollService diceRollService;
    private final PlayerService playerService;
    private final ModelMapper modelMapper;

    @Override
    public PlayTableRoundResponse rollAttack(String tableId) {
        PlayTable playTable = mapGetPlayTableById(tableId);

        validIfIsAttackRound(playTable);

        Dice rollAttack = DiceRollerUtil.getRolledDice(12);
        Player attacker = getWhoIsRound(playTable, true);
        Round newRound = createNewRound(attacker, rollAttack);

        saveRound(newRound);
        playTable.setRoundsPlayed(updateRondsList(playTable, newRound));

        return updateTableAndReturnResponse(playTable);
    }

    @Override
    public PlayTableRoundResponse rollDefend(String tableId) {
        PlayTable playTable = mapGetPlayTableById(tableId);
        Round defendRound = getLatestRound(playTable);

        validIfIsDefenderRound(defendRound);

        Dice rollDefend = DiceRollerUtil.getRolledDice(12);
        Player defender = getWhoIsRound(playTable, false);

        updateDefendRound(defendRound, defender, rollDefend);
        saveRound(defendRound);

        return updateTableAndReturnResponse(playTable);
    }

    @Override
    public PlayTableRoundResponse rollDamage(String tableId) {
        PlayTable playTable = mapGetPlayTableById(tableId);
        Round damageRound = getLatestRound(playTable);

        validIfIsDamageRound(damageRound);

        Player defender = getWhoIsRound(playTable, false);
        Character attackerCharacter = getWhoIsRound(playTable, true).getCharacter();
        List<Dice> rollDamage = DiceRollerUtil.rollMultipleDice(attackerCharacter.getDiceType(), attackerCharacter.getDamageDice());
        int totalRollDamage = DiceRollerUtil.sumDiceResults(rollDamage) - attackerCharacter.getStrength();

        diceRollService.saveDiceRolls(rollDamage);
        updateDamageRound(damageRound, totalRollDamage, rollDamage, defender, playTable);
        saveRound(damageRound);
        playerService.updatePlayer(defender);

        return updateTableAndReturnResponse(validIfTheGameOver(playTable, defender));
    }

    private Round createNewRound(Player attacker, Dice rollAttack) {
        Round newRound = new Round();
        newRound.setAttackerName(attacker.getPlayerName());
        newRound.setRollAttacker(rollAttack.getDiceRollResult());
        newRound.setIsRoundFinished(false);
        newRound.setTotalRollAttacker(rollAttack.getDiceRollResult() +
                attacker.getCharacter().getAgility() +
                attacker.getCharacter().getStrength());
        return newRound;
    }

    private void updateDefendRound(Round defendRound, Player defender, Dice rollDefend) {
        defendRound.setDefenderName(defender.getPlayerName());
        defendRound.setRollDefender(rollDefend.getDiceRollResult());
        defendRound.setTotalRollDefender(rollDefend.getDiceRollResult() +
                defender.getCharacter().getAgility() +
                defender.getCharacter().getDefence());
        defendRound.setWasAttackSuccessful(defendRound.getTotalRollAttacker() > defendRound.getTotalRollDefender());
        defendRound.setIsRoundFinished(defendRound.getTotalRollAttacker() < defendRound.getTotalRollDefender());
    }

    private void updateDamageRound(Round damageRound, int totalRollDamage, List<Dice> rollDamage, Player defender, PlayTable playTable) {
        damageRound.setIsRoundFinished(true);
        damageRound.setTotalDamage(totalRollDamage);
        damageRound.setDiceRolls(rollDamage);
        defender.setCharacterActualHealthPoints(defender.getCharacterActualHealthPoints() - totalRollDamage);
        playTable.setWhoIsAttacking(defender.getPlayerName());
        playTableService.updateTable(validIfTheGameOver(playTable, defender));
    }

    private PlayTable mapGetPlayTableById(String tableId) {
        return modelMapper.map(playTableService.getTableById(tableId), PlayTable.class);
    }

    private void saveRound(Round round) {
        roundRepository.save(round);
    }

    private PlayTableRoundResponse updateTableAndReturnResponse(PlayTable playTable) {
        return modelMapper.map(playTableService.updateTable(playTable), PlayTableRoundResponse.class);
    }

    private Round getLatestRound(PlayTable playTable) {
        List<Round> rounds = playTable.getRoundsPlayed();
        return rounds.get(rounds.size() - 1);
    }

    private List<Round> updateRondsList(PlayTable playTable, Round newRound) {
        List<Round> rounds = playTable.getRoundsPlayed();
        rounds.add(newRound);
        return rounds;
    }

    private Player getWhoIsRound(PlayTable playTable, boolean isAttacking) {
        String attackingPlayerName = playTable.getWhoIsAttacking();
        return playTable.getPlayers().stream()
                .filter(player -> isAttacking ? attackingPlayerName.equals(player.getPlayerName()) : !attackingPlayerName.equals(player.getPlayerName()))
                .findAny()
                .orElse(null);
    }

    private PlayTable validIfTheGameOver(PlayTable playTable, Player player) {
        boolean theGameHaveAWinner = player.getCharacterActualHealthPoints() <= 0;

        if (theGameHaveAWinner) {
            playTable.setTheGameOver(true);
            playTable.setWinner(player.getPlayerName());
        }
        return playTable;
    }

    private void validIfIsAttackRound(PlayTable playTable){
        if (playTable.getPlayers().get(0).getPlayerIniciative() == null)
            throw new AttackRoundException(AttackErrorTextEnum.IniciativeNotRolled);
        else if (!getLatestRound(playTable).getIsRoundFinished())
            throw new AttackRoundException(AttackErrorTextEnum.RoundNotFinished);
        else if (playTable.getWinner() != null)
            throw new AttackRoundException(AttackErrorTextEnum.GameIsFinished);
    }

    private void validIfIsDefenderRound(Round defendRound){
        if (defendRound.getRollAttacker() == null)
            throw new PreviousStepNotStartedException(PreviusStepTextEnum.Attack, PreviusStepTextEnum.Defence);
    }

    private void validIfIsDamageRound(Round defendRound){
        if (defendRound.getRollDefender() == null)
            throw new PreviousStepNotStartedException(PreviusStepTextEnum.Defence, PreviusStepTextEnum.Damage);
    }
}