package com.ajel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajel.model.EntregaTransporte;
import com.ajel.model.EntregaTransportePK;

public interface AjelEntregaTransporteRepository extends JpaRepository<EntregaTransporte, EntregaTransportePK>{

    List<EntregaTransporte> findByIdCodentrega(Long codentrega);

    List<EntregaTransporte> findByIdCodtransporte(Long codtransporte);   
    
}
