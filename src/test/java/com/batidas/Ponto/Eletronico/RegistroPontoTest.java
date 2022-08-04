package com.batidas.Ponto.Eletronico;

import com.batidas.Ponto.Eletronico.entity.BatidaPonto;
import com.batidas.Ponto.Eletronico.service.BatidaPontoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class RegistroPontoTest {

    @Autowired
    private BatidaPontoService batidaPontoService;

    @Test
    void testarRegistroPontoComSucesso() {
        // Cenério
        BatidaPonto batidaPonto = new BatidaPonto();
        batidaPonto.setDataHora(LocalDateTime.of(2021, 9, 13, 8, 00, 00));

        // Ação
        batidaPontoService.baterPonto(batidaPonto);

        // Verificação
        assertThrows(RuntimeException.class, () -> batidaPontoService.baterPonto(batidaPonto));
    }
}