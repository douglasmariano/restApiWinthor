package com.ajel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajel.model.EstoqueCabo;
import com.ajel.repository.estoquecabo.EstoqueCaboRepositoryQuery;
import com.ajel.repository.filter.EstoqueCaboFilter;

public interface EstoqueCaboRepository extends JpaRepository<EstoqueCabo, Long>, EstoqueCaboRepositoryQuery{

    List<EstoqueCabo> pesquisar(EstoqueCaboFilter estoqueCaboFilter);   

}
