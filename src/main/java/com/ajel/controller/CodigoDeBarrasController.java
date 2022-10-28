package com.ajel.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajel.exception.ResourceNotFoundException;
import com.ajel.model.CodigoDeBarras;
import com.ajel.model.CodigoDeBarrasPK;
import com.ajel.repository.CodigoDeBarrasRepository;
import com.ajel.repository.filter.CodigoDeBarrasFilter;

@RestController
@RequestMapping("/api/v1")
public class CodigoDeBarrasController {

    @Autowired
    private CodigoDeBarrasRepository codigoDeBarrasRepository;
    private List<CodigoDeBarras> codigoDeBarras;

    @GetMapping("/codigodebarras/todos")
    public List<CodigoDeBarras> getAllEstoques() {
        List<CodigoDeBarras> e = codigoDeBarrasRepository.findAll();
        return e;

    }

    @GetMapping("/codigodebarras/buscaget/{codprod}/{codbarra}")
    public ResponseEntity<CodigoDeBarras> getCodigoDeBarrasById(@PathVariable Long codprod, @PathVariable String codbarra)
            throws ResourceNotFoundException {
        CodigoDeBarrasPK id = new CodigoDeBarrasPK(codprod, codbarra);
        CodigoDeBarras codigoDeBarras = codigoDeBarrasRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Codigo de Barras não encontrado no codigo: " + id));
        return ResponseEntity.ok().body(codigoDeBarras);
    }

    @PostMapping("/codigodebarras/filtro") //
    public ResponseEntity<List<CodigoDeBarras>> getCodigoDeBarrasByCodprod(@RequestBody CodigoDeBarrasFilter filter)
            throws ResourceNotFoundException {
        codigoDeBarras = new ArrayList<>();

        if (filter.getCodprod() != null && ("").equals(filter.getCodbarra())) {
            codigoDeBarras = codigoDeBarrasRepository.findByIdCodprod(filter.getCodprod());
        } else if (filter.getCodprod() == null && !("").equals(filter.getCodbarra())) {
            codigoDeBarras = codigoDeBarrasRepository.findByIdCodbarra(filter.getCodbarra());
        } else {
            CodigoDeBarrasPK id = new CodigoDeBarrasPK(filter.getCodprod(), filter.getCodbarra());
            Optional<CodigoDeBarras> codigoDeBarrasOp = codigoDeBarrasRepository.findById(id);

            if (codigoDeBarrasOp.isPresent()) {
                codigoDeBarras.add(codigoDeBarrasOp.get());
            }
        }

        return ResponseEntity.ok().body(codigoDeBarras);
    }

    @PostMapping("/codigodebarras/novo")
    public CodigoDeBarras novoCodigoDeBarras(@Valid @RequestBody CodigoDeBarras codigoDeBarras) {
        return codigoDeBarrasRepository.save(codigoDeBarras);
    }

    @PutMapping("/codigodebarras/alteracao/{codprod}/{codbarra}")
    public ResponseEntity<CodigoDeBarras> atualizandoCodigoDeBarras(@PathVariable Long codprod, @PathVariable String codbarra,
            @Valid @RequestBody CodigoDeBarras estoqueDetails) throws ResourceNotFoundException {
        CodigoDeBarrasPK id = new CodigoDeBarrasPK(codprod, codbarra);
        CodigoDeBarras codigoDeBarras = codigoDeBarrasRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Codigo de Barras não encontrado no codigo: " + id));
        codigoDeBarras.setDtexclusao(new Date());
        
        final CodigoDeBarras updateEstoque = codigoDeBarrasRepository.save(codigoDeBarras);
        return ResponseEntity.ok(updateEstoque);

    }

    @DeleteMapping("/codigodebarras/delete/{codprod}/{codbarra}")
    public Map<String, Boolean> deletandoCodigoDeBarras(@PathVariable Long codprod, @PathVariable String codbarra)
            throws ResourceNotFoundException {
        CodigoDeBarrasPK id = new CodigoDeBarrasPK(codprod, codbarra);
        CodigoDeBarras codigoDeBarras = codigoDeBarrasRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Codigo de Barras não encontrado no codigo: " + id));

        codigoDeBarrasRepository.delete(codigoDeBarras);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
