package com.ajel.repository.estoquecabohistorico;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.ajel.model.EstoqueCaboHistorico;
import com.ajel.repository.filter.EstoqueCaboHistoricoFilter;


public class EstoqueCaboHistoricoRepositoryImpl implements EstoqueCaboHistoricoRepositoryQuery{

        @PersistenceContext
        private EntityManager manager;
        
        @Override
        public List<EstoqueCaboHistorico> pesquisarHistorico(EstoqueCaboHistoricoFilter estoqueCaboFilter) {
            
            CriteriaBuilder builder = manager.getCriteriaBuilder();
            CriteriaQuery<EstoqueCaboHistorico> criteria = builder.createQuery(EstoqueCaboHistorico.class);       
            Root<EstoqueCaboHistorico> root = criteria.from(EstoqueCaboHistorico.class);
            criteria.select(root);
            
                    
            Predicate[] predicates = criarRestricoes(estoqueCaboFilter, builder, root);
            criteria.where(predicates);
            
            TypedQuery<EstoqueCaboHistorico> query = manager.createQuery(criteria);
            return query.getResultList();
        }   


        private Predicate[] criarRestricoes(EstoqueCaboHistoricoFilter estoqueCaboFilter, CriteriaBuilder builder,
                Root<EstoqueCaboHistorico> root) {
            
            List<Predicate> predicates = new ArrayList<>();     
            if (estoqueCaboFilter.getCodprod_pcprodut() != null){
                predicates.add(builder.equal(root.get("codprod_pcprodut"), estoqueCaboFilter.getCodprod_pcprodut()));            
            }
                       
            return predicates.toArray(new Predicate[predicates.size()]);        
        }
     

    }



