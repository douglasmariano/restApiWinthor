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
import com.ajel.model.EstoqueCabo;
import com.ajel.repository.EstoqueCaboRepository;
import com.ajel.repository.filter.EstoqueCaboFilter;

@CrossOrigin(origins = "http://192.168.200.55:4200")
@RestController
@RequestMapping("/api/v1")
public class EstoqueCaboController {
	
    @Autowired
	private EstoqueCaboRepository estoqueCaboRepository;

//	@GetMapping("/estoquecabos")
    //public List<EstoqueCabo> getAllEstoqueCabos() {
	//	return estoqueCaboRepository.findAll();
		
	//}

	@GetMapping("/estoquecabo")
	public List<EstoqueCabo> getEstoqueCabo(EstoqueCaboFilter estoqueCaboFilter) {      
	        return estoqueCaboRepository.pesquisar(estoqueCaboFilter);
	    }

	@GetMapping("/estoquecabo/{codendcabo}")
	public ResponseEntity<EstoqueCabo> getEstoqueById(@PathVariable Long codendcabo)
			throws ResourceNotFoundException {
		EstoqueCabo estoqueCabo = estoqueCaboRepository.findById(codendcabo)
				.orElseThrow(() -> new ResourceNotFoundException("Produto not found for this id :: " + codendcabo));
		return ResponseEntity.ok().body(estoqueCabo);
	}
		
	
	@PostMapping("/estoquecabo")
	public EstoqueCabo createTabPedido(@Valid @RequestBody EstoqueCabo estoqueCabo) {
		return estoqueCaboRepository.save(estoqueCabo);
	}

	@PutMapping("/estoquecabo/{codendcabo}")
	   public ResponseEntity <EstoqueCabo> updateEstoqueCabo(@PathVariable(value = "codendcabo") Long codendcabo,			  
			@Valid @RequestBody EstoqueCabo estoqueCaboDetails) throws ResourceNotFoundException{
	        EstoqueCabo estoqueCabo = estoqueCaboRepository.findById(codendcabo).orElseThrow(() -> new ResourceNotFoundException("vendedor não encontrado com esse Numped :: "+ codendcabo));
	        estoqueCabo.setCodprod(estoqueCaboDetails.getCodprod());
	        estoqueCabo.setQt(estoqueCaboDetails.getQt());
	        estoqueCabo.setQtreserv(estoqueCaboDetails.getQtreserv());
	        estoqueCabo.setDtultmovsai(estoqueCaboDetails.getDtultmovsai());
	        estoqueCabo.setDtultmovent(estoqueCaboDetails.getDtultmovent());
	        estoqueCabo.setDtvalidade(estoqueCaboDetails.getDtvalidade());
	        estoqueCabo.setTipoender(estoqueCaboDetails.getTipoender());
	        estoqueCabo.setStatus(estoqueCaboDetails.getStatus());
	        estoqueCabo.setNumbonus(estoqueCaboDetails.getNumbonus());
	        estoqueCabo.setCodfuncrm(estoqueCaboDetails.getCodfuncrm());
	        estoqueCabo.setDatabloqueio(estoqueCaboDetails.getDatabloqueio());
	        estoqueCabo.setDatadesbloqueio(estoqueCaboDetails.getDatadesbloqueio());
	        estoqueCabo.setCodfuncdesbloqueio(estoqueCaboDetails.getCodfuncdesbloqueio());
	        estoqueCabo.setDatafabricacao(estoqueCaboDetails.getDatafabricacao());
	        estoqueCabo.setNumlote(estoqueCaboDetails.getNumlote());
	        estoqueCabo.setQtbloqueada(estoqueCaboDetails.getQtbloqueada());
	        estoqueCabo.setNumlotefab(estoqueCaboDetails.getNumlotefab());
	        estoqueCabo.setNumlotefornec(estoqueCaboDetails.getNumlotefornec());
	        estoqueCabo.setFabricante(estoqueCaboDetails.getFabricante());
	        estoqueCabo.setObs1(estoqueCaboDetails.getObs1());
	        estoqueCabo.setObs2(estoqueCaboDetails.getObs2());
	        estoqueCabo.setEmbalagem(estoqueCaboDetails.getEmbalagem());
	        estoqueCabo.setUmidade(estoqueCaboDetails.getUmidade());
	        estoqueCabo.setNumtransent(estoqueCaboDetails.getNumtransent());
	        estoqueCabo.setIdentificacao(estoqueCaboDetails.getIdentificacao());
	        estoqueCabo.setCodequipe(estoqueCaboDetails.getCodequipe());
	        estoqueCabo.setNumero(estoqueCaboDetails.getNumero());
	        estoqueCabo.setModulo(estoqueCaboDetails.getModulo());
	        estoqueCabo.setRua(estoqueCaboDetails.getRua());
	        estoqueCabo.setApto(estoqueCaboDetails.getApto());
	        
			final EstoqueCabo updateEstoqueCabo = estoqueCaboRepository.save(estoqueCabo);
		  	return ResponseEntity.ok(updateEstoqueCabo);
		   
	   }
	
	 @DeleteMapping("/estoquecabo/{codendcabo}")
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
