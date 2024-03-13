package com.ajel.repository.ajelentregareducao;

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

import com.ajel.model.EntregaReducao;
import com.ajel.repository.filter.AjelEntregaReducaoFilter;


public class AjelEntregaReducaoRepositoryImpl implements AjelEntregaReducaoRepositoryQuery{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<EntregaReducao> pesquisar(AjelEntregaReducaoFilter filter) {
	    
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<EntregaReducao> criteria = builder.createQuery(EntregaReducao.class);		
		Root<EntregaReducao> root = criteria.from(EntregaReducao.class);
		criteria.select(root)
	     .where(builder.equal(root.get("id").get("codentrega"), filter.getCodentrega()),
	             builder.equal(root.get("id").get("numnota"), filter.getNumnota()));
		criteria.orderBy(builder.asc(root.get("id").get("codentrega")));
		
				
		Predicate[] predicates = criarRestricoes(filter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<EntregaReducao> query = manager.createQuery(criteria);
		return query.getResultList();
	}	


    private Predicate[] criarRestricoes(AjelEntregaReducaoFilter filter, CriteriaBuilder builder,
            Root<EntregaReducao> root) {

        List<Predicate> predicates = new ArrayList<>();
        if (filter.getCodentrega() != null) {
            predicates.add(builder.equal(root.get("id").get("codentrega"), filter.getCodentrega()));
        }
        predicates.add(builder.isNull(root.get("dtexcluido")));
        return predicates.toArray(new Predicate[predicates.size()]);
    }

   

}
