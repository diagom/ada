package tech.bootcamp.desafio.ada.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.bootcamp.desafio.ada.entities.Player;

public interface PlayerRepository extends JpaRepository<Player, String> {
}
