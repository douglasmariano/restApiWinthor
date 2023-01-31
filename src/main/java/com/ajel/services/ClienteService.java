package com.ajel.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.ajel.model.Cliente;
import com.ajel.repository.filter.ClienteFilter;

@Service
public class ClienteService {

	@PersistenceContext
	private EntityManager entityManager;
	
	public String getTelefoneCliente(String andWhere) {
		return  "SELECT "+
		        "codcli, "+
		        "CLIENTE, "+
		       // "regexp_replace(REGEXP_REPLACE(CGCENT , '[^A-Z,^0-9,^_]', '') , '([0-9]{3})([0-9]{5})([0-9]{2})', '\\1*****\\3'), "+
		       "CASE WHEN LENGTH(CGCENT) <= 14 "+
		       "    THEN regexp_replace(REGEXP_REPLACE(CGCENT , '[^A-Z,^0-9,^_]', '') , '([0-9]{3})([0-9]{5})([0-9]{2})', '\\1*****\\3')    ELSE CGCENT " +
		        "    END AS CGCENT,"+ 
		       "MUNICCOB, "+
		        "ESTCOB, "+
		        "TELCOB, "+
		        "TELENT , "+
		        "TELCOM , "+
		        "TELCELENT, "+
		        "BLOQUEIO, " +
		        "BLOQUEIOSEFAZ, " +
		        "DTCADASTRO, "+
		        "DTULTALTER "+
		    "FROM "+
		        "pcclient "+
		    "WHERE "+
		        "REGEXP_REPLACE(TELCOB, '[^A-Z,^0-9,^_]', '') LIKE "+ andWhere +
		        "OR REGEXP_REPLACE(TELENT, '[^A-Z,^0-9,^_]', '') LIKE "+ andWhere +
		        "OR REGEXP_REPLACE(TELCOM, '[^A-Z,^0-9,^_]', '') LIKE "+ andWhere +
		        "OR REGEXP_REPLACE(TELCELENT, '[^A-Z,^0-9,^_]', '') LIKE "+ andWhere;	}
	
	
	public List<Cliente> getDadosDoResultSet(List<Object[]> results) {
		List<Cliente> clienteResult = new ArrayList<>();
		ClienteFilter clientefilter = new ClienteFilter();
	    if (results != null) {
	    	for (Object[] objects : results) {
	    	    Cliente cliente = new Cliente();
	    		int i = 0;
	    		
	    		cliente.setCodigoCliente((BigDecimal) objects[i++]);
	    		cliente.setNomeCliente((String) objects[i++]);
	    		cliente.setCpfcnpj((String) objects[i++]);
	    		cliente.setMuniccob((String) objects[i++]);
	    		cliente.setEstcob((String) objects[i++]);
	    		cliente.setTelcob((String) objects[i++]);
	    		cliente.setTelent((String) objects[i++]);
	    		cliente.setTelcom((String) objects[i++]);
	    		cliente.setTelcelent((String) objects[i++]);
	    		cliente.setBloqueio((String) objects[i++]);
	    		cliente.setBloqueiosefaz((String) objects[i++]);
	    		cliente.setDtcadastro((Date) objects[i++]);
	    		cliente.setDtultalt((Date) objects[i++]);
	    		
	    		clienteResult.add(cliente);
	    		
			}
	    }

	    return clienteResult;
	}



	public List<Cliente> findByFiltro(ClienteFilter filter) {
		String andWhere = "";		
		andWhere += ":telefone ";
		
		Query nativeQuery = entityManager.createNativeQuery(getTelefoneCliente(andWhere));
		nativeQuery.setParameter("telefone",filter.getTelefone());
		
		List<Object[]> results = nativeQuery.getResultList();
	    return getDadosDoResultSet(results);
	}
	
	public List<Cliente> findByTelefone(String filter) {
        String andWhere = "";       
        andWhere += ":telefone ";
        
        Query nativeQuery = entityManager.createNativeQuery(getTelefoneCliente(andWhere));
        nativeQuery.setParameter("telefone",filter);
        
        List<Object[]> results = nativeQuery.getResultList();
        return getDadosDoResultSet(results);
    }
}