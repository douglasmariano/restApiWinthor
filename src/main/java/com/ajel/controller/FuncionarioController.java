package com.ajel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajel.model.Cliente;
import com.ajel.model.Funcionario;
import com.ajel.repository.FuncionarioRepository;
import com.ajel.repository.TransportadoraRepository;
import com.ajel.repository.filter.FuncionarioFilter;
import com.ajel.repository.filter.TransportadoraFilter;


@RestController
@RequestMapping("/api/v1")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository repository;   
    
    @GetMapping("/funcionarios")
    public List<Funcionario> getAllFuncionarios() {
        return repository.findAll();
    }

    @GetMapping("/funcionario/{codsetor}")
    public List<Funcionario> getFuncionarios(FuncionarioFilter funcionarioFilter) {      
        return repository.pesquisar(funcionarioFilter);
    }
}
