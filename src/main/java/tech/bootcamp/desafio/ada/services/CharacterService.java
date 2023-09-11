package tech.bootcamp.desafio.ada.services;

import org.springframework.web.bind.annotation.RequestBody;
import tech.bootcamp.desafio.ada.payloads.request.CharacterRequest;
import tech.bootcamp.desafio.ada.payloads.response.CharacterResponse;

public interface CharacterService {

    CharacterResponse createCharacter(CharacterRequest CharacterRequest);
    CharacterResponse updateCharacter(CharacterRequest characterRequest, String characterId);
    CharacterResponse getCharacterById(String id);
    void deleteCharacter(String id);
}
