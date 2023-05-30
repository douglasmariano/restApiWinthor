package com.ajel.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajel.controller.payloads.PainelAcompanhaPedidoPayload;
import com.ajel.controller.payloads.PainelDePedidoPorProdutoPayload;
import com.ajel.exception.ResourceNotFoundException;
import com.ajel.repository.PainelAcompanhaPedidoRepository;
import com.ajel.repository.filter.PainelAcompanhaPedidoFilter;
import com.ajel.services.PainelAcompanhaPedidoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class PainelAcompanhaPedidoController {
	@Autowired
	private PainelAcompanhaPedidoRepository painelAcompanhaPedidoRepository;

	@Autowired
	private PainelAcompanhaPedidoService  painelAcompanhaPedidoService;
	


    @PostMapping("/painelAcompanhaPedido") // @RequestParam(value = "numped") BigDecimal NUMPED
    public ResponseEntity<List<PainelAcompanhaPedidoPayload>> getPainelAcompanhaPedido(@RequestBody PainelAcompanhaPedidoFilter filter)
            throws ResourceNotFoundException {
        List<PainelAcompanhaPedidoPayload> painelAcompanhaPedido = null;
        if (filter != null && !StringUtils.isEmpty(filter.getNumped())) {
            painelAcompanhaPedido = painelAcompanhaPedidoService.findById(filter.getNumped());
        } else if (filter != null && (filter.getDataPedidoDe() != null || filter.getDataPedidoAte() != null
                || filter.getNomeCliente() != null || filter.getNomeVendedor() != null)) {
            painelAcompanhaPedido = painelAcompanhaPedidoService.findByFiltro(filter);
        } else {
            painelAcompanhaPedido = painelAcompanhaPedidoService.findAllPainel();
        }

        return ResponseEntity.ok().body(painelAcompanhaPedido);
    }

	
    @PostMapping("/painelAcompanhaPedido/produto")
    public ResponseEntity<List<PainelDePedidoPorProdutoPayload>> getAllPainelPedidoPorProduto(@RequestBody List<BigDecimal> filter)
            throws ResourceNotFoundException{        
        List<PainelDePedidoPorProdutoPayload> resultado = painelAcompanhaPedidoService.findAllPainelProduto(filter);
        return ResponseEntity.ok().body(resultado);

    }

}