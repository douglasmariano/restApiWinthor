package com.ajel.repository.ajelentrega;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.ajel.model.AjelEntrega;
import com.ajel.repository.filter.AjelEntregaFilter;

public class AjelEntregaRepositoryImpl implements AjelEntregaRepositoryQuery{

        @PersistenceContext
        private EntityManager manager;
        
        @Override
        public List<AjelEntrega> pesquisar(AjelEntregaFilter ajelEntregaFilter) {
            
            CriteriaBuilder builder = manager.getCriteriaBuilder();
            CriteriaQuery<AjelEntrega> criteria = builder.createQuery(AjelEntrega.class);       
            Root<AjelEntrega> root = criteria.from(AjelEntrega.class);
            criteria.select(root);
            //criteria.orderBy(builder.asc(root.get("rua")), builder.asc(root.get("modulo")), builder.asc(root.get("apto")));
            
                    
            Predicate[] predicates = criarRestricoes(ajelEntregaFilter, builder, root);
            criteria.where(predicates);
            
            TypedQuery<AjelEntrega> query = manager.createQuery(criteria);
            return query.getResultList();
        }   


        private Predicate[] criarRestricoes(AjelEntregaFilter ajelEntregaFilter, CriteriaBuilder builder,
                Root<AjelEntrega> root) {
            
            List<Predicate> predicates = new ArrayList<>();     
            if (ajelEntregaFilter.getNumnota() != null){
                predicates.add(builder.equal(root.get("numnota"), ajelEntregaFilter.getNumnota()));            
            }
                       
            return predicates.toArray(new Predicate[predicates.size()]);        
        }
       

    }



