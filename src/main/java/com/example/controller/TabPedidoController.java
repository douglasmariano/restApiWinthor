package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.ResourceNotFoundException;
import com.example.model.TabPedido;
import com.example.repository.TabPedidoRepository;

@RestController
@RequestMapping("/api/v1")
public class TabPedidoController {
	 @Autowired
	    private TabPedidoRepository tabPedidoRepository;

	    @GetMapping("/tabpedido")
	    public List < TabPedido > getAllTabPedidos() {
	        return tabPedidoRepository.findAll();
	    }

	    @GetMapping("/tabpedido/{NUMPED}")
	    public ResponseEntity < TabPedido > getTabPedidoById(@PathVariable(value = "NUMPED") Long NUMPED)
	    throws ResourceNotFoundException {
	        TabPedido tabpedido = tabPedidoRepository.findById(NUMPED)
	            .orElseThrow(() -> new ResourceNotFoundException("TabPedido not found for this id :: " + NUMPED));
	        return ResponseEntity.ok().body(tabpedido);
	    }

	   

}
