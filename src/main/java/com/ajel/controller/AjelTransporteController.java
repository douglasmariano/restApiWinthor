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
import com.ajel.model.Transporte;
import com.ajel.repository.AjelTransporteRepository;
import com.ajel.repository.filter.AjelTransporteFilter;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class AjelTransporteController {
	
    @Autowired
	private AjelTransporteRepository ajelTransporteRepository;

//	@GetMapping("/estoquecabos")
    //public List<AjelTransporte> getAllEstoqueCabos() {
	//	return estoqueCaboRepository.findAll();
		
	//}

	@GetMapping("/ajeltransporte")
	public List<Transporte> getAjelTransportes(AjelTransporteFilter ajelTransporteFilter) {      
	        return ajelTransporteRepository.pesquisar(ajelTransporteFilter);
	    }

	@GetMapping("/ajeltransporte/codtransporte/{codtransporte}")
	public ResponseEntity<Transporte> getEntregaById(@PathVariable Long codtransporte)
			throws ResourceNotFoundException {
		Transporte transporte = ajelTransporteRepository.findById(codtransporte)
				.orElseThrow(() -> new ResourceNotFoundException("Produto not found for this id :: " + codtransporte));
		return ResponseEntity.ok().body(transporte);
	}
	
	@PostMapping("/ajeltransporte/numnota")
    public ResponseEntity<List<Transporte>> getEntregaByNumnota(@RequestBody AjelTransporteFilter filter)
            throws ResourceNotFoundException {
	    List<Transporte> transporte = null;
	    transporte = ajelTransporteRepository.pesquisar(filter);
                //.orElseThrow(() -> new ResourceNotFoundException("Produto not found for this id :: " + numnota));
        return ResponseEntity.ok().body(transporte);
    }
	
	@PostMapping("/ajeltransporte/dtentrega")
    public ResponseEntity<List<Transporte>> getEntregaByDtEntrega(@RequestBody AjelTransporteFilter filter)
            throws ResourceNotFoundException {
        List<Transporte> transporte = null;
        transporte = ajelTransporteRepository.pesquisar(filter);
                //.orElseThrow(() -> new ResourceNotFoundException("Produto not found for this id :: " + numnota));
        return ResponseEntity.ok().body(transporte);
    }

	
	@PostMapping("/ajeltransporte/novo")
	public Transporte createAjelTransporte(@Valid @RequestBody Transporte transporte) {
	    transporte.setDtinclusao(new Date());
	    return ajelTransporteRepository.save(transporte);
	}
	
	@PostMapping("/ajeltransporte/pesquisarNotaWinthor") 
    public ResponseEntity<List<Transporte>> getInformacaoPedidoById(@RequestBody AjelTransporteFilter filter)
            throws ResourceNotFoundException {
        List<Transporte> pedidoWinthor = null;        
      //  pedidoWinthor = ajelTransporteService.findByNumnota(filter); 
        
        return ResponseEntity.ok().body(pedidoWinthor);
    }

	@PutMapping("/ajeltransporte/alterarTransporte/{codtransporte}")
	   public ResponseEntity <Transporte> updateAjelTransporte(@PathVariable(value = "codtransporte") Long codtransporte,			  
			@Valid @RequestBody Transporte ajelTransporteDetails) throws ResourceNotFoundException{
	        Transporte transporte = ajelTransporteRepository.findById(codtransporte).orElseThrow(() -> new ResourceNotFoundException("Erro na Transporte: "+ codtransporte));	   
	        transporte.setCodmotorista(ajelTransporteDetails.getCodmotorista());
	        transporte.setCodfuncajud(ajelTransporteDetails.getCodfuncajud());
	        //ajelTransporte.setEndercob(ajelTransporteDetails.getEndercob());
	        //ajelTransporte.setNomecidade(ajelTransporteDetails.getNomecidade());	  
			final Transporte updateAjelTransporte = ajelTransporteRepository.save(transporte);
		  	return ResponseEntity.ok(updateAjelTransporte);
		   
	   }
	
	@PutMapping("/ajeltransporte/dataExlusao/{codtransporte}")
    public ResponseEntity<Transporte> dataExclusao(@PathVariable(value = "codtransporte") Long codtransporte    ,    @Valid @RequestBody Transporte ajelTransporteDetails) throws ResourceNotFoundException{
        Transporte transporte = ajelTransporteRepository.findById(codtransporte).orElseThrow(() -> new ResourceNotFoundException("Erro na Transporte: "+ codtransporte));

        transporte.setCodmotorista(ajelTransporteDetails.getCodmotorista());
        transporte.setDtexclusao(new Date());

        final Transporte updateAjelTransporte = ajelTransporteRepository.save(transporte);
        return ResponseEntity.ok(updateAjelTransporte);
        }
	
	 @DeleteMapping("/ajeltransporte/{codtransporte}")
	    public Map < String, Boolean > deleteEstoqueCabo(@PathVariable(value = "codtransporte") Long codtransporte)
	    throws ResourceNotFoundException {
	        Transporte transporte = ajelTransporteRepository.findById(codtransporte)
	            .orElseThrow(() -> new ResourceNotFoundException("Erro na entrega: " + codtransporte));

	        ajelTransporteRepository.delete(transporte);
	        Map < String, Boolean > response = new HashMap < > ();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }


}
