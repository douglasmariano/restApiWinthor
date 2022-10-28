package com.ajel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajel.model.BonusItens;
import com.ajel.model.BonusItensPk;

public interface BonusItensRepository extends JpaRepository<BonusItens, BonusItensPk> {

    List<BonusItens> findByIdNumbonus(Long numbonus);

    List<BonusItens> findByIdCodprod(Long codprod);

    List<BonusItens> findByIdNumlote(String numlote);

}
