package tech.bootcamp.desafio.ada.exception;

public class SecondPlayerNotAMonsterException extends RuntimeException{
    public SecondPlayerNotAMonsterException(){
        super("por favor selecione um monstro para o segundo jogador");
    }
}
