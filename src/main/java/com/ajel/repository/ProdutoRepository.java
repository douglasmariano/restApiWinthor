package com.ajel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajel.controller.payloads.ProdutoEstoquePayload;
import com.ajel.model.Produto;
import com.ajel.repository.filter.ProdutoFilter;
import com.ajel.repository.produto.ProdutoRepositoryQuery;

public interface ProdutoRepository extends JpaRepository<Produto, Long>, ProdutoRepositoryQuery{

    List<Produto> pesquisar( ProdutoFilter produtoFilter);

    ProdutoEstoquePayload save(ProdutoEstoquePayload produto);  
}
