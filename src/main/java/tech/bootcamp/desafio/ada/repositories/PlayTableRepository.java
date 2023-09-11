package tech.bootcamp.desafio.ada.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.bootcamp.desafio.ada.entities.PlayTable;

@Repository
public interface PlayTableRepository extends JpaRepository<PlayTable, String> {
}
