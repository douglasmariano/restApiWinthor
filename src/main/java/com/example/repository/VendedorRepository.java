package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

}
