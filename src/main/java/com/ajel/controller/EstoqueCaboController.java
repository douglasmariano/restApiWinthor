package com.ajel.controller;

import java.util.Date;
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
import com.ajel.model.EstoqueCabo;
import com.ajel.repository.EstoqueCaboRepository;
import com.ajel.repository.filter.EstoqueCaboFilter;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class EstoqueCaboController {
	
    @Autowired
	private EstoqueCaboRepository estoqueCaboRepository;

	@GetMapping("/estoquecabo")
	public List<EstoqueCabo> getEstoqueCabo(EstoqueCaboFilter estoqueCaboFilter) {      
	        return estoqueCaboRepository.pesquisar(estoqueCaboFilter);
	    }

	@GetMapping("/estoquecabo/{codcabo}")
	public ResponseEntity<EstoqueCabo> getEstoqueById(@PathVariable Long codcabo)
			throws ResourceNotFoundException {
		EstoqueCabo estoqueCabo = estoqueCaboRepository.findById(codcabo)
				.orElseThrow(() -> new ResourceNotFoundException("Produto not found for this id :: " + codcabo));
		return ResponseEntity.ok().body(estoqueCabo);
	}
	
	@PostMapping("/estoquecabo/codprod")	
    public ResponseEntity<List<EstoqueCabo>> getEstoqueCaboCodprod(@RequestBody EstoqueCaboFilter estoqueCaboFilter)      
	    throws ResourceNotFoundException {
	        List<EstoqueCabo> estoqueCabo = null;
	        estoqueCabo = estoqueCaboRepository.pesquisar(estoqueCaboFilter);
	                //.orElseThrow(() -> new ResourceNotFoundException("Produto not found for this id :: " + numnota));
	        return ResponseEntity.ok().body(estoqueCabo);
        }
		
	
	@PostMapping("/estoquecabo")
	public EstoqueCabo createTabPedido(@Valid @RequestBody EstoqueCabo estoqueCabo) {
		return estoqueCaboRepository.save(estoqueCabo);
	}

	@PutMapping("/estoquecabo/{codcabo}")
	   public ResponseEntity <EstoqueCabo> updateEstoqueCabo(@PathVariable(value = "codcabo") Long codcabo,			  
			@Valid @RequestBody EstoqueCabo estoqueCaboDetails) throws ResourceNotFoundException{
	        EstoqueCabo estoqueCabo = estoqueCaboRepository.findById(codcabo).orElseThrow(() -> new ResourceNotFoundException("vendedor não encontrado com esse Numped :: "+ codcabo));
	        estoqueCabo.setQt(estoqueCaboDetails.getQt());
	        estoqueCabo.setQtgerencial(estoqueCaboDetails.getQtgerencial());
	        estoqueCabo.setCodprod_pcest(estoqueCaboDetails.getCodprod_pcest());
	        estoqueCabo.setCodfilial_pcest(estoqueCaboDetails.getCodfilial_pcest());
	        estoqueCabo.setCodprod_pcprodut(estoqueCaboDetails.getCodprod_pcprodut());
	        estoqueCabo.setDtexclusao(estoqueCaboDetails.getDtexclusao());
	        estoqueCabo.setDtinclusao(estoqueCaboDetails.getDtinclusao());	       
	        estoqueCabo.setStatus(estoqueCaboDetails.getStatus());
	        estoqueCabo.setNumero(estoqueCaboDetails.getNumero());
	        estoqueCabo.setModulo(estoqueCaboDetails.getModulo());
	        estoqueCabo.setRua(estoqueCaboDetails.getRua());
	        estoqueCabo.setApto(estoqueCaboDetails.getApto());
	        
			final EstoqueCabo updateEstoqueCabo = estoqueCaboRepository.save(estoqueCabo);
		  	return ResponseEntity.ok(updateEstoqueCabo);
		   
	   }
	
	@PutMapping("/estoquecabo/dataExlusao/{codcabo}")
    public ResponseEntity<EstoqueCabo> dataExclusao(@PathVariable(value = "codcabo") Long codcabo) throws ResourceNotFoundException {
        EstoqueCabo estoqueCabo = estoqueCaboRepository.findById(codcabo)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado com esse Numped :: " + codcabo));
        
        estoqueCabo.setDtexclusao(new Date());
          

        final EstoqueCabo updateEstoqueCabo = estoqueCaboRepository.save(estoqueCabo);
        return ResponseEntity.ok(updateEstoqueCabo);
        }
	
	 @DeleteMapping("/estoquecabo/{codcabo}")
	    public Map < String, Boolean > deleteEstoqueCabo(@PathVariable(value = "codcabo") Long codcabo)
	    throws ResourceNotFoundException {
	        EstoqueCabo estoqueCabo = estoqueCaboRepository.findById(codcabo)
	            .orElseThrow(() -> new ResourceNotFoundException("vendedor não encontrado com esse Numped :: " + codcabo));

	        estoqueCaboRepository.delete(estoqueCabo);
	        Map < String, Boolean > response = new HashMap < > ();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }


}
