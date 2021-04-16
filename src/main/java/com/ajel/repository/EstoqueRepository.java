package com.ajel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajel.model.Estoque;
import com.ajel.model.EstoquePK;

public interface EstoqueRepository extends JpaRepository<Estoque, EstoquePK>{   

}
