package tech.bootcamp.desafio.ada.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tech.bootcamp.desafio.ada.payloads.response.PlayTableRoundResponse;
import tech.bootcamp.desafio.ada.services.RoundService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/round")
@Tag(name = "Partida", description = "Rodar dados de defesa ataque e dano")
public class RoundController {
    private final RoundService roundService;

    @PostMapping(path = "/{tableId}", produces = "application/json" )
    public PlayTableRoundResponse rollAttack(@PathVariable String tableId){
        return roundService.rollAttack(tableId);
    }

    @PutMapping(path = "/{tableId}", produces = "application/json" )
    public PlayTableRoundResponse rollDefend(@PathVariable String tableId){
        return roundService.rollDefend(tableId);
    }

    @PutMapping(path = "/damage/{tableId}", produces = "application/json" )
    public PlayTableRoundResponse rollDamage(@PathVariable String tableId){
        return roundService.rollDamage(tableId);
    }
}
