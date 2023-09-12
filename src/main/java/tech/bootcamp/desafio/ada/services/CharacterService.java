package tech.bootcamp.desafio.ada.services;

import org.springframework.web.bind.annotation.RequestBody;
import tech.bootcamp.desafio.ada.entities.Character;
import tech.bootcamp.desafio.ada.payloads.request.CharacterRequest;
import tech.bootcamp.desafio.ada.payloads.response.CharacterResponse;

import java.util.List;

public interface CharacterService {

    CharacterResponse createCharacter(CharacterRequest CharacterRequest);
    CharacterResponse updateCharacter(CharacterRequest characterRequest, String characterId);
    List<CharacterResponse> getAllCharacter();
    List<CharacterResponse> getAllMonsters();
    Character getOneRandomMonster();
    Character getCharacterById(String id);
    void deleteCharacter(String id);
}
