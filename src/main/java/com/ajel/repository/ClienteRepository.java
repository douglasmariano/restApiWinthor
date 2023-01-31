package com.ajel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajel.model.Cliente;
import com.ajel.repository.filter.ClienteFilter;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
   
    List<Cliente> telcelent(ClienteFilter filtro);
}
