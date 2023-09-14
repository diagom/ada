package tech.bootcamp.desafio.ada.entities.enums;

public enum AttackErrorTextEnum {

    RoundNotFinished("A rodada de ataque so pode ser iniciada apois as rodadas de defesa e dano terem sido terminadas"),
    GameIsFinished("Essa partida acabou por favor inicie uma messa nova"),
    IniciativeNotRolled("A rodada de ataque nao pode ser iniciada antes da rodada de rolar iniciativa");

    private String descriptor;

    AttackErrorTextEnum(String descriptor) {
        this.descriptor = descriptor;
    }
    public String getDescriptor() {
        return descriptor;
    }
}
