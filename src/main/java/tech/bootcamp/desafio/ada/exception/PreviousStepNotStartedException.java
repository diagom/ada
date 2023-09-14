package tech.bootcamp.desafio.ada.exception;

import tech.bootcamp.desafio.ada.entities.enums.PreviusStepTextEnum;

public class PreviousStepNotStartedException extends RuntimeException{

    public PreviousStepNotStartedException(PreviusStepTextEnum previewStep, PreviusStepTextEnum actualStep ){
        super(previewStep.getDescriptor() + " nao pode ser iniciada antes da " + actualStep.getDescriptor());
    }
}
