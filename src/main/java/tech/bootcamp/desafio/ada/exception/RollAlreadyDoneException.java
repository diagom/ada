package tech.bootcamp.desafio.ada.exception;

public class RollAlreadyDoneException extends RuntimeException{

        public RollAlreadyDoneException( ){
        super("Esses dados ja foram Rolados por favor executar o proximo passo");
    }
}
