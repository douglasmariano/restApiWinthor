package com.ajel.repository.estoquecabohistorico;

import java.util.List;

import com.ajel.model.EstoqueCaboHistorico;
import com.ajel.repository.filter.EstoqueCaboHistoricoFilter;

public interface EstoqueCaboHistoricoRepositoryQuery {
    public List<EstoqueCaboHistorico> pesquisarHistorico( EstoqueCaboHistoricoFilter estoqueCaboHistoricoFilter);


}
