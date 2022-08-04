package com.batidas.Ponto.Eletronico.util;

import com.batidas.Ponto.Eletronico.entity.BatidaPonto;
import com.batidas.Ponto.Eletronico.exception.*;
import com.batidas.Ponto.Eletronico.repository.BatidaPontoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class BatidaPontoValidation {


    @Autowired
    private BatidaPontoRepository batidaPontoRepository;

    public void validaMomento(BatidaPonto batidaPonto)  {
        verificaDataVazia(batidaPonto.getDataHora());
        isDateValid(batidaPonto.getDataHora());
        verificaData(batidaPonto.getDataHora());
        verificaRegistroPonto(batidaPonto.getDataHora());
        horarioJaRegistrado(batidaPonto.getDataHora());
    }
    private void verificaDataVazia(LocalDateTime dataHora)  {
        if (dataHora == null) {
            throw new HorarioVazioNaoPermitidoException();
        }
    }

    private  static boolean isDateValid(LocalDateTime dataHora)  {
        String dateFormat = "dd/MM/uuuu";

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter
                .ofPattern(dateFormat)
                .withResolverStyle(ResolverStyle.STRICT);
        try {
            LocalDate date = LocalDate.parse(dataHora.toString(), dateTimeFormatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
    private void verificaData(LocalDateTime dataHora)  {

        if (dataHora.getDayOfWeek().equals(DayOfWeek.SATURDAY) || dataHora.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            throw new FimDeSemanaNaoPermitidoException();
        }
    }

    private void verificaRegistroPonto(LocalDateTime dataHora)  {
        List<BatidaPonto> batidaPontos = batidaPontoRepository.findByData(dataHora.toLocalDate());

        if (batidaPontos.size() == 4) {
            throw new LimiteDeRegistrosPorDiaExcedidoException();
        }

        if (batidaPontos.size() == 2) {
            BatidaPonto ultimoRegistro = batidaPontos.get(1);

            Duration periodo = Duration.between(ultimoRegistro.getDataHora(), dataHora);

            if (periodo.toHours() < 1) {
                throw new HorarioDeAlmocoObrigatorioException();
            }
        }
    }

    private void horarioJaRegistrado(LocalDateTime dataHora)  {
        Optional<BatidaPonto> momento = batidaPontoRepository.findOneByDataHora(dataHora);

        if (momento.isPresent()) {
            throw new HorarioJaRegistradoException();
        }
    }
}
