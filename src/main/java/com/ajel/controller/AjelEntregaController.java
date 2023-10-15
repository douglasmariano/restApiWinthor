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
import com.ajel.model.Entrega;
import com.ajel.repository.AjelEntregaRepository;
import com.ajel.repository.filter.AjelEntregaFilter;
import com.ajel.services.AjelEntregaService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class AjelEntregaController {
	
    @Autowired
	private AjelEntregaRepository ajelEntregaRepository;
    
    @Autowired
    private AjelEntregaService ajelEntregaService;

//	@GetMapping("/estoquecabos")
    //public List<AjelEntrega> getAllEstoqueCabos() {
	//	return estoqueCaboRepository.findAll();
		
	//}

	@GetMapping("/ajelentrega")
	public List<Entrega> getAjelEntregas(AjelEntregaFilter ajelEntregaFilter) {      
	        return ajelEntregaRepository.pesquisar(ajelEntregaFilter);
	    }

	@GetMapping("/ajelentrega/codentrega/{codentrega}")
	public ResponseEntity<Entrega> getEntregaById(@PathVariable Long codentrega)
			throws ResourceNotFoundException {
		Entrega entrega = ajelEntregaRepository.findById(codentrega)
				.orElseThrow(() -> new ResourceNotFoundException("Produto not found for this id :: " + codentrega));
		return ResponseEntity.ok().body(entrega);
	}
	
	@PostMapping("/ajelentrega/numnota")
    public ResponseEntity<List<Entrega>> getEntregaByNumnota(@RequestBody AjelEntregaFilter filter)
            throws ResourceNotFoundException {
	    List<Entrega> entrega = null;
	    entrega = ajelEntregaRepository.pesquisar(filter);
                //.orElseThrow(() -> new ResourceNotFoundException("Produto not found for this id :: " + numnota));
        return ResponseEntity.ok().body(entrega);
    }
	
	@PostMapping("/ajelentrega/dtentrega")
    public ResponseEntity<List<Entrega>> getEntregaByDtEntrega(@RequestBody AjelEntregaFilter filter)
            throws ResourceNotFoundException {
        List<Entrega> entrega = null;
        entrega = ajelEntregaRepository.pesquisar(filter);
                //.orElseThrow(() -> new ResourceNotFoundException("Produto not found for this id :: " + numnota));
        return ResponseEntity.ok().body(entrega);
    }

	
	@PostMapping("/ajelentrega")
	public Entrega createAjelEntrega(@Valid @RequestBody Entrega entrega) {
	    entrega.setDtinclusao(new Date());
	    return ajelEntregaRepository.save(entrega);
	}
	
	@PostMapping("/ajelentrega/pesquisarNotaWinthor") 
    public ResponseEntity<List<Entrega>> getInformacaoPedidoById(@RequestBody AjelEntregaFilter filter)
            throws ResourceNotFoundException {
        List<Entrega> pedidoWinthor = null;        
        pedidoWinthor = ajelEntregaService.findByNumnota(filter); 
        
        return ResponseEntity.ok().body(pedidoWinthor);
    }

	@PutMapping("/ajelentrega/alterarSeparacao/{codentrega}")
	   public ResponseEntity <Entrega> updateAjelEntrega(@PathVariable(value = "codentrega") Long codentrega,			  
			@Valid @RequestBody Entrega ajelEntregaDetails) throws ResourceNotFoundException{
	        Entrega entrega = ajelEntregaRepository.findById(codentrega).orElseThrow(() -> new ResourceNotFoundException("Erro na Entrega: "+ codentrega));
	        //ajelEntrega.setCodcidade(ajelEntregaDetails.getCodcidade());
	        entrega.setObsdoentregador(ajelEntregaDetails.getObsdoentregador());
	        entrega.setLocal(ajelEntregaDetails.getLocal());
	        entrega.setCodfornecfrete(ajelEntregaDetails.getCodfornecfrete());
	        entrega.setCodfuncconf(ajelEntregaDetails.getCodfuncconf());
	        entrega.setCodmotorista(ajelEntregaDetails.getCodmotorista());
	        //ajelEntrega.setDtentrega(ajelEntregaDetails.getDtentrega());
	        //ajelEntrega.setEndercob(ajelEntregaDetails.getEndercob());
	        //ajelEntrega.setNomecidade(ajelEntregaDetails.getNomecidade());
	        entrega.setFornecedor(ajelEntregaDetails.getFornecedor());
	        entrega.setNomemotorista(ajelEntregaDetails.getNomemotorista());
	        entrega.setNomeconf(ajelEntregaDetails.getNomeconf());
	        entrega.setLocal(ajelEntregaDetails.getLocal());
	        
			final Entrega updateAjelEntrega = ajelEntregaRepository.save(entrega);
		  	return ResponseEntity.ok(updateAjelEntrega);
		   
	   }
	
	@PutMapping("/ajelentrega/alterarVolume/{codentrega}")
    public ResponseEntity <Entrega> updateVolumeEntrega(@PathVariable(value = "codentrega") Long codentrega,             
         @Valid @RequestBody Entrega ajelEntregaDetails) throws ResourceNotFoundException{
         Entrega entrega = ajelEntregaRepository.findById(codentrega).orElseThrow(() -> new ResourceNotFoundException("Erro na Entrega: "+ codentrega));
         entrega.setNumvolume(ajelEntregaDetails.getNumvolume());
         
         final Entrega updateVolumeEntrega = ajelEntregaRepository.save(entrega);
         return ResponseEntity.ok(updateVolumeEntrega);
        
    }
	
	@PutMapping("/ajelentrega/dataExlusao/{codentrega}")
    public ResponseEntity<Entrega> dataExclusao(@PathVariable(value = "codentrega") Long codentrega) throws ResourceNotFoundException {
        Entrega entrega = ajelEntregaRepository.findById(codentrega)
                .orElseThrow(() -> new ResourceNotFoundException("Erro na entrega :: " + codentrega));
        
        entrega.setDtexclusao(new Date());
          

        final Entrega updateAjelEntrega = ajelEntregaRepository.save(entrega);
        return ResponseEntity.ok(updateAjelEntrega);
        }
	
	 @DeleteMapping("/ajelentrega/{codentrega}")
	    public Map < String, Boolean > deleteEstoqueCabo(@PathVariable(value = "codentrega") Long codentrega)
	    throws ResourceNotFoundException {
	        Entrega entrega = ajelEntregaRepository.findById(codentrega)
	            .orElseThrow(() -> new ResourceNotFoundException("Erro na entrega: " + codentrega));

	        ajelEntregaRepository.delete(entrega);
	        Map < String, Boolean > response = new HashMap < > ();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }


}
