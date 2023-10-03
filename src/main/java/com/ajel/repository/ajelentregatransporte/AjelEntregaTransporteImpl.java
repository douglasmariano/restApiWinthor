package com.ajel.repository.ajelentregatransporte;

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

import com.ajel.model.EntregaTransporte;
import com.ajel.repository.filter.AjelEntregaTransporteFilter;


public class AjelEntregaTransporteImpl implements AjelEntregaTransporteQuery{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<EntregaTransporte> findByIdEntregaTransporte(AjelEntregaTransporteFilter filter) {
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<EntregaTransporte> criteria = builder.createQuery(EntregaTransporte.class);		
		Root<EntregaTransporte> root = criteria.from(EntregaTransporte.class);
		criteria.select(root);
		criteria.orderBy(builder.asc(root.get("codtransporte")));
		
				
		Predicate[] predicates = criarRestricoes(filter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<EntregaTransporte> query = manager.createQuery(criteria);
		return query.getResultList();
	}	


	private Predicate[] criarRestricoes(AjelEntregaTransporteFilter filter, CriteriaBuilder builder,
			Root<EntregaTransporte> root) {
		
		List<Predicate> predicates = new ArrayList<>();		
		if(!StringUtils.isEmpty(filter.getCodentrega())) {
            predicates.add(builder.like(
                    builder.lower(root.get("codentrega")), "%%"));
        }
		
        return predicates.toArray(new Predicate[predicates.size()]);		
	}

   

}
