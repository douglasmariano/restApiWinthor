package com.ajel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajel.model.Marca;
import com.ajel.repository.MarcaRepository;
import com.ajel.repository.filter.NotaFiscalSaidaFilter;


@RestController
@RequestMapping("/api/v1")
public class MarcaController {

    @Autowired
    private MarcaRepository repository;    

    @GetMapping("/marca")
    public List<Marca> getProduto(NotaFiscalSaidaFilter notaFiscalSaidaFilter) {      
        return repository.findAll();
    }
}
