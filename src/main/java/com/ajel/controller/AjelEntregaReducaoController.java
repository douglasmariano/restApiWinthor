package com.ajel.controller;

import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.bind.annotation.RestController;

import com.ajel.exception.ResourceNotFoundException;
import com.ajel.model.EntregaReducao;
import com.ajel.model.EntregaReducaoPK;
import com.ajel.repository.AjelEntregaReducaoRepository;
import com.ajel.repository.filter.AjelEntregaReducaoFilter;
import com.ajel.services.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class AjelEntregaReducaoController {

    @Autowired
    private AjelEntregaReducaoRepository ajelEntregaReducaoRepository;    
    
    
    @Autowired
    private UserService userService;


    public String getName(Authentication authentication, Principal principal) {
        return "";
    }
    
    
    @GetMapping("/ajelentregareducao/todos")
    public List<EntregaReducao> getAllEstoques() {
        List<EntregaReducao> e = ajelEntregaReducaoRepository.findAll();
        return e;

    }

    @GetMapping("/ajelentregareducao/buscaget/{codentrega}/{numnota}/{codfilial}")
    public ResponseEntity<EntregaReducao> getAjelEntregaReducaoById(@PathVariable Long codentrega, @PathVariable Long numnota, @PathVariable Long codfilial)
            throws ResourceNotFoundException {
        EntregaReducaoPK id = new EntregaReducaoPK(codentrega, numnota,codfilial);
        EntregaReducao entregaReducao = ajelEntregaReducaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Codigo de Barras não encontrado no codigo: " + id));
        return ResponseEntity.ok().body(entregaReducao);
    }

    @PostMapping("/ajelentregareducao/pesquisar") //
    public ResponseEntity<List<EntregaReducao>> getAjelEntregaReducao(@RequestBody AjelEntregaReducaoFilter filter)
            throws ResourceNotFoundException {
        List<EntregaReducao> entregaReducao = null;

        Long numnota = filter.getNumnota();
        Long codentrega = filter.getCodentrega();
        if (codentrega != null ) {
            entregaReducao = ajelEntregaReducaoRepository.pesquisar(filter);
        } else if (numnota != null ) {
            entregaReducao = ajelEntregaReducaoRepository.pesquisar(filter);
        } else {
            EntregaReducaoPK id = new EntregaReducaoPK(filter.getCodentrega(), filter.getCodfilial(), numnota);
            Optional<EntregaReducao> ajelEntregaReducaoOp = ajelEntregaReducaoRepository.findById(id);

            if (ajelEntregaReducaoOp.isPresent()) {
                entregaReducao.add(ajelEntregaReducaoOp.get());
            }
        }
        return ResponseEntity.ok().body(entregaReducao);
    }

    @PostMapping("/ajelentregareducao/novo")
    public EntregaReducao novoAjelEntregaReducao(@Valid @RequestBody EntregaReducao entregaReducao, Authentication authentication, Principal principal) {
        Long userIdByMatricula = userService.getUserIdByMatricula(principal.getName());
        entregaReducao.setCodusur(userIdByMatricula);
        entregaReducao.setDtincluido(new Date());
        return ajelEntregaReducaoRepository.save(entregaReducao);
    }

    
    @PutMapping("/ajelentregareducao/excluir/{codentrega}/{numnota}")
    public ResponseEntity<EntregaReducao> atualizandoAjelEntregaReducaoExcluir(@PathVariable Long codentrega, @PathVariable Long numnota,
              Authentication authentication, Principal principal) throws ResourceNotFoundException {
        EntregaReducao entregaReducao = ajelEntregaReducaoRepository.findByIdCodentregaAndIdNumnotaAndDtExcluidoIsNull(codentrega,numnota);
               
     // Verifica se encontrou uma EntregaReducao válida
        if (entregaReducao != null) {
            Long userIdByMatricula = userService.getUserIdByMatricula(principal.getName());
            
            // Atualiza os campos
          
            
            System.out.println("DtIncluido: " + entregaReducao.getDtincluido() +
                               " DtExcluido: " + entregaReducao.getDtexcluido() +
                               " CodUsur: " + entregaReducao.getCodusur() +
                               " CodEntrega: " + entregaReducao.getId().getCodentrega() +
                               " Codfilial: " + entregaReducao.getId().getCodfilial() +
                               " Numnota: " + entregaReducao.getId().getNumnota());
            
            // Salva a EntregaReducao atualizada apenas se dtexcluido for nulo
            if (entregaReducao.getDtexcluido() == null) {
                entregaReducao.setDtexcluido(new Date());
                entregaReducao.setCodusur(userIdByMatricula);
                
                final EntregaReducao updateEstoque = ajelEntregaReducaoRepository.save(entregaReducao);
                return ResponseEntity.ok(updateEstoque);
            } else {
                // Retorna um ResponseEntity indicando que a operação não pode ser realizada porque a EntregaReducao já está excluída
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
        } else {
            // Retorna um ResponseEntity indicando que a EntregaReducao não foi encontrada
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/ajelentregareducao/delete/{codentrega}/{numnota}")
    public Map<String, Boolean> deletandoAjelEntregaReducao(@PathVariable Long codentrega, @PathVariable Long numnota )
            throws ResourceNotFoundException {
        EntregaReducao entregaReducao = ajelEntregaReducaoRepository.findByIdCodentregaAndIdNumnotaAndDtExcluidoIsNull(codentrega,numnota);

        ajelEntregaReducaoRepository.delete(entregaReducao);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
