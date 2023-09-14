package tech.bootcamp.desafio.ada.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.bootcamp.desafio.ada.entities.Character;
import tech.bootcamp.desafio.ada.payloads.request.CharacterRequest;
import tech.bootcamp.desafio.ada.payloads.response.CharacterResponse;
import tech.bootcamp.desafio.ada.services.CharacterService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/character")
@Tag(name = "Character", description = "controle de personagens")
public class CharacterController {

    private final CharacterService characterService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/", produces = "application/json" )
    @Operation(summary = "Realiza a criação de um novo Heroi/Monstro." )
    public CharacterResponse createCharacter(@RequestBody CharacterRequest characterRequest){
        return characterService.createCharacter(characterRequest);
    }

    @GetMapping(path = "/{characterId}", produces = "application/json" )
    @Operation(summary = "Coleta uma lista de todos os Herois/Monstros." )
    public Character getCharacterById(@PathVariable("characterId") String characterId){
        return characterService.getCharacterById(characterId);
    }

    @PutMapping(path = "/{characterId}", produces = "application/json" )
    @Operation(summary = "Atualiza Um Heroi/Monstro.")
    public CharacterResponse updateCharacter(@RequestBody CharacterRequest characterRequest,
                                             @PathVariable("characterId") String characterId ){
        return characterService.updateCharacter(characterRequest, characterId);
    }
}
