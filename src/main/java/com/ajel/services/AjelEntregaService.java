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

import com.ajel.model.AjelEntrega;
import com.ajel.repository.filter.AjelEntregaFilter;

@Service
public class AjelEntregaService {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public String getInfomacoesEntregaWinthor(){
		return 	" SELECT   " +
		        "   pc.NUMNOTA, " +
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
		       " AND pc.DTENTREGA > SYSDATE - 152 " +
		       " AND nf.ESPECIE LIKE ('NF')	";	    
		        
	}
	
	public List<AjelEntrega> getDadosDoResultSet(List<Object[]> results) {
		List<AjelEntrega> pedidoResult = new ArrayList<>();	    
	    if (results != null) {
	    	for (Object[] objects : results) {
	    	    AjelEntrega ajelEntrega = new AjelEntrega();
	    		int i = 0;
	    		
	    		
	    		ajelEntrega.setNumnota(((BigDecimal) objects[i++]));
	            ajelEntrega.setEstcob(((String) objects[i++])); 
	            ajelEntrega.setCodcidade(((BigDecimal) objects[i++]));
	            ajelEntrega.setNomecidade(((String) objects[i++]));
	            ajelEntrega.setEndercob(((String) objects[i++])); 
	    		ajelEntrega.setPosicao(((String) objects[i++])); 
	            ajelEntrega.setCodusur(((BigDecimal) objects[i++])); 
	            ajelEntrega.setNomevendedor(((String) objects[i++]));
	            ajelEntrega.setDtfat(getLocalDateTime(objects[i++]));
	            ajelEntrega.setDtentrega(getLocalDateTime(objects[i++]));
	            ajelEntrega.setCodfornecfrete(((BigDecimal) objects[i++])); 
	            ajelEntrega.setFornecedor(((String) objects[i++])); 
	            ajelEntrega.setCodmotorista(((BigDecimal) objects[i++])); 
	            ajelEntrega.setNomemotorista(((String) objects[i++])); 
	            ajelEntrega.setCodcli(((BigDecimal) objects[i++])); 
	            ajelEntrega.setNomecliente(((String) objects[i++])); 
	            ajelEntrega.setObs(((String) objects[i++])); 
	            ajelEntrega.setObs1(((String) objects[i++])); 
	            ajelEntrega.setObsentrega1(((String) objects[i++])); 
                ajelEntrega.setObsentrega2(((String) objects[i++])); 
                ajelEntrega.setObsentrega3(((String) objects[i++]));
                ajelEntrega.setCodfuncconf(((BigDecimal) objects[i++]));
                ajelEntrega.setNomeconf(((String) objects[i++])); 
                ajelEntrega.setVlatend(((BigDecimal) objects[i++])); 
                ajelEntrega.setNumvolume(((BigDecimal) objects[i++]));         
	           
	    		
	    			pedidoResult.add(ajelEntrega);
	    		}
	    }

	    return pedidoResult;
	}

	public List<AjelEntrega> findAll() {
	    List<Object[]> results = entityManager.createNativeQuery(getInfomacoesEntregaWinthor())
	    		.getResultList();	    
	    return getDadosDoResultSet(results);
	}
	


    public List<AjelEntrega> findByNumnota(AjelEntregaFilter filter) {
        
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