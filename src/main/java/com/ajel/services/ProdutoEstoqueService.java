package com.ajel.services;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.ajel.controller.payloads.ProdutoEstoquePayload;
import com.ajel.repository.filter.ProdutoEstoqueFilter;

@Service
public class ProdutoEstoqueService {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public String getEstoqueProduto(){
		return 	"	SELECT" + 
		        "    a.codprod," + 
		        "    a.codfab," + 
		        "    a.CODFORNEC," + 
		        "    d.FORNECEDOR, " + 
		        "    a.CODMARCA," + 
		        "    b.MARCA,    " + 
		        "    DBMS_LOB.substr(a.DADOSTECNICOS, 3000)," + 
		        "    a.DTCADASTRO," + 
		        "    a.DTEXCLUSAO," + 
		        "    a.NBM," + 
		        "    a.RUA," + 
		        "    a.MODULO," + 
		        "    a.APTO," + 
		        "    a.NUMERO," + 
		        "    c.QTESTGER ," + 
		        "    (PKG_ESTOQUE.ESTOQUE_DISPONIVEL(a.CODPROD, c.CODFILIAL, 'V', NULL, 'S')) QTDISPONIVEL," +
		        "    c.Qtbloqueada,"+
		        "    c.qtindeniz , "+
		        "    c.CODFILIAL ," + 
		        "    c.DTULTENT ," + 
		        "    c.DTULTFAT " + 
		        "FROM " + 
		        "    PCPRODUT a," + 
		        "    PCMARCA b," + 
		        "    PCEST c," + 
		        "    PCFORNEC d " + 
		        " WHERE " + 
		        "        a.CODMARCA  = b.CODMARCA(+)" + 
		        "    AND a.CODPROD   = c.CODPROD" + 
		        "    AND a.CODFORNEC = d.CODFORNEC ";
	}
	
	public List<ProdutoEstoquePayload> getDadosDoResultSet(List<Object[]> results) {
		List<ProdutoEstoquePayload> pedidoResult = new ArrayList<>();	    
	    if (results != null) {
	    	for (Object[] objects : results) {
	    	    ProdutoEstoquePayload produtoEstoque = new ProdutoEstoquePayload();
	    		int i = 0;
	    		
	    		produtoEstoque.setCodprod(((BigDecimal) objects[i++]));
	    		produtoEstoque.setCodfab(((String) objects[i++]));
	    		produtoEstoque.setCodfornec(((BigDecimal) objects[i++]));
	    		produtoEstoque.setFornecedor(((String) objects[i++])); 
	    		produtoEstoque.setCodmarca(((BigDecimal) objects[i++]));
	    		produtoEstoque.setMarca(((String) objects[i++])); 
	    		produtoEstoque.setDadostecnicos(((String) objects[i++]));
	    		produtoEstoque.setDtcadastro(getLocalDateTime(objects[i++]));
	    		produtoEstoque.setDtexclusao(getLocalDateTime(objects[i++]));
	    		produtoEstoque.setNbm(((String) objects[i++]));
	    		produtoEstoque.setRua(((BigDecimal) objects[i++]));
	    		produtoEstoque.setModulo(((BigDecimal) objects[i++]));
	    		produtoEstoque.setApto(((BigDecimal) objects[i++]));
	    		produtoEstoque.setNumero(((BigDecimal) objects[i++]));
	    		produtoEstoque.setQtestger(((BigDecimal) objects[i++])); 
	    		produtoEstoque.setQtdisponivel(((BigDecimal) objects[i++]));
	    		produtoEstoque.setQtbloqueada(((BigDecimal) objects[i++]));
	    		produtoEstoque.setQtindeniz(((BigDecimal) objects[i++]));
	    		produtoEstoque.setCodfilial(((String) objects[i++])); 
	    		produtoEstoque.setDtultent(getLocalDateTime(objects[i++])); 
	    		produtoEstoque.setDtultfat(getLocalDateTime(objects[i++]));    		
	    		
	    		
	    			pedidoResult.add(produtoEstoque);
	    		}
	    }

	    return pedidoResult;
	}

	public List<ProdutoEstoquePayload> findAll() {
	    List<Object[]> results = entityManager.createNativeQuery(getEstoqueProduto())
	    		.getResultList();	    
	    return getDadosDoResultSet(results);
	}
	


    public List<ProdutoEstoquePayload> findByCodprod(ProdutoEstoqueFilter filter) {
        
        Query nativeQuery = entityManager.createNativeQuery(getEstoqueProduto() + " and a.codprod = :codprod ");
        nativeQuery.setParameter("codprod", filter.getCodprod());
                
        List<Object[]> results = nativeQuery.getResultList();
        return getDadosDoResultSet(results);
    }
    
	private Date getLocalDateTime(Object object) {
		if (object != null) {
			return Date.from(((Timestamp) object).toLocalDateTime().atZone(ZoneId.systemDefault()).toInstant());
		}
		return null;
	}


}