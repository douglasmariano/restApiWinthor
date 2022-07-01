package com.ajel.repository.notafiscalsaida;

import java.util.List;

import com.ajel.model.NotaFiscalSaida;
import com.ajel.repository.filter.NotaFiscalSaidaFilter;

public interface NotaFiscalSaidaRepositoryQuery {
	
	public List<NotaFiscalSaida> pesquisar( NotaFiscalSaidaFilter notaFiscalSaidaFilter);

}
