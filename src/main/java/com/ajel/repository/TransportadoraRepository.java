package com.ajel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajel.model.Transportadora;
import com.ajel.repository.filter.TransportadoraFilter;
import com.ajel.repository.transportadora.TransportadoraRepositoryQuery;

public interface TransportadoraRepository extends JpaRepository<Transportadora, Long>, TransportadoraRepositoryQuery{

    List<Transportadora> pesquisar(TransportadoraFilter transportadoraFilter);   

}
