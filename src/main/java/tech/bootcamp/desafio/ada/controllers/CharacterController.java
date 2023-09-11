package tech.bootcamp.desafio.ada.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tech.bootcamp.desafio.ada.payloads.request.CharacterRequest;
import tech.bootcamp.desafio.ada.payloads.response.CharacterResponse;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/character")
@Tag(name = "Character", description = "controle de personagens")
public class CharacterController {

    @PostMapping(path = "/", produces = "application/json" )
    public CharacterResponse createTable(@RequestBody CharacterRequest characterRequest){
        return new CharacterResponse();
    }

    @GetMapping(path = "/{tableId}", produces = "application/json" )
    public CharacterResponse getTable(){
        return new CharacterResponse();
    }

    @DeleteMapping(path = "/{tableId}", produces = "application/json" )
    public CharacterResponse deleteTable(){
        return new CharacterResponse();
    }

    @PutMapping(path = "/{tableId}", produces = "application/json" )
    public CharacterResponse rollIniciative(@RequestBody CharacterRequest characterRequest){
        return new CharacterResponse();
    }
}
