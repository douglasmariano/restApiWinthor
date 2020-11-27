package com.example.controller;

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

import com.example.exception.ResourceNotFoundException;
import com.example.model.TabPedido;
import com.example.repository.TabPedidoRepository;
import com.example.repository.filter.TabPedidosFilter;

@RestController
@RequestMapping("/api/v1")
public class TabPedidoController {
	@Autowired
	private TabPedidoRepository tabPedidoRepository;

	@GetMapping("/tabpedidos")
	public ResponseEntity<List<TabPedido>> getAllTabPedidos(TabPedidosFilter tabPedidosFilter) {
		List<TabPedido> resultado = tabPedidoRepository.findAll();
		return ResponseEntity.ok().body(resultado);
		
	}

	@GetMapping("/tabpedidos/{NUMPED}")
	public ResponseEntity<TabPedido> getTabPedidoById(@PathVariable(value = "NUMPED") Long NUMPED)
			throws ResourceNotFoundException {
		TabPedido tabpedido = tabPedidoRepository.findById(NUMPED)
				.orElseThrow(() -> new ResourceNotFoundException("TabPedido not found for this id :: " + NUMPED));
		return ResponseEntity.ok().body(tabpedido);
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
	   public ResponseEntity <TabPedido> updateTabPedido(@PathVariable(value = "NUMPED") Long NUMPED,			  
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
	    public Map < String, Boolean > deleteTabPedido(@PathVariable(value = "NUMPED") Long NUMPED)
	    throws ResourceNotFoundException {
	        TabPedido tabPedido = tabPedidoRepository.findById(NUMPED)
	            .orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado com esse Numped :: " + NUMPED));

	        tabPedidoRepository.delete(tabPedido);
	        Map < String, Boolean > response = new HashMap < > ();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }

}