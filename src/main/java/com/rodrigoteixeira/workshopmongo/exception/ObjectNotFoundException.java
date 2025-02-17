package com.rodrigoteixeira.workshopmongo.exception;

public class ObjectNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String mensagem) {
        super(mensagem);
    }

}
