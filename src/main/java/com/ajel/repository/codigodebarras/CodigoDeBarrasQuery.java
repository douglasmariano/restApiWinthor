package com.ajel.repository.codigodebarras;

import java.util.List;

import com.ajel.model.CodigoDeBarras;
import com.ajel.repository.filter.CodigoDeBarrasFilter;

public interface CodigoDeBarrasQuery {
	
	public List<CodigoDeBarras> findByIdCodprod( CodigoDeBarrasFilter filter);

}
