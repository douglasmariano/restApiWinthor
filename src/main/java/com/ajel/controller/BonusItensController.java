package com.ajel.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajel.exception.ResourceNotFoundException;
import com.ajel.model.BonusItens;
import com.ajel.model.BonusItensPk;
import com.ajel.repository.BonusItensRepository;
import com.ajel.repository.filter.BonusFilter;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class BonusItensController {
    @Autowired
    private BonusItensRepository bonusItensRepository;
    private List<BonusItens> bonusItens;

    @GetMapping("/bonusitens")
    public List<BonusItens> getTodosOsBonus() {
        return bonusItensRepository.findAll();
    }

    @GetMapping("/bonusitens/{numbonus}")
    public ResponseEntity<BonusItens> getTabPedidoById(@PathVariable(value = "numbonus") BonusItensPk numbonus)
            throws ResourceNotFoundException {
        BonusItens bonusitens = bonusItensRepository.findById(numbonus)
                .orElseThrow(() -> new ResourceNotFoundException("bonusitens not found for this id :: " + numbonus));
        return ResponseEntity.ok().body(bonusitens);
    }

    @PostMapping("/bonusitens/filtro") //
    public ResponseEntity<List<BonusItens>> getBonusItens(@RequestBody BonusFilter filter)
            throws ResourceNotFoundException {
        bonusItens = new ArrayList<>();

        if (filter.getCodprod() == null && !("").equals(filter.getNumbonus())) {
            bonusItens = bonusItensRepository.findByIdNumbonus(filter.getNumbonus());
        } else {
            BonusItensPk id = new BonusItensPk(filter.getCodprod(), filter.getNumbonus(), filter.getCodfilial());
            Optional<BonusItens> bonusItensOp = bonusItensRepository.findById(id);

            if (bonusItensOp.isPresent()) {
                bonusItens.add(bonusItensOp.get());
            }
        }
        return ResponseEntity.ok().body(bonusItens);
    }

    @PostMapping("/bonusitens")
    public BonusItens createTabPedido(@Valid @RequestBody BonusItens bonusitens) {
        return bonusItensRepository.save(bonusitens);
    }

    @PutMapping("/bonusitens/{numbonus}/{codprod}/{numlote}")
    public ResponseEntity<BonusItens> updateTabPedido(@PathVariable(value = "numbonus")  Long numbonus, @PathVariable(value = "codprod")  Long codprod, @PathVariable(value = "numlote")  String numlote,
            @Valid @RequestBody BonusItens bonusitensDetails) throws ResourceNotFoundException {
        BonusItensPk id = new BonusItensPk(codprod, numbonus, numlote);
        BonusItens bonusitens = bonusItensRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("bonusitens não encontrado com esse Numped :: " + numbonus));
        			bonusitens.setQtentun(bonusitensDetails.getQtentun());
        			bonusitens.setQtentcx(bonusitensDetails.getQtentcx());
        			bonusitens.setQtavariaun(bonusitensDetails.getQtavariaun());
        			bonusitens.setQtavariacx(bonusitensDetails.getQtavariacx());
        			bonusitens.setQtentrada(bonusitensDetails.getQtentrada());
        			bonusitens.setQtavaria(bonusitensDetails.getQtavaria());
        			bonusitens.setCodmotivo(bonusitensDetails.getCodmotivo());
        //			bonusitens.setQtnf(bonusitensDetails.getQtnf());
        //			bonusitens.setNome(vendedorDetails.getNome());
        //			bonusitens.setEmail(vendedorDetails.getEmail());
        //			bonusitens.setBloqueio(vendedorDetails.getBloqueio());

        final BonusItens updateVendedor = bonusItensRepository.save(bonusitens);
        return ResponseEntity.ok(updateVendedor);

    }

    @DeleteMapping("/bonusitens/{numbonus}")
    public Map<String, Boolean> deleteVendedor(@PathVariable(value = "numbonus") BonusItensPk numbonus)
            throws ResourceNotFoundException {
        BonusItens bonusitens = bonusItensRepository.findById(numbonus)
                .orElseThrow(() -> new ResourceNotFoundException("bonusitens não encontrado com esse Numped :: " + numbonus));

        bonusItensRepository.delete(bonusitens);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
