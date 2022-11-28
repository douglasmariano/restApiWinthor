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
import org.springframework.web.bind.annotation.RestController;

import com.ajel.exception.ResourceNotFoundException;
import com.ajel.model.EstoqueCaboHistorico;
import com.ajel.repository.EstoqueCaboHistoricoRepository;
import com.ajel.repository.filter.EstoqueCaboHistoricoFilter;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class EstoqueCaboHistoricoController {
	
    @Autowired
	private EstoqueCaboHistoricoRepository estoqueCaboHistoricoRepository;

	@GetMapping("/estoquecabohistorico")
	public List<EstoqueCaboHistorico> getEstoqueCaboHistorico(EstoqueCaboHistoricoFilter estoqueCaboHistoricoFilter) {      
	        return estoqueCaboHistoricoRepository.pesquisarHistorico(estoqueCaboHistoricoFilter);
	    }

	@GetMapping("/estoquecabohistorico/{codtransacaocabo}")
	public ResponseEntity<EstoqueCaboHistorico> getEstoqueById(@PathVariable Long codcabo)
			throws ResourceNotFoundException {
		EstoqueCaboHistorico estoqueCaboHistorico = estoqueCaboHistoricoRepository.findById(codcabo)
				.orElseThrow(() -> new ResourceNotFoundException("Produto not found for this id :: " + codcabo));
		return ResponseEntity.ok().body(estoqueCaboHistorico);
	}
	
	@PostMapping("/estoquecabohistorico/codprod")	
    public ResponseEntity<List<EstoqueCaboHistorico>> getEstoqueCaboCodprod(@RequestBody EstoqueCaboHistoricoFilter estoqueCaboHistoricoFilter)      
	    throws ResourceNotFoundException {
	        List<EstoqueCaboHistorico> estoqueCaboHistorico = null;
	        estoqueCaboHistorico = estoqueCaboHistoricoRepository.pesquisarHistorico(estoqueCaboHistoricoFilter);
	                //.orElseThrow(() -> new ResourceNotFoundException("Produto not found for this id :: " + numnota));
	        return ResponseEntity.ok().body(estoqueCaboHistorico);
        }
		
	
	@PostMapping("/estoquecabohistorico")
	public EstoqueCaboHistorico createTabPedido(@Valid @RequestBody EstoqueCaboHistorico estoqueCaboHistorico) {
		return estoqueCaboHistoricoRepository.save(estoqueCaboHistorico);
	}

	@PutMapping("/estoquecabohistorico/{codtransacaocabo}")
	   public ResponseEntity <EstoqueCaboHistorico> updateEstoqueCabo(@PathVariable(value = "codcabo") Long codcabo,			  
			@Valid @RequestBody EstoqueCaboHistorico estoqueCaboDetails) throws ResourceNotFoundException{
	        EstoqueCaboHistorico estoqueCaboHistorico = estoqueCaboHistoricoRepository.findById(codcabo).orElseThrow(() -> new ResourceNotFoundException("vendedor não encontrado com esse Numped :: "+ codcabo));
	        estoqueCaboHistorico.setQt(estoqueCaboDetails.getQt());

			final EstoqueCaboHistorico updateEstoqueCabo = estoqueCaboHistoricoRepository.save(estoqueCaboHistorico);
		  	return ResponseEntity.ok(updateEstoqueCabo);
		   
	   }
	
	
	 @DeleteMapping("/estoquecabohistorico/{codtransacaocabo}")
	    public Map < String, Boolean > deleteEstoqueCabo(@PathVariable(value = "codcabo") Long codcabo)
	    throws ResourceNotFoundException {
	        EstoqueCaboHistorico estoqueCaboHistorico = estoqueCaboHistoricoRepository.findById(codcabo)
	            .orElseThrow(() -> new ResourceNotFoundException("vendedor não encontrado com esse Numped :: " + codcabo));

	        estoqueCaboHistoricoRepository.delete(estoqueCaboHistorico);
	        Map < String, Boolean > response = new HashMap < > ();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }


}
