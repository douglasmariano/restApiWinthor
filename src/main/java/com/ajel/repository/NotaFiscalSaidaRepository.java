package com.ajel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajel.model.NotaFiscalSaida;
import com.ajel.repository.filter.NotaFiscalSaidaFilter;
import com.ajel.repository.notafiscalsaida.NotaFiscalSaidaRepositoryQuery;

public interface NotaFiscalSaidaRepository extends JpaRepository<NotaFiscalSaida, Long>, NotaFiscalSaidaRepositoryQuery{

    List<NotaFiscalSaida> pesquisar( NotaFiscalSaidaFilter notaFiscalSaidaFilter);  
}
