package com.ajel.controller;

import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ajel.exception.ResourceNotFoundException;
import com.ajel.model.EstoqueCabo;
import com.ajel.repository.EstoqueCaboRepository;
import com.ajel.repository.filter.EstoqueCaboFilter;
import com.ajel.services.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class EstoqueCaboController {
	
    @Autowired
	private EstoqueCaboRepository estoqueCaboRepository;
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public String getName(Authentication authentication, Principal principal) {
        System.out.println(authentication.getDetails());
        System.out.println("-----------------");
        System.out.println(principal.getName());
        System.out.println("-----------------");
        System.out.println(authentication.getPrincipal());
        return "";
    }
    
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
	public EstoqueCabo createTabPedido(@Valid @RequestBody EstoqueCabo estoqueCabo, Authentication authentication, Principal principal) {
	    Long userIdByMatricula = userService.getUserIdByMatricula(principal.getName());
	    estoqueCabo.setMatricula(userIdByMatricula);
	    estoqueCabo.setDtinclusao(new Date());
		return estoqueCaboRepository.save(estoqueCabo);
	}

	@PutMapping("/estoquecabo/{codcabo}")
	   public ResponseEntity <EstoqueCabo> updateEstoqueCabo(@PathVariable(value = "codcabo" ) Long codcabo,			  
			@Valid @RequestBody EstoqueCabo estoqueCaboDetails, Authentication authentication, Principal principal ) throws ResourceNotFoundException{
	        EstoqueCabo estoqueCabo = estoqueCaboRepository.findById(codcabo).orElseThrow(() -> new ResourceNotFoundException("Cabo não encontrado com esse Numped :: "+ codcabo));
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
	        estoqueCabo.setCodfornec(estoqueCaboDetails.getCodfornec());
	        estoqueCabo.setCodmarca(estoqueCaboDetails.getCodmarca());
	        
			final EstoqueCabo updateEstoqueCabo = estoqueCaboRepository.save(estoqueCabo);
		  	return ResponseEntity.ok(updateEstoqueCabo);
		   
	   }
	
	   @PutMapping("/estoquecabo/baixaQuantidade/{codcabo}")
       public ResponseEntity <EstoqueCabo> baixaEstoqueCabo(@PathVariable(value = "codcabo" ) Long codcabo,              
            @Valid @RequestBody EstoqueCabo estoqueCaboDetails, Authentication authentication, Principal principal ) throws ResourceNotFoundException{
            EstoqueCabo estoqueCabo = estoqueCaboRepository.findById(codcabo).orElseThrow(() -> new ResourceNotFoundException("Cabo não encontrado com esse Codcabo :: "+ codcabo));
            estoqueCabo.setQt(estoqueCaboDetails.getQt());
              if (estoqueCabo.getStatus().equals("FECHADO")) {
                  estoqueCabo.setStatus("ABERTO");
              }
          
            
            final EstoqueCabo updateEstoqueCabo = estoqueCaboRepository.save(estoqueCabo);
            return ResponseEntity.ok(updateEstoqueCabo);
           
       }
	
	@PutMapping("/estoquecabo/dataExclusao/{codcabo}")
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
	            .orElseThrow(() -> new ResourceNotFoundException("Cabo não encontrado com esse Numped :: " + codcabo));

	        estoqueCaboRepository.delete(estoqueCabo);
	        Map < String, Boolean > response = new HashMap < > ();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }


}
