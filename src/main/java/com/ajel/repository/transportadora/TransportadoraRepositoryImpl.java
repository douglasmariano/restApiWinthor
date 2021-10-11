package com.ajel.repository.transportadora;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.ajel.model.Transportadora;
import com.ajel.repository.filter.TransportadoraFilter;

public class TransportadoraRepositoryImpl implements TransportadoraRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Transportadora> pesquisar(TransportadoraFilter transportadoraFilter) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Transportadora> criteria = builder.createQuery(Transportadora.class);
        Root<Transportadora> root = criteria.from(Transportadora.class);
        criteria.select(root);
        //criteria.orderBy(builder.asc(root.get("rua")), builder.asc(root.get("modulo")), builder.asc(root.get("apto")));

        Predicate[] predicates = criarRestricoes(transportadoraFilter, builder, root);
        criteria.where(predicates);

        TypedQuery<Transportadora> query = manager.createQuery(criteria);
        return query.getResultList();
    }

    private Predicate[] criarRestricoes(TransportadoraFilter transportadoraFilter, CriteriaBuilder builder,
            Root<Transportadora> root) {

        List<Predicate> predicates = new ArrayList<>();
        if (transportadoraFilter.getRevenda() != null) {
            predicates.add(builder.equal(root.get("revenda"), transportadoraFilter.getRevenda()));
            predicates.add(builder.equal(root.get("bloqueio"), "N"));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }

}
