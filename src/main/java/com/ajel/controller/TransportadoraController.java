package com.ajel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajel.model.Transportadora;
import com.ajel.repository.TransportadoraRepository;
import com.ajel.repository.filter.TransportadoraFilter;


@RestController
@RequestMapping("/api/v1")
public class TransportadoraController {

    @Autowired
    private TransportadoraRepository repository;    

    @GetMapping("/transportadora/{revenda}")
    public List<Transportadora> getTransportadora(TransportadoraFilter transportadoraFilter) {      
        return repository.pesquisar(transportadoraFilter);
    }
}
