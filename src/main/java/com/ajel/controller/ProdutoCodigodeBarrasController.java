package com.ajel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajel.controller.payloads.ProdutoCodigoDeBarrasPayload;
import com.ajel.exception.ResourceNotFoundException;
import com.ajel.model.Produto;
import com.ajel.repository.ProdutoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class ProdutoCodigodeBarrasController {
	@Autowired
    private ProdutoRepository produtoRepository;
	
    /*
     * @PutMapping("/produtocodigodebarras/{numped}")
     * public ResponseEntity<TabPedido> updateTabPedido(@PathVariable(value = "numped") BigDecimal numped,
     * 
     * @Valid @RequestBody TabPedido tabPedidoDetails) throws ResourceNotFoundException {
     * TabPedido tabPedido = produtoRepository.findById(numped)
     * .orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado com esse Numped :: " + numped));
     * tabPedido.setCodfuncbalcao(tabPedidoDetails.getCodfuncbalcao());
     * tabPedido.setCodfuncpacote(tabPedidoDetails.getCodfuncpacote());
     * tabPedido.setCodfuncbalcao(tabPedidoDetails.getCodfuncbalcao());
     * tabPedido.setDatachegadacli(tabPedidoDetails.getDatachegadacli());
     * tabPedido.setDatafimbalcao(tabPedidoDetails.getDatafimbalcao());
     * tabPedido.setDatafimbalcao(tabPedidoDetails.getDatafimbalcao());
     * tabPedido.setDatafimsep(tabPedidoDetails.getDatafimsep());
     * tabPedido.setCodfuncpacote(tabPedidoDetails.getCodfuncpacote());
     * tabPedido.setEstoque(tabPedidoDetails.getEstoque());
     * tabPedido.setFinalizado(tabPedidoDetails.getFinalizado());
     * tabPedido.setOriginal(tabPedidoDetails.getOriginal());
     * tabPedido.setPainel(tabPedidoDetails.getPainel());
     * tabPedido.setRetira(tabPedidoDetails.getRetira());
     * tabPedido.setCliente(tabPedidoDetails.getCliente());
     * tabPedido.setStatus(tabPedidoDetails.getStatus());
     * 
     * final TabPedido updateTabPedido = produtoRepository.save(tabPedido);
     * return ResponseEntity.ok(updateTabPedido);
     * 
     * }
     */
	
	@PutMapping("/produtocodigodebarras/{codprod}")
    public ResponseEntity<Produto> updatecodigoDeBarraProduto(@PathVariable(value = "codprod") Long codprod,           
         @Valid @RequestBody ProdutoCodigoDeBarrasPayload estoqueCaboDetails) throws ResourceNotFoundException{
	     Produto produto = produtoRepository.findById(codprod).orElseThrow(() -> new ResourceNotFoundException("Produto nao encontrado no codigo :: "+ codprod));
         produto.setCodprod(estoqueCaboDetails.getCodprod());
         produto.setCodauxiliar(estoqueCaboDetails.getCodauxiliar());
         
         final Produto updateEstoqueCabo = produtoRepository.save(produto);
         return ResponseEntity.ok(updateEstoqueCabo);
        
    }

    /*
     * @DeleteMapping("/produtocodigodebarras/{NUMPED}")
     * public Map<String, Boolean> deleteTabPedido(@PathVariable(value = "NUMPED") BigDecimal NUMPED)
     * throws ResourceNotFoundException {
     * TabPedido tabPedido = produtoRepository.findById(NUMPED)
     * .orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado com esse Numped :: " + NUMPED));
     * 
     * produtoRepository.delete(tabPedido);
     * Map<String, Boolean> response = new HashMap<>();
     * response.put("deleted", Boolean.TRUE);
     * return response;
     * }
     */

}