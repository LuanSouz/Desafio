package com.batidas.Ponto.Eletronico.exception;

public class HorarioDeAlmocoObrigatorioException  extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public HorarioDeAlmocoObrigatorioException() {
        super("Deve haver no mínimo 1 hora de almoço");
    }
}
