package com.ajel.repository.ajeltransporte;

import java.util.List;

import com.ajel.model.Transporte;
import com.ajel.repository.filter.AjelTransporteFilter;

public interface AjelTransporteRepositoryQuery {
    public List<Transporte> pesquisar( AjelTransporteFilter ajelTransporteFilter);

}
