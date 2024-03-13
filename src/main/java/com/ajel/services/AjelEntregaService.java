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

import com.ajel.model.Entrega;
import com.ajel.repository.filter.AjelEntregaFilter;

@Service
public class AjelEntregaService {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public String getInfomacoesEntregaWinthor(){
		return 	" SELECT   " +
		        "   pc.NUMNOTA, " +
		        "   pc.CODFILIAL, " +
		        "   c.ESTCOB, " +
		        "   c.CODCIDADE, " +
		        "   (SELECT NOMECIDADE FROM PCCIDADE  WHERE CODCIDADE = c.CODCIDADE) AS NOMECIDADE, " +
		        "   c.ENDERCOB , " +
		        "   pc.POSICAO , " +
		        "   pc.CODUSUR, " +
		        "   u.NOME AS nomevendedor , " +
		        "   pc.DTFAT, " +
		        "   pc.DTENTREGA, " +
		        "   pc.CODFORNECFRETE, " +
		        "   f.FORNECEDOR , " +
		        "   pc.CODMOTORISTA, " +
		        "       (SELECT " +
		        "       nome " +
		        "   FROM " +
		        "       PCEMPR " +
		        "   WHERE " +
		        "       MATRICULA = pc.CODMOTORISTA) AS nomemotorista , " +
		        "   pc.CODCLI , " +
		        "   c.CLIENTE AS nomecliente, " +
		        "   pc.OBS , " +
		        "   pc.OBS1, " +		        
		        "   pc.OBSENTREGA1, " +
		        "   pc.OBSENTREGA2 , " +
		        "   pc.OBSENTREGA3,   " +
		        "       pc.CODFUNCCONF, " +
		        "   (SELECT " +
		        "       nome " +
		        "   FROM " +
		        "       PCEMPR " +
		        "   WHERE " +
		        "       MATRICULA = pc.CODFUNCCONF) AS nomeConf , " +
		        "   pc.VLATEND , " +
		        "   pc.NUMVOLUME " +		        
		        " FROM " +
		        " pcpedc pc " +
		        " inner JOIN PCUSUARI u ON pc.CODUSUR = u.CODUSUR  " +
		        " inner JOIN PCCLIENT c ON pc.CODCLI = c.CODCLI " +
		        " inner jOIN PCNFSAID nf ON pc.NUMNOTA = nf.NUMNOTA and pc.CODFILIAL = nf.CODFILIAL " + 
		        " left JOIN PCFORNEC f ON pc.CODFORNECFRETE = f.CODFORNEC " +
		   " WHERE   " +		       
		       " pc.POSICAO IN ('F') " +
		       " AND pc.DTENTREGA > SYSDATE - 250 " +
		       " AND nf.ESPECIE LIKE ('NF')	";	    
		        
	}
	
	public List<Entrega> getDadosDoResultSet(List<Object[]> results) {
		List<Entrega> pedidoResult = new ArrayList<>();	    
	    if (results != null) {
	    	for (Object[] objects : results) {
	    	    Entrega entrega = new Entrega();
	    		int i = 0;
	    		
	    		
	    		entrega.setNumnota(((BigDecimal) objects[i++]));
	    		entrega.setCodfilial(((String) objects[i++]));
	            entrega.setEstcob(((String) objects[i++])); 
	            entrega.setCodcidade(((BigDecimal) objects[i++]));
	            entrega.setNomecidade(((String) objects[i++]));
	            entrega.setEndercob(((String) objects[i++])); 
	    		entrega.setPosicao(((String) objects[i++])); 
	            entrega.setCodusur(((BigDecimal) objects[i++])); 
	            entrega.setNomevendedor(((String) objects[i++]));
	            entrega.setDtfat(getLocalDateTime(objects[i++]));
	            entrega.setDtentrega(getLocalDateTime(objects[i++]));
	            entrega.setCodfornecfrete(((BigDecimal) objects[i++])); 
	            entrega.setFornecedor(((String) objects[i++])); 
	            entrega.setCodmotorista(((BigDecimal) objects[i++])); 
	            entrega.setNomemotorista(((String) objects[i++])); 
	            entrega.setCodcli(((BigDecimal) objects[i++])); 
	            entrega.setNomecliente(((String) objects[i++])); 
	            entrega.setObs(((String) objects[i++])); 
	            entrega.setObs1(((String) objects[i++])); 
	            entrega.setObsentrega1(((String) objects[i++])); 
                entrega.setObsentrega2(((String) objects[i++])); 
                entrega.setObsentrega3(((String) objects[i++]));
                entrega.setCodfuncconf(((BigDecimal) objects[i++]));
                entrega.setNomeconf(((String) objects[i++])); 
                entrega.setVlatend(((BigDecimal) objects[i++])); 
                entrega.setNumvolume(((BigDecimal) objects[i++]));         
	           
	    		
	    			pedidoResult.add(entrega);
	    		}
	    }

	    return pedidoResult;
	}

	public List<Entrega> findAll() {
	    List<Object[]> results = entityManager.createNativeQuery(getInfomacoesEntregaWinthor())
	    		.getResultList();	    
	    return getDadosDoResultSet(results);
	}
	


    public List<Entrega> findByNumnota(AjelEntregaFilter filter) {
        
        Query nativeQuery = entityManager.createNativeQuery(getInfomacoesEntregaWinthor() + " AND pc.NUMNOTA = :numnota ORDER BY pc.DTENTREGA DESC");
        nativeQuery.setParameter("numnota", filter.getNumnota());
                
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