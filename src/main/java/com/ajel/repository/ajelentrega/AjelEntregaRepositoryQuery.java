package com.ajel.repository.ajelentrega;

import java.util.List;

import com.ajel.model.Entrega;
import com.ajel.repository.filter.AjelEntregaFilter;

public interface AjelEntregaRepositoryQuery {
    public List<Entrega> pesquisar( AjelEntregaFilter ajelEntregarFilter);

}
