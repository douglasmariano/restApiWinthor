package com.ajel.repository.notafiscalentrada;

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

import com.ajel.model.NotaFiscalEntrada;
import com.ajel.repository.filter.NotaFiscalEntradaFilter;


public class NotaFiscalEntradaRepositoryImpl implements NotaFiscalEntradaRepositoryQuery{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<NotaFiscalEntrada> pesquisar(NotaFiscalEntradaFilter notaFiscalEntradaFilter) {
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<NotaFiscalEntrada> criteria = builder.createQuery(NotaFiscalEntrada.class);		
		Root<NotaFiscalEntrada> root = criteria.from(NotaFiscalEntrada.class);
		criteria.select(root);
		//criteria.orderBy(builder.asc(root.get("numnota")));
		
				
		Predicate[] predicates = criarRestricoes(notaFiscalEntradaFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<NotaFiscalEntrada> query = manager.createQuery(criteria);
		return query.getResultList();
	}	


	private Predicate[] criarRestricoes(NotaFiscalEntradaFilter notaFiscalEntradaFilter, CriteriaBuilder builder,
			Root<NotaFiscalEntrada> root) {
		
		List<Predicate> predicates = new ArrayList<>();	
		//predicates.add(builder.equal(root.get("codfilial"), notaFiscalEntradaFilter.getCodfilial()));
		if(!StringUtils.isEmpty(notaFiscalEntradaFilter.getNumbonus())) {
            predicates.add((builder.equal(root.get("numbonus"), notaFiscalEntradaFilter.getNumbonus())));
        }

				
        return predicates.toArray(new Predicate[predicates.size()]);		
	}

}
