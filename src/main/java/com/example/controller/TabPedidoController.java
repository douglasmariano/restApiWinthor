package com.example.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.controller.payloads.PedidoPayload;
import com.example.exception.ResourceNotFoundException;
import com.example.model.Pedido;
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

	

	
	
	//@RequestMapping("/tabpedido")
	//public ResponseEntity<Pedido> getTabPedidoById(@RequestParam(value = "numped") BigDecimal NUMPED)
	//		throws ResourceNotFoundException {
	//	Pedido pedido = pedidoRepository.findById(NUMPED)
	//			.orElseThrow(() -> new ResourceNotFoundException("TabPedido not found for this id :: " + NUMPED));
	//	return ResponseEntity.ok().body(pedido);
	//}
	
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
	
	//@GetMapping("/tabpedidos/{NUMPED}")
	//public ResponseEntity<List<TabPedido>> getTabPedidoById(@PathVariable(value = "NUMPED") Long NUMPED)
	//		throws ResourceNotFoundException {
	//	List<TabPedido> resultado = tabPedidoRepository.findAll();
	//	return ResponseEntity.ok().body(resultado);
	//}
	
	@PostMapping("/tabpedidos")
	public TabPedido createTabPedido(@Valid @RequestBody TabPedido tabPedido) {
		return tabPedidoRepository.save(tabPedido);
	}

	@PutMapping("/tabpedidos/{NUMPED}")
	   public ResponseEntity <TabPedido> updateTabPedido(@PathVariable(value = "NUMPED") BigDecimal NUMPED,			  
			@Valid @RequestBody TabPedido tabPedidoDetails) throws ResourceNotFoundException{
		  	TabPedido tabPedido = tabPedidoRepository.findById(NUMPED).orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado com esse Numped :: "+ NUMPED));
			tabPedido.setCODFUNCBALCAO(tabPedidoDetails.getCODFUNCBALCAO());
			tabPedido.setCODFUNCPACOTE(tabPedidoDetails.getCODFUNCPACOTE());
			tabPedido.setCODFUNCSEP(tabPedidoDetails.getCODFUNCSEP());
			tabPedido.setDATACHEGADACLI(tabPedidoDetails.getDATACHEGADACLI());
			tabPedido.setDATAFIMBALCAO(tabPedidoDetails.getDATAFIMBALCAO());
			tabPedido.setDATAINICIOBALCAO(tabPedidoDetails.getDATAINICIOBALCAO());
			tabPedido.setDATAINICIOSEP(tabPedidoDetails.getDATAINICIOSEP());
			tabPedido.setDATAPACOTE(tabPedidoDetails.getDATAPACOTE());
			tabPedido.setESTOQUE(tabPedidoDetails.getESTOQUE());
			tabPedido.setFINALIZADO(tabPedidoDetails.getFINALIZADO());
			tabPedido.setORIGINAL(tabPedidoDetails.getORIGINAL());
			tabPedido.setPAINEL(tabPedidoDetails.getPAINEL());
			tabPedido.setRETIRA(tabPedidoDetails.getRETIRA());
			tabPedido.setRETIRANTE(tabPedidoDetails.getRETIRANTE());
			tabPedido.setSTATUS(tabPedidoDetails.getSTATUS());			
			
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