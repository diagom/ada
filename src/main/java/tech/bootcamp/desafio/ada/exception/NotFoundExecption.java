package tech.bootcamp.desafio.ada.exception;

public class NotFoundExecption extends RuntimeException {

    public NotFoundExecption(String id ){
        super("Registro do id "+id+" não foi encontrado" );
    }
}
