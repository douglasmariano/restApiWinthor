package com.ajel.controller;

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

import com.ajel.exception.ResourceNotFoundException;
import com.ajel.model.Veiculo;
import com.ajel.repository.VeiculoRepository;


@RestController
@RequestMapping("/api/v1")
public class VeiculoController {
	@Autowired
	private VeiculoRepository veiculoRepository;

	@GetMapping("/veiculos")
	public List<Veiculo> getAllVeiculos() {
		return veiculoRepository.findAll();
	}

	@GetMapping("/veiculo/{codveiculo}")
	public ResponseEntity<Veiculo> getTabPedidoById(@PathVariable(value = "codveiculo") Long codveiculo)
			throws ResourceNotFoundException {
		Veiculo veiculo = veiculoRepository.findById(codveiculo)
				.orElseThrow(() -> new ResourceNotFoundException("veiculo not found for this id :: " + codveiculo));
		return ResponseEntity.ok().body(veiculo);
	}
	
	@PostMapping("/veiculo/novo")
	public Veiculo createVeiculo(@Valid @RequestBody Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}

	@PutMapping("/veiculo/{codveiculo}")
	   public ResponseEntity <Veiculo> updateVeiculo(@PathVariable(value = "codveiculo") Long codveiculo,			  
			@Valid @RequestBody Veiculo veiculoDetails) throws ResourceNotFoundException{
		  	Veiculo veiculo = veiculoRepository.findById(codveiculo).orElseThrow(() -> new ResourceNotFoundException("veiculo não encontrado com esse Numped :: "+ codveiculo));
			
			
			final Veiculo updateVeiculo = veiculoRepository.save(veiculo);
		  	return ResponseEntity.ok(updateVeiculo);
		   
	   }
	
	 @DeleteMapping("/veiculo/{codveiculo}")
	    public Map < String, Boolean > deleteVeiculo(@PathVariable(value = "codveiculo") Long codveiculo)
	    throws ResourceNotFoundException {
	        Veiculo veiculo = veiculoRepository.findById(codveiculo)
	            .orElseThrow(() -> new ResourceNotFoundException("veiculo não encontrado com esse codveiculo :: " + codveiculo));

	        veiculoRepository.delete(veiculo);
	        Map < String, Boolean > response = new HashMap < > ();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }


}
