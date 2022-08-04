package com.batidas.Ponto.Eletronico.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class HorarioVazioNaoPermitidoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public HorarioVazioNaoPermitidoException() {
        super("O campo Hora não pode ser vazio");
    }
}
