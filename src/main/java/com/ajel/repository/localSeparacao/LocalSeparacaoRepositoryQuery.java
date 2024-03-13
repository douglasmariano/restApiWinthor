package com.ajel.repository.localSeparacao;

import java.util.List;

import com.ajel.model.LocalSeparacao;
import com.ajel.repository.filter.LocalSeparacaoFilter;

public interface LocalSeparacaoRepositoryQuery {
    public List<LocalSeparacao> pesquisar( LocalSeparacaoFilter locaolSeparacaoFilter);

   

}
