package com.ajel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajel.model.NotaFiscalEntrada;
import com.ajel.repository.filter.NotaFiscalEntradaFilter;
import com.ajel.repository.notafiscalentrada.NotaFiscalEntradaRepositoryQuery;

public interface NotaFiscalEntradaRepository extends JpaRepository<NotaFiscalEntrada, Long>, NotaFiscalEntradaRepositoryQuery{

    List<NotaFiscalEntrada> pesquisar( NotaFiscalEntradaFilter notaFiscalEntradaFilter);  
}
