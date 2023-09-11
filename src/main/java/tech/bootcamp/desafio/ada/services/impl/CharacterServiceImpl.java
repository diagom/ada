package tech.bootcamp.desafio.ada.services.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tech.bootcamp.desafio.ada.entities.Character;
import tech.bootcamp.desafio.ada.exception.NotFoundExecption;
import tech.bootcamp.desafio.ada.payloads.request.CharacterRequest;
import tech.bootcamp.desafio.ada.payloads.response.CharacterResponse;
import tech.bootcamp.desafio.ada.repositories.CharacterRepository;
import tech.bootcamp.desafio.ada.services.CharacterService;

@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService {
    private final CharacterRepository characterRepository;
    private final ModelMapper modelMapper;

    @Override
    public CharacterResponse createCharacter(CharacterRequest characterRequest) {
        Character newCharacter = modelMapper.map(characterRequest, Character.class);
        Character savedCharacter = characterRepository.save(newCharacter);
        CharacterResponse characterResponse = modelMapper.map(savedCharacter, CharacterResponse.class);

        return characterResponse;
    }

    @Override
    public CharacterResponse updateCharacter(CharacterRequest characterRequest, String characterId) {
        characterRepository.findById(characterId).orElseThrow(() -> new NotFoundExecption(characterId));
        Character newCharacter = modelMapper.map(characterRequest, Character.class);
        newCharacter.setId(Long.parseLong(characterId));
        Character savedCharacter = characterRepository.save(newCharacter);
        CharacterResponse characterResponse = modelMapper.map(savedCharacter, CharacterResponse.class);

        return characterResponse;
    }

    @Override
    public CharacterResponse getCharacterById(String id) {
        Character character = characterRepository.findById(id).orElseThrow(() -> new NotFoundExecption(id));
        CharacterResponse characterResponse = modelMapper.map(character, CharacterResponse.class );
        return characterResponse;
    }

    @Override
    public void deleteCharacter(String id) {
        Character character = characterRepository.findById(id).orElseThrow(() -> new NotFoundExecption(id));
        characterRepository.delete(character);
    }
}
