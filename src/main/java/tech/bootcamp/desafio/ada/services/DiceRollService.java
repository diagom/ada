package tech.bootcamp.desafio.ada.services;

import tech.bootcamp.desafio.ada.entities.Dice;
import tech.bootcamp.desafio.ada.payloads.request.CreateTableRequest;

import java.util.List;

public interface DiceRollService {
    List<Dice> saveDiceRolls(List<Dice> rolls);

}
