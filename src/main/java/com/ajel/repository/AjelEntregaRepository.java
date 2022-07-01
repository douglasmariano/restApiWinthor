package com.ajel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajel.model.AjelEntrega;
import com.ajel.repository.ajelentrega.AjelEntregaRepositoryQuery;
import com.ajel.repository.filter.AjelEntregaFilter;

public interface AjelEntregaRepository extends JpaRepository<AjelEntrega, Long>, AjelEntregaRepositoryQuery{

    List<AjelEntrega> pesquisar(AjelEntregaFilter ajelEntregaFilter);   
    List<AjelEntrega> findByNumnota(Long numnota);       

}
