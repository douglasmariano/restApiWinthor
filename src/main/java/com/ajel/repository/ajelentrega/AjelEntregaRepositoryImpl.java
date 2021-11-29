package com.ajel.repository.ajelentrega;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
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
            criteria.orderBy(builder.asc(root.get("dtinclusao"))); 
            
                    
            Predicate[] predicates = criarRestricoes(ajelEntregaFilter, builder, root);
             
            criteria.where(predicates) ;
            
            TypedQuery<AjelEntrega> query = manager.createQuery(criteria);
            return query.getResultList();
        }   


        private Predicate[] criarRestricoes(AjelEntregaFilter ajelEntregaFilter, CriteriaBuilder builder,
                Root<AjelEntrega> root) {
            
            LocalDate today = LocalDate.now( ZoneId.systemDefault() );
            Date date = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
            
            List<Predicate> predicates = new ArrayList<>();
            
            predicates.add(builder.isNull(root.get("dtexclusao")));
            
            if (ajelEntregaFilter.getNumnota() != null){
                predicates.add(builder.equal(root.get("numnota"), ajelEntregaFilter.getNumnota()));            
            } 
            
            if (ajelEntregaFilter.getCodentrega() != null){
                predicates.add(builder.equal(root.get("codentrega"), ajelEntregaFilter.getCodentrega()));                
            }
            
            if (ajelEntregaFilter.getDtentrega() != null){
               // predicates.add(builder.equal(root.get("dtentrega"), ajelEntregaFilter.getDtentrega()));
                predicates.add(builder.equal(builder.function("TRUNC", Date.class, root.get("dtentrega")),ajelEntregaFilter.getDtentrega()));               
            }else if(ajelEntregaFilter.getNumnota() == null) {
                predicates.add(builder.equal(builder.function("TRUNC", Date.class, root.get("dtentrega")), date)); 
                System.out.println(date);
            }
             
            return predicates.toArray(new Predicate[predicates.size()]) ;        
        }
       

    }



