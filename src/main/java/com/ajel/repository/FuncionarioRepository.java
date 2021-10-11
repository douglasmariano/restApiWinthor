package com.ajel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajel.model.EstoquePK;
import com.ajel.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{   

}
