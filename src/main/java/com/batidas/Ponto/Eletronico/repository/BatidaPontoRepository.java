package com.batidas.Ponto.Eletronico.repository;

import com.batidas.Ponto.Eletronico.entity.BatidaPonto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface BatidaPontoRepository  extends JpaRepository<BatidaPonto, Long> {
//
//    @Query("SELECT bp FROM BatidaPonto bp WHERE day(bp.data) = day(?1) and month(bp.data) = month(?1) and year(bp.data) = year(?1) ORDER BY bp.data ASC")
//    List<BatidaPonto> findByData(LocalDate data);
//
//    Optional<BatidaPonto> findOneByData(LocalDateTime data);

    @Query("SELECT m FROM BatidaPonto m WHERE day(m.dataHora) = day(?1) and month(m.dataHora) = month(?1) and year(m.dataHora) = year(?1) ORDER BY m.dataHora ASC")
    List<BatidaPonto> findByData(LocalDate dataHora);

    Optional<BatidaPonto> findOneByDataHora(LocalDateTime dataHora);
}
