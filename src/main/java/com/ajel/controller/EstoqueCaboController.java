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
import com.ajel.model.EstoqueCabo;
import com.ajel.repository.EstoqueCaboRepository;

@CrossOrigin(origins = "http://192.168.200.55:4200")
@RestController
@RequestMapping("/api/v1")
public class EstoqueCaboController {
	
    @Autowired
	private EstoqueCaboRepository estoqueCaboRepository;

	@GetMapping("/estoquecabos")
	public List<EstoqueCabo> getAllEstoqueCabos() {
		return estoqueCaboRepository.findAll();
		
	}

	@GetMapping("/estoquecabos/{codprod}")
	public ResponseEntity<EstoqueCabo> getEstoqueCaboById(@RequestParam(required=false ,value = "codprod") Long codprod)
			throws ResourceNotFoundException {
		EstoqueCabo estoqueCabo = estoqueCaboRepository.findById(codprod)
				.orElseThrow(() -> new ResourceNotFoundException("Produto not found for this id :: " + codprod));
		return ResponseEntity.ok().body(estoqueCabo);
	}
		
	
	@PostMapping("/estoquecabos")
	public EstoqueCabo createTabPedido(@Valid @RequestBody EstoqueCabo estoqueCabo) {
		return estoqueCaboRepository.save(estoqueCabo);
	}

	@PutMapping("/estoquecabos/{codendcabo}")
	   public ResponseEntity <EstoqueCabo> updateEstoqueCabo(@PathVariable(value = "codendcabo") Long codendcabo,			  
			@Valid @RequestBody EstoqueCabo estoqueCaboDetails) throws ResourceNotFoundException{
	        EstoqueCabo estoqueCabo = estoqueCaboRepository.findById(codendcabo).orElseThrow(() -> new ResourceNotFoundException("vendedor não encontrado com esse Numped :: "+ codendcabo));
	        estoqueCabo.setCodendcabo(estoqueCaboDetails.getCodendcabo());	      
			
			final EstoqueCabo updateEstoqueCabo = estoqueCaboRepository.save(estoqueCabo);
		  	return ResponseEntity.ok(updateEstoqueCabo);
		   
	   }
	
	 @DeleteMapping("/estoquecabos/{codendcabo}")
	    public Map < String, Boolean > deleteEstoqueCabo(@PathVariable(value = "codendcabo") Long codendcabo)
	    throws ResourceNotFoundException {
	        EstoqueCabo estoqueCabo = estoqueCaboRepository.findById(codendcabo)
	            .orElseThrow(() -> new ResourceNotFoundException("vendedor não encontrado com esse Numped :: " + codendcabo));

	        estoqueCaboRepository.delete(estoqueCabo);
	        Map < String, Boolean > response = new HashMap < > ();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }


}
