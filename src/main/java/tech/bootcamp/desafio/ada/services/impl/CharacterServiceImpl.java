package tech.bootcamp.desafio.ada.services.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import tech.bootcamp.desafio.ada.entities.Character;
import tech.bootcamp.desafio.ada.exception.NotFoundException;
import tech.bootcamp.desafio.ada.payloads.request.CharacterRequest;
import tech.bootcamp.desafio.ada.payloads.response.CharacterResponse;
import tech.bootcamp.desafio.ada.payloads.response.TableResponse;
import tech.bootcamp.desafio.ada.repositories.CharacterRepository;
import tech.bootcamp.desafio.ada.services.CharacterService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService {
    private final CharacterRepository characterRepository;
    private final ModelMapper modelMapper;

    @Override
    public CharacterResponse createCharacter(CharacterRequest characterRequest) {
        Character newCharacter = modelMapper.map(characterRequest, Character.class);
        Character savedCharacter = characterRepository.save(newCharacter);
        return modelMapper.map(savedCharacter, CharacterResponse.class);
    }

    @Override
    public CharacterResponse updateCharacter(CharacterRequest characterRequest, String characterId) {
        characterRepository.findById(characterId).orElseThrow(() -> new NotFoundException(characterId));
        Character newCharacter = modelMapper.map(characterRequest, Character.class);
        newCharacter.setId(Long.parseLong(characterId));
        Character savedCharacter = characterRepository.save(newCharacter);
        return modelMapper.map(savedCharacter, CharacterResponse.class);
    }

    @Override
    public List<CharacterResponse> getAllCharacter() {
        List<Character> playTables = characterRepository.findAll();
        return modelMapper.map(playTables, new TypeToken<List<TableResponse>>() {}.getType());
    }

    @Override
    public List<CharacterResponse> getAllMonsters() {
        List<Character> characters = characterRepository.findAllByType("Monster");
        return modelMapper.map(characters, new TypeToken<List<TableResponse>>() {}.getType());
    }

    @Override
    public Character getOneRandomMonster() {
        return characterRepository.findCharacterByTypeAndOrderByRandom();
    }

    @Override
    public Character getCharacterById(String id) {
        return characterRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    @Override
    public void deleteCharacter(String id) {
        Character character = characterRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        characterRepository.delete(character);
    }
}
