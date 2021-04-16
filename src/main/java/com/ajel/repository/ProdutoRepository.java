package com.ajel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajel.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{   

}
