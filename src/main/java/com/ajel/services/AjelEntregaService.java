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
		return 	" SELECT    " +
		        "    pc.NUMNOTA,  " +
		        "    pc.codfilial,  " +
		        "    c.ESTCOB,  " +
		        "    c.CODCIDADE,  " +
		        "    cid.nomecidade,    " +
		        "    c.ENDERCOB ,  " +
		        "    pc.POSICAO ,  " +
		        "    pc.CODUSUR,  " +
		        "    u.NOME AS nomevendedor ,  " +
		        "    pc.DTFAT,  " +
		        "    pc.DTENTREGA,  " +
		        "    pc.CODFORNECFRETE,  " +
		        "    f.FORNECEDOR ,  " +
		        "    pc.CODMOTORISTA,  " +
		        "    mot.nome AS nomemotorista ,  " +
		        "    pc.CODCLI ,  " +
		        "    c.CLIENTE AS nomecliente,  " +
		        "    pc.OBS ,  " +
		        "    pc.OBS1,  " +
		        "    pc.OBSENTREGA1,  " +
		        "    pc.OBSENTREGA2 ,  " +
		        "    pc.OBSENTREGA3,    " +
		        "    pc.CODFUNCCONF,  " +
		        "    conf.nome AS nomeconferente ,  " +
		        "    pc.VLATEND ,  " +
		        "    pc.NUMVOLUME  " +
		        "  FROM  " +
		        "    pcpedc pc " +
		        "  inner    join PCCLIENT c     on pc.CODCLI = c.CODCLI  " +
		        "  inner    join PCUSUARI u     on pc.CODUSUR = u.CODUSUR " +
		        "  inner    join PCNFSAID nf    on pc.CODFILIAL = nf.CODFILIAL  AND pc.NUMNOTA = nf.NUMNOTA  " +
		        "                                                           AND nf.ESPECIE IN ('NF')  " +
		        "                                                           AND pc.DTFAT IS NOT null " +
		        "  left     join PCFORNEC f     on pc.CODFORNECFRETE = f.CODFORNEC " +
		        "  inner    join PCCIDADE cid   on c.CODCIDADE = cid.CODCIDADE  " +
		        "  left     join PCEMPR conf    on conf.matricula = pc.CODFUNCCONF " +
		        "  left     join PCEMPR mot     on mot.matricula = pc.CODMOTORISTA " +
		        "  WHERE pc.POSICAO IN ('F')  " ;
	}
	
	public List<AjelEntrega> getDadosDoResultSet(List<Object[]> results) {
		List<AjelEntrega> pedidoResult = new ArrayList<>();	    
	    if (results != null) {
	    	for (Object[] objects : results) {
	    	    AjelEntrega ajelEntrega = new AjelEntrega();
	    		int i = 0;
	    		
	    		
	    		ajelEntrega.setNumnota(((BigDecimal) objects[i++]));
	    		ajelEntrega.setCodfilial(((String) objects[i++]));
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
        
        Query nativeQuery = entityManager.createNativeQuery(getInfomacoesEntregaWinthor() + " AND pc.NUMNOTA = :numnota and pc.codfilial like :codfilial ");
        nativeQuery.setParameter("numnota" , filter.getNumnota()); 
        if(filter.getCodfilial() != "") {
            nativeQuery.setParameter("codfilial" , filter.getCodfilial()); 
        } else {
            nativeQuery.setParameter("codfilial" , "%%"); 
        }
         
       
        
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