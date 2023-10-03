package com.ajel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajel.model.Transporte;
import com.ajel.repository.ajeltransporte.AjelTransporteRepositoryQuery;
import com.ajel.repository.filter.AjelTransporteFilter;

public interface AjelTransporteRepository extends JpaRepository<Transporte, Long>, AjelTransporteRepositoryQuery{

    List<Transporte> pesquisar(AjelTransporteFilter ajelTransporteFilter);   

}
