package com.ajel.repository.notafiscalsaida;

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

import com.ajel.model.NotaFiscalSaida;
import com.ajel.repository.filter.NotaFiscalSaidaFilter;


public class NotaFiscalSaidaRepositoryImpl implements NotaFiscalSaidaRepositoryQuery{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<NotaFiscalSaida> pesquisar(NotaFiscalSaidaFilter notaFiscalSaidaFilter) {
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<NotaFiscalSaida> criteria = builder.createQuery(NotaFiscalSaida.class);		
		Root<NotaFiscalSaida> root = criteria.from(NotaFiscalSaida.class);
		criteria.select(root);
		criteria.orderBy(builder.asc(root.get("numnota")));
		
				
		Predicate[] predicates = criarRestricoes(notaFiscalSaidaFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<NotaFiscalSaida> query = manager.createQuery(criteria);
		return query.getResultList();
	}	


	private Predicate[] criarRestricoes(NotaFiscalSaidaFilter notaFiscalSaidaFilter, CriteriaBuilder builder,
			Root<NotaFiscalSaida> root) {
		
		List<Predicate> predicates = new ArrayList<>();	
		predicates.add(builder.equal(root.get("codfilial"), notaFiscalSaidaFilter.getCodfilial()));
		if(!StringUtils.isEmpty(notaFiscalSaidaFilter.getNumnotaInicial())) {
            predicates.add((builder.between(root.get("numnota"), notaFiscalSaidaFilter.getNumnotaInicial(), notaFiscalSaidaFilter.getNumnotaFinal())));
        }
				
        return predicates.toArray(new Predicate[predicates.size()]);		
	}

}
