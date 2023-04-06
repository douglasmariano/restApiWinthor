package com.ajel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajel.model.MotivoBloqueio;
import com.ajel.repository.MotivoBloqueioRepository;


@RestController
@RequestMapping("/api/v1")
public class MotivoBloqueioController {

    @Autowired
    private MotivoBloqueioRepository repository;    

    @GetMapping("/motivobloqueio")
    public List<MotivoBloqueio> getProduto() {      
        return repository.findAll();
    
    }
}
