package com.ajel.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajel.model.AjelEntrega;
import com.ajel.repository.ajelentrega.AjelEntregaRepositoryQuery;
import com.ajel.repository.filter.AjelEntregaFilter;

public interface AjelEntregaRepository extends JpaRepository<AjelEntrega, Long>, AjelEntregaRepositoryQuery{

    List<AjelEntrega> pesquisar(AjelEntregaFilter ajelEntregaFilter);   
    List<AjelEntrega> findByNumnota(Long numnota);       

}
