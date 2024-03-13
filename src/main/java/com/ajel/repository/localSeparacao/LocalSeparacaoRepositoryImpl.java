package com.ajel.repository.localSeparacao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.ajel.model.LocalSeparacao;
import com.ajel.repository.filter.LocalSeparacaoFilter;

public class LocalSeparacaoRepositoryImpl implements LocalSeparacaoRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<LocalSeparacao> pesquisar(LocalSeparacaoFilter localSeparacaoFilter) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<LocalSeparacao> criteria = builder.createQuery(LocalSeparacao.class);
        Root<LocalSeparacao> root = criteria.from(LocalSeparacao.class);
        criteria.select(root);
        //criteria.orderBy(builder.asc(root.get("rua")), builder.asc(root.get("modulo")), builder.asc(root.get("apto")));

        Predicate[] predicates = criarRestricoes(localSeparacaoFilter, builder, root);
        criteria.where(predicates);

        TypedQuery<LocalSeparacao> query = manager.createQuery(criteria);
        return query.getResultList();
    }

    private Predicate[] criarRestricoes(LocalSeparacaoFilter localSeparacaoFilter, CriteriaBuilder builder,
            Root<LocalSeparacao> root) {

        List<Predicate> predicates = new ArrayList<>();
        if (localSeparacaoFilter.getNumped() != null) {
            predicates.add(builder.equal(root.get("numped"), localSeparacaoFilter.getNumped()));
        }
        
        if (localSeparacaoFilter.getLocalseparacao() != null) {
            predicates.add(builder.equal(root.get("localseparacao"), localSeparacaoFilter.getLocalseparacao()));
        }
       // predicates.add(builder.equal(root.get("situacao"), "A"));
        return predicates.toArray(new Predicate[predicates.size()]);
    }

}
