package com.ajel.controller;

import java.util.ArrayList;
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
import com.ajel.model.AjelEntrega;
import com.ajel.model.Bonus;
import com.ajel.model.BonusItens;
import com.ajel.model.BonusItensPk;
import com.ajel.repository.BonusRepository;
import com.ajel.repository.filter.BonusFilter;

@RestController
@RequestMapping("/api/v1")
public class BonusController {

    @Autowired
    private BonusRepository bonusRepository;
    

    @GetMapping("/bonusentrada")
    public List<Bonus> getProduto(BonusFilter bonusFilter) {
        return bonusRepository.pesquisar(bonusFilter);
    }

    @GetMapping("/bonusEntrada/{numbonus}")
    public ResponseEntity<Bonus> getBonusById(@PathVariable Long numbonus)
            throws ResourceNotFoundException {
        Bonus bonus = bonusRepository.findById(numbonus)
                .orElseThrow(() -> new ResourceNotFoundException("Bonus not found for this id :: " + numbonus));
        return ResponseEntity.ok().body(bonus);
    }

    @PostMapping("/bonusentrada/novo")
    public Bonus createProduto(@Valid @RequestBody Bonus bonus) {
        return bonusRepository.save(bonus);
    }
    
    @PostMapping("/bonusentrada/filtro") //
    public ResponseEntity<List<Bonus>> getBonusItens(@RequestBody BonusFilter filter)
            throws ResourceNotFoundException {  
        List<Bonus> bonusEntrada = null;
        bonusEntrada = bonusRepository.pesquisar(filter);       
        return ResponseEntity.ok().body(bonusEntrada);
    }

    @PutMapping("/bonusentrada/{numbonus}")
    public ResponseEntity<Bonus> updateProduto(@PathVariable(value = "numbonus") Long codprod,
            @Valid @RequestBody Bonus estoqueCaboDetails) throws ResourceNotFoundException {
        Bonus bonus = bonusRepository.findById(codprod)
                .orElseThrow(() -> new ResourceNotFoundException("vendedor não encontrado com esse Numped :: " + codprod));
      //  bonus.setCodprod(estoqueCaboDetails.getCodprod());

        final Bonus updateEstoqueCabo = bonusRepository.save(bonus);
        return ResponseEntity.ok(updateEstoqueCabo);

    }

    @DeleteMapping("/bonusentrada/{codprod}")
    public Map<String, Boolean> deleteProduto(@PathVariable(value = "codprod") Long codprod)
            throws ResourceNotFoundException {
        Bonus bonus = bonusRepository.findById(codprod)
                .orElseThrow(() -> new ResourceNotFoundException("vendedor não encontrado com esse Numped :: " + codprod));

        bonusRepository.delete(bonus);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
