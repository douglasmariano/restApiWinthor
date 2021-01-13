package com.example.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controller.payloads.PedidoPayload;
import com.example.exception.ResourceNotFoundException;
import com.example.model.TabPedido;
import com.example.repository.PedidoRepository;
import com.example.repository.TabPedidoRepository;
import com.example.repository.filter.TabPedidosFilter;
import com.example.services.TabPedidoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class TabPedidoController {
	@Autowired
	private TabPedidoRepository tabPedidoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private TabPedidoService tabPedidoService;

	@PostMapping("/tabpedido") // @RequestParam(value = "numped") BigDecimal NUMPED
	public ResponseEntity<List<PedidoPayload>> getTabPedidoById(@RequestBody TabPedidosFilter filter)
			throws ResourceNotFoundException {
		List<PedidoPayload> pedido = null;
		if (filter != null && !StringUtils.isEmpty(filter.getNumped())) {
			pedido = tabPedidoService.findById(filter.getNumped());	
		} else if (filter != null && (filter.getDataPedidoDe() != null || filter.getDataPedidoAte() != null || filter.getNomeCliente() != null || filter.getNomeVendedor() != null)) {
			pedido = tabPedidoService.findByFiltro(filter);	
		} else {
			pedido = tabPedidoService.findAll();
		}
		
		return ResponseEntity.ok().body(pedido);
	}
	
	
	
	@GetMapping("/tabpedidos")
	public ResponseEntity<List<PedidoPayload>> getAllTabPedidos() {
		List<PedidoPayload> resultado = tabPedidoService.findAll();
		return ResponseEntity.ok().body(resultado);
		
	}	
	
	@PostMapping("/tabpedidos")
	public TabPedido createTabPedido(@Valid @RequestBody TabPedido tabPedido) {
		return tabPedidoRepository.save(tabPedido);
	}

	@PutMapping("/tabpedidos/{numped}")
	   public ResponseEntity <TabPedido> updateTabPedido(@PathVariable(value = "numped") BigDecimal numped,			  
			@Valid @RequestBody TabPedido tabPedidoDetails) throws ResourceNotFoundException{
		  	TabPedido tabPedido = tabPedidoRepository.findById(numped).orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado com esse Numped :: "+ numped));
			tabPedido.setCodfuncbalcao(tabPedidoDetails.getCodfuncbalcao());
			tabPedido.setCodfuncpacote(tabPedidoDetails.getCodfuncpacote());
			tabPedido.setCodfuncbalcao(tabPedidoDetails.getCodfuncbalcao());
			tabPedido.setDatachegadacli(tabPedidoDetails.getDatachegadacli());
			tabPedido.setDatafimbalcao(tabPedidoDetails.getDatafimbalcao());
			tabPedido.setDatafimbalcao(tabPedidoDetails.getDatafimbalcao());
			tabPedido.setDatafimsep(tabPedidoDetails.getDatafimsep());
			tabPedido.setCodfuncpacote(tabPedidoDetails.getCodfuncpacote());
			tabPedido.setEstoque(tabPedidoDetails.getEstoque());
			tabPedido.setFinalizado(tabPedidoDetails.getFinalizado());
			tabPedido.setOriginal(tabPedidoDetails.getOriginal());
			tabPedido.setPainel(tabPedidoDetails.getPainel());
			tabPedido.setRetira(tabPedidoDetails.getRetira());
			tabPedido.setCliente(tabPedidoDetails.getCliente());
			tabPedido.setStatus(tabPedidoDetails.getStatus());			
			
		  	final TabPedido updateTabPedido = tabPedidoRepository.save(tabPedido);
		  	return ResponseEntity.ok(updateTabPedido);
		   
	   }
	
	 @DeleteMapping("/tabpedidos/{NUMPED}")
	    public Map < String, Boolean > deleteTabPedido(@PathVariable(value = "NUMPED") BigDecimal NUMPED)
	    throws ResourceNotFoundException {
	        TabPedido tabPedido = tabPedidoRepository.findById(NUMPED)
	            .orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado com esse Numped :: " + NUMPED));

	        tabPedidoRepository.delete(tabPedido);
	        Map < String, Boolean > response = new HashMap < > ();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }

}