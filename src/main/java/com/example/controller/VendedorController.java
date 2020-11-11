package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.example.exception.ResourceNotFoundException;
import com.example.model.Vendedor;
import com.example.repository.VendedorRepository;

@RestController
@RequestMapping("/api/v1")
public class VendedorController {
	@Autowired
	private VendedorRepository vendedorRepository;

	@GetMapping("/vendedores")
	public List<Vendedor> getAllTabPedidos() {
		return vendedorRepository.findAll();
	}

	@GetMapping("/vendedores/{codusur}")
	public ResponseEntity<Vendedor> getTabPedidoById(@PathVariable(value = "codusur") Long codusur)
			throws ResourceNotFoundException {
		Vendedor vendedor = vendedorRepository.findById(codusur)
				.orElseThrow(() -> new ResourceNotFoundException("vendedor not found for this id :: " + codusur));
		return ResponseEntity.ok().body(vendedor);
	}
	
	@PostMapping("/vendedores")
	public Vendedor createTabPedido(@Valid @RequestBody Vendedor vendedor) {
		return vendedorRepository.save(vendedor);
	}

	@PutMapping("/vendedores/{codusur}")
	   public ResponseEntity <Vendedor> updateTabPedido(@PathVariable(value = "codusur") Long codusur,			  
			@Valid @RequestBody Vendedor vendedorDetails) throws ResourceNotFoundException{
		  	Vendedor vendedor = vendedorRepository.findById(codusur).orElseThrow(() -> new ResourceNotFoundException("vendedor não encontrado com esse Numped :: "+ codusur));
			vendedor.setCodusur(vendedorDetails.getCodusur());
			vendedor.setNome(vendedorDetails.getNome());
			vendedor.setEmail(vendedorDetails.getEmail());
			vendedor.setBloqueio(vendedorDetails.getBloqueio());
			
			final Vendedor updateVendedor = vendedorRepository.save(vendedor);
		  	return ResponseEntity.ok(updateVendedor);
		   
	   }
	
	 @DeleteMapping("/vendedores/{codusur}")
	    public Map < String, Boolean > deleteVendedor(@PathVariable(value = "codusur") Long codusur)
	    throws ResourceNotFoundException {
	        Vendedor vendedor = vendedorRepository.findById(codusur)
	            .orElseThrow(() -> new ResourceNotFoundException("vendedor não encontrado com esse Numped :: " + codusur));

	        vendedorRepository.delete(vendedor);
	        Map < String, Boolean > response = new HashMap < > ();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }


}
