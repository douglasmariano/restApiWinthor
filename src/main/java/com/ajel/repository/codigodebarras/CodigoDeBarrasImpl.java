package com.ajel.repository.codigodebarras;

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

import com.ajel.model.CodigoDeBarras;
import com.ajel.repository.filter.CodigoDeBarrasFilter;


public class CodigoDeBarrasImpl implements CodigoDeBarrasQuery{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<CodigoDeBarras> findByIdCodprod(CodigoDeBarrasFilter filter) {
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<CodigoDeBarras> criteria = builder.createQuery(CodigoDeBarras.class);		
		Root<CodigoDeBarras> root = criteria.from(CodigoDeBarras.class);
		criteria.select(root);
		criteria.orderBy(builder.asc(root.get("codprod")));
		
				
		Predicate[] predicates = criarRestricoes(filter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<CodigoDeBarras> query = manager.createQuery(criteria);
		return query.getResultList();
	}	


	private Predicate[] criarRestricoes(CodigoDeBarrasFilter filter, CriteriaBuilder builder,
			Root<CodigoDeBarras> root) {
		
		List<Predicate> predicates = new ArrayList<>();		
		if(!StringUtils.isEmpty(filter.getCodbarra())) {
            predicates.add(builder.like(
                    builder.lower(root.get("codbarra")), "%%"));
        }
		
        return predicates.toArray(new Predicate[predicates.size()]);		
	}

}
