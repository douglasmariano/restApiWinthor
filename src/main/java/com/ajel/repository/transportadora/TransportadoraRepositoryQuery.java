package com.ajel.repository.transportadora;

import java.util.List;

import com.ajel.model.Transportadora;
import com.ajel.repository.filter.TransportadoraFilter;

public interface TransportadoraRepositoryQuery {
    public List<Transportadora> pesquisar( TransportadoraFilter transportadoraFilter);

}
