package com.ajel.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajel.exception.ResourceNotFoundException;
import com.ajel.model.NotaFiscalSaida;
import com.ajel.repository.NotaFiscalSaidaRepository;
import com.ajel.repository.filter.NotaFiscalSaidaFilter;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class NotaFiscalSaidaController {
     
    
    @Autowired
	private NotaFiscalSaidaRepository notaFiscalSaidaRepository;    


    
	@GetMapping("/notafiscalsaida")
	public List<NotaFiscalSaida> getNotaFiscalSaida(NotaFiscalSaidaFilter notaFiscalSaidaFilter) {		
        return notaFiscalSaidaRepository.pesquisar(notaFiscalSaidaFilter);
	}
	
	@PostMapping("/notafiscalsaida/numnota")
    public ResponseEntity<List<NotaFiscalSaida>> getNotaFiscalSaidaByNumnota(@RequestBody NotaFiscalSaidaFilter filter)
            throws ResourceNotFoundException {
        List<NotaFiscalSaida> NotaFiscalSaida = null;
        NotaFiscalSaida = notaFiscalSaidaRepository.pesquisar(filter);
                //.orElseThrow(() -> new ResourceNotFoundException("Produto not found for this id :: " + numnota));
        return ResponseEntity.ok().body(NotaFiscalSaida);
    }

	@GetMapping("/notafiscalsaida/{numtransvenda}")
	public ResponseEntity<NotaFiscalSaida> getNotaFiscalSaidaById(@PathVariable Long numtransvenda)
			throws ResourceNotFoundException {
		NotaFiscalSaida notaFiscalSaida = notaFiscalSaidaRepository.findById(numtransvenda)
				.orElseThrow(() -> new ResourceNotFoundException("NotaFiscalSaida not found for this id :: " + numtransvenda));
		return ResponseEntity.ok().body(notaFiscalSaida);
	}
	
	@PutMapping("/notafiscalsaida/dataCanhoto/{numtransvenda}")
    public ResponseEntity<NotaFiscalSaida> dataCanhoto(@PathVariable Long numtransvenda,
            @Valid @RequestBody NotaFiscalSaida notaFiscalSaidaDetails) throws ResourceNotFoundException {
        NotaFiscalSaida notaFiscalSaida = notaFiscalSaidaRepository.findById(numtransvenda)
                .orElseThrow(() -> new ResourceNotFoundException("Data não pode ser inserida na nf com seguinte numtransvendas :: " + numtransvenda));
      
        notaFiscalSaida.setDtcanhoto(notaFiscalSaidaDetails.getDtcanhoto());
        notaFiscalSaida.setObsnfcarreg(notaFiscalSaidaDetails.getObsnfcarreg());
        notaFiscalSaida.setCodfunclanc(null);

        final NotaFiscalSaida updateNotaFiscalSaida = notaFiscalSaidaRepository.save(notaFiscalSaida);
        return ResponseEntity.ok(updateNotaFiscalSaida);
        }
	//@PostMapping("/produto")
	
	//@PutMapping("/produto/{codprod}")
	
	// @DeleteMapping("/produto/{codprod}")



}
