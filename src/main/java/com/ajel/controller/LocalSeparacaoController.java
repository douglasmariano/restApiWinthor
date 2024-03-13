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
import com.ajel.model.LocalSeparacao;
import com.ajel.repository.LocalSeparacaoRepository;
import com.ajel.repository.filter.LocalSeparacaoFilter;


@RestController
@RequestMapping("/api/v1")
public class LocalSeparacaoController {
	@Autowired
	private LocalSeparacaoRepository localSeparacaoRepository;

	@GetMapping("/localSeparacao")
	public List<LocalSeparacao> getAllLocalSeparacaos() {
		return localSeparacaoRepository.findAll();
	}

	@GetMapping("/localSeparacao/{numped}")
	public List<LocalSeparacao> getLocalSeparacaoNumped(LocalSeparacaoFilter localSeparacaoFilter) {      
        return localSeparacaoRepository.pesquisar(localSeparacaoFilter);
	}
	
	@PostMapping("/localSeparacao/novo")
	public LocalSeparacao createLocalSeparacao(@Valid @RequestBody LocalSeparacao localSeparacao) {
		return localSeparacaoRepository.save(localSeparacao);
	}
	
	 @PostMapping("/localSeparacao/numpedlocal")
      public  ResponseEntity<List<LocalSeparacao>> getLocalSeparacaoNumpedLocal( @RequestBody LocalSeparacaoFilter localSeparacaoFilter) throws ResourceNotFoundException {
         List<LocalSeparacao> localSeparacao = null;
         localSeparacao = localSeparacaoRepository.pesquisar(localSeparacaoFilter);
                 //.orElseThrow(() -> new ResourceNotFoundException("Produto not found for this id :: " + numnota));
         return ResponseEntity.ok().body(localSeparacao);
     } 

	@PutMapping("/localSeparacao/{codpedidoc}")
	   public ResponseEntity <LocalSeparacao> updateLocalSeparacao(@PathVariable(value = "codpedidoc") Long codpedidoc,			  
			@Valid @RequestBody LocalSeparacao localSeparacaoDetails) throws ResourceNotFoundException{
		  	LocalSeparacao localSeparacao = localSeparacaoRepository.findById(codpedidoc).orElseThrow(() -> new ResourceNotFoundException("localSeparacao não encontrado com esse Numped :: "+ codpedidoc));
			
		  	localSeparacao.setCodfuncsep(localSeparacaoDetails.getCodfuncsep());
		  	localSeparacao.setDatainiciosep(localSeparacaoDetails.getDatainiciosep());
		  	localSeparacao.setDatafimsep(localSeparacaoDetails.getDatafimsep());
		  	localSeparacao.setFinalizado(localSeparacaoDetails.getFinalizado());
			
			final LocalSeparacao updateLocalSeparacao = localSeparacaoRepository.save(localSeparacao);
		  	return ResponseEntity.ok(updateLocalSeparacao);
		   
	   }
	
	 @DeleteMapping("/localSeparacao/{codpedidoc}")
	    public Map < String, Boolean > deleteLocalSeparacao(@PathVariable(value = "codpedidoc") Long codpedidoc)
	    throws ResourceNotFoundException {
	        LocalSeparacao localSeparacao = localSeparacaoRepository.findById(codpedidoc)
	            .orElseThrow(() -> new ResourceNotFoundException("localSeparacao não encontrado com esse codpedidoc :: " + codpedidoc));

	        localSeparacaoRepository.delete(localSeparacao);
	        Map < String, Boolean > response = new HashMap < > ();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }


}
