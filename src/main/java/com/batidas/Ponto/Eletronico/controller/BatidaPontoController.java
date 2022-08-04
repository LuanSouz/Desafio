package com.batidas.Ponto.Eletronico.controller;


import com.batidas.Ponto.Eletronico.entity.BatidaPonto;
import com.batidas.Ponto.Eletronico.service.BatidaPontoService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/batidas")
public class BatidaPontoController {

    @Autowired
    private BatidaPontoService batidaPontoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BatidaPonto baterPonto(@RequestBody BatidaPonto batidaPonto) {
        return batidaPontoService.baterPonto(batidaPonto);
    }
}
