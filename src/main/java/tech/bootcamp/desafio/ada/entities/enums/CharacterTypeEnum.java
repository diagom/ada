package tech.bootcamp.desafio.ada.entities.enums;

public enum CharacterTypeEnum {
    Hero("Hero"),
    Monster("Monster");

    private String descriptor;

    CharacterTypeEnum(String descriptor) {
        this.descriptor = descriptor;
    }
    public String getDescriptor() {
        return descriptor;
    }
}
