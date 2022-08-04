package com.batidas.Ponto.Eletronico.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class LimiteDeRegistrosPorDiaExcedidoException  extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public LimiteDeRegistrosPorDiaExcedidoException() {
        super("Apenas 4 horários podem ser registrados por dia");
    }
}
