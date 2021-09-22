package com.ajel.repository.ajelentrega;

import java.util.List;

import com.ajel.model.AjelEntrega;
import com.ajel.repository.filter.AjelEntregaFilter;

public interface AjelEntregaRepositoryQuery {
    public List<AjelEntrega> pesquisar( AjelEntregaFilter ajelEntregarFilter);

}
