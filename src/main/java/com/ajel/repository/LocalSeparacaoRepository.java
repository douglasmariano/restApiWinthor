package com.ajel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajel.model.LocalSeparacao;
import com.ajel.repository.filter.LocalSeparacaoFilter;

public interface LocalSeparacaoRepository extends JpaRepository<LocalSeparacao, Long> {

    List<LocalSeparacao> pesquisar(LocalSeparacaoFilter localSeparacaoFilter);   
}
