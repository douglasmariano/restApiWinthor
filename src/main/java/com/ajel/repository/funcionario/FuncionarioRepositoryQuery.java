package com.ajel.repository.funcionario;

import java.util.List;

import com.ajel.model.Funcionario;
import com.ajel.repository.filter.FuncionarioFilter;

public interface FuncionarioRepositoryQuery {
    public List<Funcionario> pesquisar( FuncionarioFilter funcionarioFilter);

}
