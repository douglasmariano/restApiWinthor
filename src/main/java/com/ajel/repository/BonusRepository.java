package com.ajel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajel.model.Bonus;
import com.ajel.repository.bonus.BonusRepositoryQuery;
import com.ajel.repository.filter.BonusFilter;

public interface BonusRepository extends JpaRepository<Bonus, Long>, BonusRepositoryQuery{

    List<Bonus> pesquisar( BonusFilter bonusFilter);  
}
