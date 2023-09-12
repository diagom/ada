package tech.bootcamp.desafio.ada.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tech.bootcamp.desafio.ada.entities.Character;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<Character, String> {
    List<Character> findAllByType(String type);

    @Query(nativeQuery=true, value="SELECT * FROM character WHERE type = 'Monster' ORDER BY random() LIMIT 1")
    Character findCharacterByTypeAndOrderByRandom();
}
