package tech.bootcamp.desafio.ada.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.bootcamp.desafio.ada.entities.Dice;
import tech.bootcamp.desafio.ada.repositories.DiceRepository;
import tech.bootcamp.desafio.ada.services.DiceRollService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiceRollServiceImpl implements DiceRollService {
    private final DiceRepository diceRepository;

    @Override
    public List<Dice> saveDiceRolls(List<Dice> rolls) {
        return diceRepository.saveAll(rolls);
    }
}
