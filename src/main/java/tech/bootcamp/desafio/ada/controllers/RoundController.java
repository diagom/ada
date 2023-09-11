package tech.bootcamp.desafio.ada.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tech.bootcamp.desafio.ada.payloads.response.RollAttackResponse;
import tech.bootcamp.desafio.ada.payloads.response.RollDamageResponse;
import tech.bootcamp.desafio.ada.payloads.response.RollDefendResponse;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/round")
@Tag(name = "Partida", description = "Rodar dados de defesa ataque e dano")
public class RoundController {

    @PostMapping(path = "/{tableid}", produces = "application/json" )
    public RollAttackResponse RollAttack(){
        return new RollAttackResponse();
    }

    @PutMapping(path = "/{tableid}", produces = "application/json" )
    public RollDefendResponse rollDefend(){
        return new RollDefendResponse();
    }

    @PutMapping(path = "/damage", produces = "application/json" )
    public RollDamageResponse rollDamage(){
        return new RollDamageResponse();
    }
}
