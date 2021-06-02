package com.ajel.repository.produto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.util.StringUtils;

import com.ajel.model.Produto;
import com.ajel.repository.filter.ProdutoFilter;


public class ProdutoRepositoryImpl implements ProdutoRepositoryQuery{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Produto> pesquisar(ProdutoFilter produtoFilter) {
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Produto> criteria = builder.createQuery(Produto.class);		
		Root<Produto> root = criteria.from(Produto.class);
		criteria.select(root);
		criteria.orderBy(builder.asc(root.get("rua")), builder.asc(root.get("modulo")), builder.asc(root.get("apto")));
		
				
		Predicate[] predicates = criarRestricoes(produtoFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Produto> query = manager.createQuery(criteria);
		return query.getResultList();
	}	


	private Predicate[] criarRestricoes(ProdutoFilter produtoFilter, CriteriaBuilder builder,
			Root<Produto> root) {
		
		List<Predicate> predicates = new ArrayList<>();		
		if(!StringUtils.isEmpty(produtoFilter.getDescricao())) {
            predicates.add(builder.like(
                    builder.lower(root.get("descricao")), "%" + produtoFilter.getDescricao().toLowerCase() + "%"));
        }
		
		if(!StringUtils.isEmpty(produtoFilter.getMarcas())) {
		    predicates.add(root.get("codmarca").in(produtoFilter.getMarcas()));
        }
		
        return predicates.toArray(new Predicate[predicates.size()]);		
	}

}
