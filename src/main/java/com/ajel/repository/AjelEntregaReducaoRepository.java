package com.ajel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ajel.model.EntregaReducao;
import com.ajel.model.EntregaReducaoPK;
import com.ajel.repository.ajelentregareducao.AjelEntregaReducaoRepositoryQuery;
import com.ajel.repository.filter.AjelEntregaReducaoFilter;

public interface AjelEntregaReducaoRepository extends JpaRepository<EntregaReducao, EntregaReducaoPK>, AjelEntregaReducaoRepositoryQuery{
    
    List<EntregaReducao> pesquisar(AjelEntregaReducaoFilter ajelEntregaReducaoFilter);
    List<EntregaReducao> findByIdCodentrega(Long codentrega);
    List<EntregaReducao> findByIdNumnota(Long numnota);
    @Query("SELECT er FROM EntregaReducao er WHERE er.id.codentrega = :codentrega AND er.id.numnota = :numnota AND er.dtexcluido IS NULL")
    EntregaReducao findByIdCodentregaAndIdNumnotaAndDtExcluidoIsNull(@Param("codentrega") Long codentrega, @Param("numnota") Long numnota);    
    
}
