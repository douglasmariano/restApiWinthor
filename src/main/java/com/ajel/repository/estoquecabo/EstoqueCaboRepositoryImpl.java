package com.ajel.repository.estoquecabo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.ajel.model.EstoqueCabo;
import com.ajel.repository.filter.EstoqueCaboFilter;

public class EstoqueCaboRepositoryImpl implements EstoqueCaboRepositoryQuery{

        @PersistenceContext
        private EntityManager manager;
        
        @Override
        public List<EstoqueCabo> pesquisar(EstoqueCaboFilter estoqueCaboFilter) {
            
            CriteriaBuilder builder = manager.getCriteriaBuilder();
            CriteriaQuery<EstoqueCabo> criteria = builder.createQuery(EstoqueCabo.class);       
            Root<EstoqueCabo> root = criteria.from(EstoqueCabo.class);
            criteria.select(root);
            criteria.orderBy(builder.asc(root.get("rua")), builder.asc(root.get("modulo")), builder.asc(root.get("apto")));
            
                    
            Predicate[] predicates = criarRestricoes(estoqueCaboFilter, builder, root);
            criteria.where(predicates);
            
            TypedQuery<EstoqueCabo> query = manager.createQuery(criteria);
            return query.getResultList();
        }   


        private Predicate[] criarRestricoes(EstoqueCaboFilter estoqueCaboFilter, CriteriaBuilder builder,
                Root<EstoqueCabo> root) {
            
            List<Predicate> predicates = new ArrayList<>();     
            predicates.add(builder.isNull(root.get("dtexclusao")));                          
            if (estoqueCaboFilter.getCodprod_pcprodut() != null){
                predicates.add(builder.equal(root.get("codprod_pcprodut"), estoqueCaboFilter.getCodprod_pcprodut()));            
            }
                       
            return predicates.toArray(new Predicate[predicates.size()]);        
        }
       

    }



