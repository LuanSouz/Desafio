package com.batidas.Ponto.Eletronico.exceptionhandler;

import com.batidas.Ponto.Eletronico.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler {


	@ExceptionHandler(HorarioVazioNaoPermitidoException.class)
	public ResponseEntity<?> handleFimDeSemanaNaoPermitidoExceptio(HorarioVazioNaoPermitidoException ex) {
		ApiError apiError = new ApiError();
		apiError.setDataHora(LocalDateTime.now());
		apiError.setMensagem(ex.getMessage());

		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(apiError);
	}

	@ExceptionHandler(FimDeSemanaNaoPermitidoException.class)
	public ResponseEntity<?> handleFimDeSemanaNaoPermitidoException(FimDeSemanaNaoPermitidoException ex) {
		ApiError apiError = new ApiError();
		apiError.setDataHora(LocalDateTime.now());
		apiError.setMensagem(ex.getMessage());

		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(apiError);
	}

	@ExceptionHandler(HorarioDeAlmocoObrigatorioException.class)
	public ResponseEntity<?> handleHorarioDeAlmocoObrigatorioException(HorarioDeAlmocoObrigatorioException ex) {
		ApiError apiError = new ApiError();
		apiError.setDataHora(LocalDateTime.now());
		apiError.setMensagem(ex.getMessage());

		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(apiError);
	}

	@ExceptionHandler(HorarioJaRegistradoException.class)
	public ResponseEntity<?> handleHorarioJaRegistradoException(HorarioJaRegistradoException ex) {
		ApiError apiError = new ApiError();
		apiError.setDataHora(LocalDateTime.now());
		apiError.setMensagem(ex.getMessage());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(apiError);
	}

	@ExceptionHandler(LimiteDeRegistrosPorDiaExcedidoException.class)
	public ResponseEntity<?> handleLimiteDeRegistrosPorDiaExcedidoException(LimiteDeRegistrosPorDiaExcedidoException ex) {
		ApiError apiError = new ApiError();
		apiError.setDataHora(LocalDateTime.now());
		apiError.setMensagem(ex.getMessage());

		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(apiError);
	}
}