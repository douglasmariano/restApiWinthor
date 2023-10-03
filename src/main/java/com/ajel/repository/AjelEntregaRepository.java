package com.ajel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajel.model.Entrega;
import com.ajel.repository.ajelentrega.AjelEntregaRepositoryQuery;
import com.ajel.repository.filter.AjelEntregaFilter;

public interface AjelEntregaRepository extends JpaRepository<Entrega, Long>, AjelEntregaRepositoryQuery{

    List<Entrega> pesquisar(AjelEntregaFilter ajelEntregaFilter);   
    List<Entrega> findByNumnota(Long numnota);       

}
