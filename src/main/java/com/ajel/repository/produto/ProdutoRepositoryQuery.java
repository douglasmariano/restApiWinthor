package com.ajel.repository.produto;

import java.util.List;

import com.ajel.model.Produto;
import com.ajel.repository.filter.ProdutoFilter;

public interface ProdutoRepositoryQuery {
	
	public List<Produto> pesquisar( ProdutoFilter produtoFilter);

}
