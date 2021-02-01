package com.ajel.repository.tabpedido;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.ajel.model.TabPedido;
import com.ajel.repository.filter.TabPedidosFilter;

public class TabPedidoRepositoryImpl implements TabPedidoRepositoryQuery{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<TabPedido> filtrar(TabPedidosFilter tabPedidosFilter) {
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<TabPedido> criteria = builder.createQuery(TabPedido.class);
		Root<TabPedido> root = criteria.from(TabPedido.class);
		
		
		
		Predicate[] predicates = criarRestricoes(tabPedidosFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<TabPedido> query = manager.createQuery(criteria);
		return query.getResultList();
	}	


	private Predicate[] criarRestricoes(TabPedidosFilter tabPedidosFilter, CriteriaBuilder builder,
			Root<TabPedido> root) {
		
		List<Predicate> predicates = new ArrayList<>();

		if (tabPedidosFilter.getNumped() != null){
			predicates.add(builder.like(
					builder.lower(root.get("NUMPED")), "%"+ tabPedidosFilter.getNumped() +"%"));
			
		}
		
		if (tabPedidosFilter.getDataPedidoDe() != null){
					predicates.add(
							builder.greaterThanOrEqualTo(root.get("DATAPEDIDO"), tabPedidosFilter.getDataPedidoDe()));
				}
		
		if (tabPedidosFilter.getDataPedidoAte() != null){
			predicates.add(
					builder.lessThanOrEqualTo(root.get("DATAPEDIDO"), tabPedidosFilter.getDataPedidoAte()));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
