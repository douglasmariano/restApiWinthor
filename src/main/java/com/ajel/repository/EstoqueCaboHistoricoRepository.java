package com.ajel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajel.model.EstoqueCaboHistorico;
import com.ajel.repository.estoquecabohistorico.EstoqueCaboHistoricoRepositoryQuery;
import com.ajel.repository.filter.EstoqueCaboHistoricoFilter;

public interface EstoqueCaboHistoricoRepository extends JpaRepository<EstoqueCaboHistorico, Long>, EstoqueCaboHistoricoRepositoryQuery{

    List<EstoqueCaboHistorico> pesquisarHistorico(EstoqueCaboHistoricoFilter estoqueCaboHistoricoFilter);   

}
