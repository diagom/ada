package tech.bootcamp.desafio.ada.exception;

import tech.bootcamp.desafio.ada.entities.enums.PreviusStepTextEnum;

public class SecondPlayerNotAMonsterException extends RuntimeException{
    public SecondPlayerNotAMonsterException(){
        super("por favor selecione um monstro para o segundo jogador");
    }
}
