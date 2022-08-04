package com.batidas.Ponto.Eletronico.service;

import com.batidas.Ponto.Eletronico.entity.BatidaPonto;
import com.batidas.Ponto.Eletronico.repository.BatidaPontoRepository;
import com.batidas.Ponto.Eletronico.util.BatidaPontoValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BatidaPontoService {

    @Autowired
    private BatidaPontoRepository batidaPontoRepository;
    @Autowired
    private BatidaPontoValidation batidaPontoValidation;

    public BatidaPonto baterPonto(BatidaPonto batidaPonto)  {
            batidaPontoValidation.validaMomento(batidaPonto);

            return batidaPontoRepository.save(batidaPonto);
    }

}
