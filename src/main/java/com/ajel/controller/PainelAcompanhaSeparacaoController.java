package com.ajel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajel.controller.payloads.PainelAcompanhaSeparacaoPayload;
import com.ajel.exception.ResourceNotFoundException;
import com.ajel.model.Produto;
import com.ajel.services.PainelAcompanhaSeparacaoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class PainelAcompanhaSeparacaoController {


	@Autowired
	private PainelAcompanhaSeparacaoService  painelAcompanhaSeparacaoService;
	
    @GetMapping("/ajelpainelacompanhaseparacao/todo")
    public List<PainelAcompanhaSeparacaoPayload> getAllPainelAcompanhaSeparacaoPayload() {
        List<PainelAcompanhaSeparacaoPayload> resultado = painelAcompanhaSeparacaoService.findAllPainel();
        return (List<PainelAcompanhaSeparacaoPayload>) ResponseEntity.ok().body(resultado);

    }
    
    
    @GetMapping("/painelacompanhaseparacao/todos")
    public ResponseEntity<List<PainelAcompanhaSeparacaoPayload>> getPainelAcompanhaSeparacao()
            throws ResourceNotFoundException {
        List<PainelAcompanhaSeparacaoPayload> painelAcompanhaSeparacao = painelAcompanhaSeparacaoService.findAllPainel();
        return ResponseEntity.ok().body(painelAcompanhaSeparacao);
    }
    
    

}