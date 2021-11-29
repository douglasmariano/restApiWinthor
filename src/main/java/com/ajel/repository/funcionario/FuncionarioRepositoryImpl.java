package com.ajel.repository.funcionario;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.ajel.model.Funcionario;
import com.ajel.repository.filter.FuncionarioFilter;

public class FuncionarioRepositoryImpl implements FuncionarioRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Funcionario> pesquisar(FuncionarioFilter funcionarioFilter) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Funcionario> criteria = builder.createQuery(Funcionario.class);
        Root<Funcionario> root = criteria.from(Funcionario.class);
        criteria.select(root);
        //criteria.orderBy(builder.asc(root.get("rua")), builder.asc(root.get("modulo")), builder.asc(root.get("apto")));

        Predicate[] predicates = criarRestricoes(funcionarioFilter, builder, root);
        criteria.where(predicates);

        TypedQuery<Funcionario> query = manager.createQuery(criteria);
        return query.getResultList();
    }

    private Predicate[] criarRestricoes(FuncionarioFilter funcionarioFilter, CriteriaBuilder builder,
            Root<Funcionario> root) {

        List<Predicate> predicates = new ArrayList<>();
        if (funcionarioFilter.getCodsetor() != null) {
            predicates.add(builder.equal(root.get("codsetor"), funcionarioFilter.getCodsetor()));
            predicates.add(builder.equal(root.get("situacao"), "A"));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }

}
