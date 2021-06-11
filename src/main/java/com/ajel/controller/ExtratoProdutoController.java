package com.ajel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajel.controller.payloads.ExtratoProdutoPayload;
import com.ajel.exception.ResourceNotFoundException;
import com.ajel.repository.filter.ExtratoProdutoFilter;
import com.ajel.services.ExtratoProdutoService;

//@CrossOrigin(origins = "http://192.168.200.55:4200")
@CrossOrigin(origins = "http://192.168.200.17:4200")
@RestController
@RequestMapping("/api/v1")
public class ExtratoProdutoController {
	
    @Autowired
    private ExtratoProdutoService extratoProdutoService;

    @PostMapping("/extratoproduto") //
    public ResponseEntity<List<ExtratoProdutoPayload>> getExtratoProduto(@RequestBody ExtratoProdutoFilter filter)
            throws ResourceNotFoundException {
        List<ExtratoProdutoPayload> extratoProduto = null;
        extratoProduto = extratoProdutoService.findByCodprodEFilial(filter);
        
        return ResponseEntity.ok().body(extratoProduto);
    }
		
	


}
