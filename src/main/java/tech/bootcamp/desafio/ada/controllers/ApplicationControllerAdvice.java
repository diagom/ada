package tech.bootcamp.desafio.ada.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tech.bootcamp.desafio.ada.exception.*;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String NotFoundException(NotFoundException ex){
        return "Error: " +  ex.getMessage();
    }

    @ExceptionHandler(AttackRoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String AttackRoundException(AttackRoundException ex){
        return "Error: " + ex.getMessage();
    }

    @ExceptionHandler(PreviousStepNotStartedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String PreviousStepNotStartedException(PreviousStepNotStartedException ex){
        return "Error: " + ex.getMessage();
    }

    @ExceptionHandler(SecondPlayerNotAMonsterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String SecondPlayerNotAMonsterException(SecondPlayerNotAMonsterException ex){
        return "Error: " + ex.getMessage();
    }

    @ExceptionHandler(RollAlreadyDoneException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String RollAlreadyDoneException(RollAlreadyDoneException ex){
        return "Error: " + ex.getMessage();
    }
}
