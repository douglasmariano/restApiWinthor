package com.ajel.repository.bonus;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.ajel.model.Bonus;
import com.ajel.repository.filter.BonusFilter;


public class BonusRepositoryImpl implements BonusRepositoryQuery{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Bonus> pesquisar(BonusFilter bonusFilter) {
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Bonus> criteria = builder.createQuery(Bonus.class);		
		Root<Bonus> root = criteria.from(Bonus.class);
		criteria.select(root);
		criteria.orderBy(builder.asc(root.get("codfilial")), builder.asc(root.get("numbonus")));
		
				
		Predicate[] predicates = criarRestricoes(bonusFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Bonus> query = manager.createQuery(criteria);
		return query.getResultList();
	}	


	private Predicate[] criarRestricoes(BonusFilter bonusFilter, CriteriaBuilder builder,
			Root<Bonus> root) {
		
		List<Predicate> predicates = new ArrayList<>();	
		Long numbonus = bonusFilter.getNumbonus();
        if(numbonus != null) {
            predicates.add(root.get("numbonus").in(numbonus));
		}if (bonusFilter.getDatabonus() != null){
            predicates.add(
                    builder.greaterThanOrEqualTo(root.get("databonus"), bonusFilter.getDatabonus()));
        }

        if (bonusFilter.getDtfechamento() != null){
            predicates.add(
                    builder.greaterThanOrEqualTo(root.get("dtfechamento"), bonusFilter.getDtfechamento()));
        }
//		if(!StringUtils.isEmpty(bonusFilter.getDescricao())) {
//            predicates.add(builder.like(
//                    builder.lower(root.get("descricao")), "%" + produtoFilter.getDescricao().toLowerCase() + "%"));
//        }
//		
//		if(!produtoFilter.getMarcas().isEmpty()) {
//		    predicates.add(root.get("codmarca").in(produtoFilter.getMarcas()));
//        }
//		
//		if(!StringUtils.isEmpty(produtoFilter.getCodfab())) {
//            predicates.add(builder.like(
//                    builder.lower(root.get("codfab")), "%" + produtoFilter.getCodfab().toLowerCase() + "%"));
//        }
//		
        return predicates.toArray(new Predicate[predicates.size()]);		
	}

}
