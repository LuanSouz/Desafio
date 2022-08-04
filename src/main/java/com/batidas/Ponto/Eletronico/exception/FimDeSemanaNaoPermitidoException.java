package com.batidas.Ponto.Eletronico.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class FimDeSemanaNaoPermitidoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public FimDeSemanaNaoPermitidoException() {
        super("Sábado e domingo não são permitidos como dia de trabalho");
    }
}
