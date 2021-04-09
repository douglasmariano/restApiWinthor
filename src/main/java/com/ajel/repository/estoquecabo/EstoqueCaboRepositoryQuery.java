package com.ajel.repository.estoquecabo;

import java.util.List;

import com.ajel.model.EstoqueCabo;
import com.ajel.repository.filter.EstoqueCaboFilter;

public interface EstoqueCaboRepositoryQuery {
    public List<EstoqueCabo> filtrar( EstoqueCaboFilter estoqueCaboFilter);

}
