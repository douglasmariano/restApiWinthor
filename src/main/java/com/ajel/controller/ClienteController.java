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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ajel.exception.ResourceNotFoundException;
import com.ajel.model.Cliente;
import com.ajel.repository.ClienteRepository;
import com.ajel.repository.filter.ClienteFilter;
import com.ajel.services.ClienteService;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
    private ClienteService clienteService;

	@GetMapping("/clientes")
	public List<Cliente> getAllTabPedidos() {
		return clienteRepository.findAll();
	}

	@GetMapping("/clientes/{codigoCliente}")
	public ResponseEntity<Cliente> getTabPedidoById(@PathVariable(value = "codigoCliente") Long codigoCliente)
			throws ResourceNotFoundException {
		Cliente cliente = clienteRepository.findById(codigoCliente)
				.orElseThrow(() -> new ResourceNotFoundException("cliente not found for this id :: " + codigoCliente));
		return ResponseEntity.ok().body(cliente);
	}
	
	@GetMapping("/clientes/telefone")
    public ResponseEntity<List<Cliente>> getCLienteByTelefones(@RequestParam(value="telefone", required=true)  String telefone)
            throws ResourceNotFoundException {
	    List<Cliente> clientes = null;        
        clientes = clienteService.findByTelefone(telefone);  
        return ResponseEntity.ok().body(clientes);
    }
	
	@PostMapping("/clientes")
	public Cliente createTabPedido(@Valid @RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@PostMapping("/clientes/telefone") // @RequestParam(value = "numped") BigDecimal NUMPED
    public ResponseEntity<List<Cliente>> getCLienteByTelefone(@RequestBody ClienteFilter filter)
            throws ResourceNotFoundException {
        List<Cliente> clientes = null;        
        clientes = clienteService.findByFiltro(filter);       

        return ResponseEntity.ok().body(clientes);
    }

	@PutMapping("/clientes/{codigoCliente}")
	   public ResponseEntity <Cliente> updateTabPedido(@PathVariable(value = "codigoCliente") Long codigoCliente,			  
			@Valid @RequestBody Cliente clienteDetails) throws ResourceNotFoundException{
		  	Cliente cliente = clienteRepository.findById(codigoCliente).orElseThrow(() -> new ResourceNotFoundException("cliente não encontrado com esse Numped :: "+ codigoCliente));
			cliente.setCodigoCliente(clienteDetails.getCodigoCliente());
			cliente.setNomeCliente(clienteDetails.getNomeCliente());
			
			
			final Cliente updateCliente = clienteRepository.save(cliente);
		  	return ResponseEntity.ok(updateCliente);
		   
	   }
	
	 @DeleteMapping("/clientes/{codigoCliente}")
	    public Map < String, Boolean > deleteVendedor(@PathVariable(value = "codigoCliente") Long codigoCliente)
	    throws ResourceNotFoundException {
	        Cliente cliente = clienteRepository.findById(codigoCliente)
	            .orElseThrow(() -> new ResourceNotFoundException("cliente não encontrado com esse Numped :: " + codigoCliente));

	        clienteRepository.delete(cliente);
	        Map < String, Boolean > response = new HashMap < > ();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }


}
