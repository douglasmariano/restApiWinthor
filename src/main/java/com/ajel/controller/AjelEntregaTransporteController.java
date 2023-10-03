package com.ajel.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ajel.exception.ResourceNotFoundException;
import com.ajel.model.EntregaTransporte;
import com.ajel.model.EntregaTransportePK;
import com.ajel.repository.AjelEntregaTransporteRepository;
import com.ajel.repository.filter.AjelEntregaTransporteFilter;
import com.ajel.services.UserService;

@RestController
@RequestMapping("/api/v1")
public class AjelEntregaTransporteController {

    @Autowired
    private AjelEntregaTransporteRepository ajelEntregaTransporteRepository;    
    private List<EntregaTransporte> entregaTransporte;
    
    @Autowired
    private UserService userService;


    public String getName(Authentication authentication, Principal principal) {
        return "";
    }
    
    
    @GetMapping("/ajelentregatransporte/todos")
    public List<EntregaTransporte> getAllEstoques() {
        List<EntregaTransporte> e = ajelEntregaTransporteRepository.findAll();
        return e;

    }

    @GetMapping("/ajelentregatransporte/buscaget/{codentrega}/{codtransporte}")
    public ResponseEntity<EntregaTransporte> getAjelEntregaTransporteById(@PathVariable Long codentrega, @PathVariable Long codtransporte)
            throws ResourceNotFoundException {
        EntregaTransportePK id = new EntregaTransportePK(codentrega, codtransporte);
        EntregaTransporte entregaTransporte = ajelEntregaTransporteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Codigo de Barras não encontrado no codigo: " + id));
        return ResponseEntity.ok().body(entregaTransporte);
    }

    @PostMapping("/ajelentregatransporte/filtro") //
    public ResponseEntity<List<EntregaTransporte>> getAjelEntregaTransporte(@RequestBody AjelEntregaTransporteFilter filter)
            throws ResourceNotFoundException {
        entregaTransporte = new ArrayList<>();

        Long codtransporte = filter.getCodtransporte();
        if (filter.getCodentrega() != null && ("").equals(codtransporte)) {
            entregaTransporte = ajelEntregaTransporteRepository.findByIdCodentrega(filter.getCodentrega());
        } else if (filter.getCodentrega() == null && !("").equals(codtransporte)) {
            entregaTransporte = ajelEntregaTransporteRepository.findByIdCodtransporte(codtransporte);
        } else {
            EntregaTransportePK id = new EntregaTransportePK(filter.getCodentrega(), codtransporte);
            Optional<EntregaTransporte> ajelEntregaTransporteOp = ajelEntregaTransporteRepository.findById(id);

            if (ajelEntregaTransporteOp.isPresent()) {
                entregaTransporte.add(ajelEntregaTransporteOp.get());
            }
        }

        return ResponseEntity.ok().body(entregaTransporte);
    }

    @PostMapping("/ajelentregatransporte/novo")
    public EntregaTransporte novoAjelEntregaTransporte(@Valid @RequestBody EntregaTransporte entregaTransporte, Authentication authentication, Principal principal) {
        Long userIdByMatricula = userService.getUserIdByMatricula(principal.getName());
        entregaTransporte.setCodusur(userIdByMatricula);
        entregaTransporte.setDtsaida(new Date());
        return ajelEntregaTransporteRepository.save(entregaTransporte);
    }

    @PutMapping("/ajelentregatransporte/saida/{codentrega}/{codtransporte}")
    public ResponseEntity<EntregaTransporte> atualizandoAjelEntregaTransporteSaida(@PathVariable Long codentrega, @PathVariable Long codtransporte,
            @Valid @RequestBody EntregaTransporte estoqueDetails) throws ResourceNotFoundException {
        EntregaTransportePK id = new EntregaTransportePK(codentrega, codtransporte);
        EntregaTransporte entregaTransporte = ajelEntregaTransporteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Codigo de Barras não encontrado no codigo: " + id));        
        entregaTransporte.setDtsaida(new Date());
        entregaTransporte.setCodusur(estoqueDetails.getCodusur());
        
        final EntregaTransporte updateEstoque = ajelEntregaTransporteRepository.save(entregaTransporte);
        return ResponseEntity.ok(updateEstoque);

    }
    
    @PutMapping("/ajelentregatransporte/chegada/{codentrega}/{codtransporte}")
    public ResponseEntity<EntregaTransporte> atualizandoAjelEntregaTransporteChegada(@PathVariable Long codentrega, @PathVariable Long codtransporte,
            @Valid @RequestBody EntregaTransporte estoqueDetails,  Authentication authentication, Principal principal) throws ResourceNotFoundException {
        EntregaTransportePK id = new EntregaTransportePK(codentrega, codtransporte);
        EntregaTransporte entregaTransporte = ajelEntregaTransporteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Codigo de Barras não encontrado no codigo: " + id));
        entregaTransporte.setDtchegada(new Date());
        entregaTransporte.setDtsaida(estoqueDetails.getDtsaida());
        entregaTransporte.setCoddevol(estoqueDetails.getCoddevol()); 
        Long userIdByMatricula = userService.getUserIdByMatricula(principal.getName());
        entregaTransporte.setCodusur(userIdByMatricula);
        final EntregaTransporte updateEstoque = ajelEntregaTransporteRepository.save(entregaTransporte);
        return ResponseEntity.ok(updateEstoque);

    }

    @DeleteMapping("/ajelentregatransporte/delete/{codentrega}/{codtransporte}")
    public Map<String, Boolean> deletandoAjelEntregaTransporte(@PathVariable Long codentrega, @PathVariable Long codtransporte)
            throws ResourceNotFoundException {
        EntregaTransportePK id = new EntregaTransportePK(codentrega, codtransporte);
        EntregaTransporte entregaTransporte = ajelEntregaTransporteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Codigo de Barras não encontrado no codigo: " + id));

        ajelEntregaTransporteRepository.delete(entregaTransporte);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
