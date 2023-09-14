package tech.bootcamp.desafio.ada.entities.enums;

public enum PreviusStepTextEnum {
    Iniciative("A rolar iniciativa"),
    Defence("A rodada de defesa"),
    Damage("rodada de dano"),
    Attack("A rodada de ataque");

    private String descriptor;

    PreviusStepTextEnum(String descriptor) {
        this.descriptor = descriptor;
    }
    public String getDescriptor() {
        return descriptor;
    }
}
