package com.ajel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajel.model.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
    
    List<Marca> findAll();

}
