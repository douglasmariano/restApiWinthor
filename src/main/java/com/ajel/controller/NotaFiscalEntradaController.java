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
import com.ajel.model.NotaFiscalEntrada;
import com.ajel.repository.NotaFiscalEntradaRepository;
import com.ajel.repository.filter.NotaFiscalEntradaFilter;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class NotaFiscalEntradaController {
     
    
    @Autowired
	private NotaFiscalEntradaRepository notaFiscalEntradaRepository;    


    
	@GetMapping("/notafiscalentrada")
	public List<NotaFiscalEntrada> getNotaFiscalEntrada(NotaFiscalEntradaFilter notaFiscalEntradaFilter) {		
        return notaFiscalEntradaRepository.pesquisar(notaFiscalEntradaFilter);
	}
	
	@PostMapping("/notafiscalentrada/numnota")
    public ResponseEntity<List<NotaFiscalEntrada>> getNotaFiscalEntradaByNumnota(@RequestBody NotaFiscalEntradaFilter filter)
            throws ResourceNotFoundException {
        List<NotaFiscalEntrada> NotaFiscalEntrada = null;
        NotaFiscalEntrada = notaFiscalEntradaRepository.pesquisar(filter);
                //.orElseThrow(() -> new ResourceNotFoundException("Produto not found for this id :: " + numnota));
        return ResponseEntity.ok().body(NotaFiscalEntrada);
    }

	@GetMapping("/notafiscalentrada/{numtransent}")
	public ResponseEntity<NotaFiscalEntrada> getNotaFiscalEntradaById(@PathVariable Long numtransent)
			throws ResourceNotFoundException {
		NotaFiscalEntrada notaFiscalEntrada = notaFiscalEntradaRepository.findById(numtransent)
				.orElseThrow(() -> new ResourceNotFoundException("NotaFiscalEntrada not found for this id :: " + numtransent));
		return ResponseEntity.ok().body(notaFiscalEntrada);
	}
	
	@PutMapping("/notafiscalentrada/dataCanhoto/{numtransent}/{obsnfcarreg}")
    public ResponseEntity<NotaFiscalEntrada> dataCanhoto(@PathVariable Long numtransent,
            @Valid @RequestBody NotaFiscalEntrada notaFiscalEntradaDetails) throws ResourceNotFoundException {
        NotaFiscalEntrada notaFiscalEntrada = notaFiscalEntradaRepository.findById(numtransent)
                .orElseThrow(() -> new ResourceNotFoundException("Data não pode ser inserida na nf com seguinte numtransents :: " + numtransent));
             
        notaFiscalEntrada.setCodfunclanc(null);

        final NotaFiscalEntrada updateNotaFiscalEntrada = notaFiscalEntradaRepository.save(notaFiscalEntrada);
        return ResponseEntity.ok(updateNotaFiscalEntrada);
        }
	//@PostMapping("/produto")
	
	//@PutMapping("/produto/{codprod}")
	
	// @DeleteMapping("/produto/{codprod}")



}
