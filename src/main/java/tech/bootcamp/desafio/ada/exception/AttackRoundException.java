package tech.bootcamp.desafio.ada.exception;

import tech.bootcamp.desafio.ada.entities.enums.AttackErrorTextEnum;

public class AttackRoundException extends RuntimeException {

    public AttackRoundException(AttackErrorTextEnum text){
        super(text.getDescriptor());
    }
}
