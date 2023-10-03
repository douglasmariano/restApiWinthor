package com.ajel.repository.ajeltransporte;

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

import com.ajel.model.Transporte;
import com.ajel.repository.filter.AjelTransporteFilter;

public class AjelTransporteRepositoryImpl implements AjelTransporteRepositoryQuery{

        @PersistenceContext
        private EntityManager manager;
        
       
        
        @Override
        public List<Transporte> pesquisar(AjelTransporteFilter ajelTransporteFilter) {
            
            CriteriaBuilder builder = manager.getCriteriaBuilder();
            CriteriaQuery<Transporte> criteria = builder.createQuery(Transporte.class);       
            Root<Transporte> root = criteria.from(Transporte.class);
            criteria.select(root);                       
            //criteria.orderBy(builder.asc(root.get("dtsaida"))); 
            
                    
            Predicate[] predicates = criarRestricoes(ajelTransporteFilter, builder, root);
             
            criteria.where(predicates) ;
            
            TypedQuery<Transporte> query = manager.createQuery(criteria);
            return query.getResultList();
        }   


        private Predicate[] criarRestricoes(AjelTransporteFilter ajelTransporteFilter, CriteriaBuilder builder,
                Root<Transporte> root) {
            
            LocalDate today = LocalDate.now( ZoneId.systemDefault() );
            Date date = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
            
            List<Predicate> predicates = new ArrayList<>();
            
            //predicates.add(builder.isNull(root.get("dtcancelado")));            
        
            
            if (ajelTransporteFilter.getCodtransporte() != null){
                predicates.add(builder.equal(root.get("codtransporte"), ajelTransporteFilter.getCodtransporte()));                
            }
            
            /*
             * if (ajelTransporteFilter.getDtsaida() != null){
             * // predicates.add(builder.equal(root.get("dtsaida"), ajelEntregaFilter.getDtentrega()));
             * predicates.add(builder.equal(builder.function("TRUNC", Date.class,
             * root.get("dtsaida")),ajelTransporteFilter.getDtsaida()));
             * }else if(ajelTransporteFilter.getNumnota() == null) {
             * predicates.add(builder.equal(builder.function("TRUNC", Date.class, root.get("dtsaida")), date));
             * System.out.println(date);
             * }
             */
             
            return predicates.toArray(new Predicate[predicates.size()]) ;        
        }
       

    }



