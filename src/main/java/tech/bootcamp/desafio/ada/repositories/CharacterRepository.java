package tech.bootcamp.desafio.ada.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.bootcamp.desafio.ada.entities.Character;

@Repository
public interface CharacterRepository extends JpaRepository<Character, String> {
}
