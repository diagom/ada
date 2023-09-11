package tech.bootcamp.desafio.ada.payloads.response;

import lombok.Data;

import java.util.List;

@Data
public class TableResponse {

    private Long id;
    private List<Character> character;
    private String playerOneName;
    private String playerTwoName;
    private String whoIsAttacking;
    private boolean isAgainstMachine;
}
