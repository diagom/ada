package tech.bootcamp.desafio.ada.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String id ){
        super("Registro do id "+id+" não foi encontrado" );
    }
}
