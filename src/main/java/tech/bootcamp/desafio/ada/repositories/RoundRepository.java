package tech.bootcamp.desafio.ada.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.bootcamp.desafio.ada.entities.Round;

@Repository
public interface RoundRepository extends JpaRepository<Round, String> {
}
