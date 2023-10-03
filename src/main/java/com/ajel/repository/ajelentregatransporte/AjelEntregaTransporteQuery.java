package com.ajel.repository.ajelentregatransporte;

import java.util.List;

import com.ajel.model.EntregaTransporte;
import com.ajel.repository.filter.AjelEntregaTransporteFilter;

public interface AjelEntregaTransporteQuery {
	
	public List<EntregaTransporte> findByIdEntregaTransporte( AjelEntregaTransporteFilter filter);

}
