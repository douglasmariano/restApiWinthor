package com.ajel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajel.model.Funcionario;
import com.ajel.repository.filter.FuncionarioFilter;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{  
    
    List<Funcionario> pesquisar(FuncionarioFilter funcionarioFilter);   

}
