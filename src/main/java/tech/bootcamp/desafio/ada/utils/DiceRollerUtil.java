package tech.bootcamp.desafio.ada.utils;

import lombok.RequiredArgsConstructor;
import tech.bootcamp.desafio.ada.entities.Dice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
public class DiceRollerUtil {

    public static Dice getRolledDice(Integer diceType){
        Dice dice = new Dice();

        dice.setDiceRollResult(rollDice(diceType));
        dice.setDiceType(diceType);

        return dice;
    }

    public static List<Dice> rollMultipleDice(Integer diceType, Integer numberOfDice) {
        List<Dice> dice = new ArrayList<>();

        for (int i = 0; i < numberOfDice; i++) dice.add(getRolledDice(diceType));

        return dice;
    }

    public static int rollDice(Integer diceType) {
        Random random = new Random();
        int result = random.nextInt(diceType) + 1;
        return result;
    }
}