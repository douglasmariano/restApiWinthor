package com.ajel.repository.notafiscalentrada;

import java.util.List;

import com.ajel.model.NotaFiscalEntrada;
import com.ajel.repository.filter.NotaFiscalEntradaFilter;

public interface NotaFiscalEntradaRepositoryQuery {
	
	public List<NotaFiscalEntrada> pesquisar( NotaFiscalEntradaFilter notaFiscalEntradaFilter);

}
