package com.ajel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajel.model.CodigoDeBarras;
import com.ajel.model.CodigoDeBarrasPK;

public interface CodigoDeBarrasRepository extends JpaRepository<CodigoDeBarras, CodigoDeBarrasPK>{

    List<CodigoDeBarras> findByIdCodprod(Long filter);

    List<CodigoDeBarras> findByIdCodbarra(String codbarra);   
    
}
