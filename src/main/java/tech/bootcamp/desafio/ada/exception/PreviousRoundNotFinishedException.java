package tech.bootcamp.desafio.ada.exception;

public class PreviousRoundNotFinishedException extends RuntimeException  {

    public PreviousRoundNotFinishedException(){
        super("A rodada de ataque nao pode ser iniciada antes da rodada de rolar iniciativa");
    }
}
