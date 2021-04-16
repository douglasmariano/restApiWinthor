package com.ajel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ajel.exception.ResourceNotFoundException;
import com.ajel.model.Produto;
import com.ajel.repository.ProdutoRepository;

@CrossOrigin(origins = "http://192.168.200.55:4200")
@RestController
@RequestMapping("/api/v1")
public class ProdutoController {
	
    @Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping("/produtos")
	public List<Produto> getAllEstoqueCabos() {
		return produtoRepository.findAll();
		
	}

	@GetMapping("/produtos/{codprod}")
	public ResponseEntity<Produto> getEstoqueById(@PathVariable(required=false ,value = "codprod") Long codprod)
			throws ResourceNotFoundException {
		Produto produto = produtoRepository.findById(codprod)
				.orElseThrow(() -> new ResourceNotFoundException("Produto not found for this id :: " + codprod));
		return ResponseEntity.ok().body(produto);
	}
		
	
	@PostMapping("/produtos")
	public Produto createTabPedido(@Valid @RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

	@PutMapping("/produtos/{codprod}")
	   public ResponseEntity <Produto> updateEstoqueCabo(@PathVariable(value = "codprod") Long codprod,			  
			@Valid @RequestBody Produto estoqueCaboDetails) throws ResourceNotFoundException{
	        Produto produto = produtoRepository.findById(codprod).orElseThrow(() -> new ResourceNotFoundException("vendedor não encontrado com esse Numped :: "+ codprod));
	        produto.setCodprod(estoqueCaboDetails.getCodprod());
	       
	        
			final Produto updateEstoqueCabo = produtoRepository.save(produto);
		  	return ResponseEntity.ok(updateEstoqueCabo);
		   
	   }
	
	 @DeleteMapping("/produtos/{codprod}")
	    public Map < String, Boolean > deleteEstoqueCabo(@PathVariable(value = "codprod") Long codprod)
	    throws ResourceNotFoundException {
	        Produto produto = produtoRepository.findById(codprod)
	            .orElseThrow(() -> new ResourceNotFoundException("vendedor não encontrado com esse Numped :: " + codprod));

	        produtoRepository.delete(produto);
	        Map < String, Boolean > response = new HashMap < > ();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }


}
