package com.ajel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajel.model.MotivoBloqueio;

public interface MotivoBloqueioRepository extends JpaRepository<MotivoBloqueio, Long> {
    
    List<MotivoBloqueio> findAll();

}
