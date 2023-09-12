package tech.bootcamp.desafio.ada.payloads.response;

import lombok.Data;
import tech.bootcamp.desafio.ada.entities.Player;

import java.util.List;

@Data
public class TableResponse {

    private Long id;
    private List<Player> players;
    private String whoIsAttacking;
    private boolean isAgainstMachine;
}
