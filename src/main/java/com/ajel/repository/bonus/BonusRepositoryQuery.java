package com.ajel.repository.bonus;

import java.util.List;

import com.ajel.model.Bonus;
import com.ajel.repository.filter.BonusFilter;

public interface BonusRepositoryQuery {
	
	public List<Bonus> pesquisar( BonusFilter bonusFilter);

}
