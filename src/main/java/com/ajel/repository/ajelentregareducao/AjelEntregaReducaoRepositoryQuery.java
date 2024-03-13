package com.ajel.repository.ajelentregareducao;

import java.util.List;

import com.ajel.model.EntregaReducao;
import com.ajel.repository.filter.AjelEntregaReducaoFilter;

public interface AjelEntregaReducaoRepositoryQuery {
	
	public List<EntregaReducao> pesquisar( AjelEntregaReducaoFilter filter);

}
