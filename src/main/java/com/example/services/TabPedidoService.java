package com.example.services;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.example.controller.payloads.PedidoPayload;
import com.example.repository.filter.TabPedidosFilter;

@Service
public class TabPedidoService {

	@PersistenceContext
	private EntityManager entityManager;
	
	public String getConsulta(String andWhere) {
		return " select REL.NUMPED, " + 
		   	       "       REL.nome, " + 
		   	       "       REL.CLIENTE, " + 
		   	       "       REL.DATAPEDIDO, " + 
		   	       "       REL.DATAEMISSAOMAPA,	 " + 
		   	       "       REL.DATAINICIOSEP, " + 
		   	       "       REL.DATAFIMSEP, " + 
		   	       "       REL.DATACHEGADACLI, " + 
		   	       "       REL.CODFUNCSEP, " + 
		   	       "       REL.DATAFIMBALCAO, " + 
		   	       "       REL.CODFUNCBALCAO, " + 
		   	       "       sysdate DATAATUAL, " + 
		   	       "       lpad(Trunc(mod(REL.AGUARDSEP*24, 60)),2,0) || ':' || " + 
		   	       "       lpad(Trunc(mod(REL.AGUARDSEP*24*60, 60)),2,0) || ':' || " + 
		   	       "       lpad(Trunc(mod(REL.AGUARDSEP*24*60*60, 60)),2,0) AGUARDSEP, " + 
		   	       "       lpad(Trunc(mod(REL.EMSEPARACAO*24, 60)),2,0) || ':' || " + 
		   	       "       lpad(Trunc(mod(REL.EMSEPARACAO*24*60, 60)),2,0) || ':' || " + 
		   	       "       lpad(Trunc(mod(REL.EMSEPARACAO*24*60*60, 60)),2,0) EMSEPARACAO, " + 
		   	       "       lpad(Trunc(mod(REL.EMCONFERENCIA*24, 60)),2,0) || ':' || " + 
		   	       "       lpad(Trunc(mod(REL.EMCONFERENCIA*24*60, 60)),2,0) || ':' || " + 
		   	       "       lpad(Trunc(mod(REL.EMCONFERENCIA*24*60*60, 60)),2,0) EMCONFERENCIA, " + 
		   	       "       lpad(Trunc(mod(REL.TEMPODECOR*24, 60)),2,0) || ':' || " + 
		   	       "       lpad(Trunc(mod(REL.TEMPODECOR*24*60, 60)),2,0) || ':' || " + 
		   	       "       lpad(Trunc(mod(REL.TEMPODECOR*24*60*60, 60)),2,0) TEMPODECOR, " + 
		   	       "       case when REL.STATUS in ('R','B') then 'Aguardando Separação' " + 
		   	       "             when REL.STATUS in ('L','E') then 'Em Separação' " + 
		   	       "             when REL.STATUS = 'F' then 'Conferência' " + 
		   	       "             when REL.STATUS = 'H' then 'Procure o Vendedor' " + 
		   	       "             when REL.STATUS = 'V' then 'Procure o Vendedor' " + 
		   	       "             when REL.STATUS = 'X' then 'Dirija-se ao Caixa' " + 
		   	       "             when REL.STATUS = 'T' then 'Vendedor Alterando Pedido' " + 
		   	       "             when REL.STATUS = 'P' then 'Pacote' " + 
		   	       "       end POSICAO, " + 
		   	       "       case when REL.STATUS in ('L','E') then 1 " + 
		   	       "             when REL.STATUS in ('R','B') then 2 " + 
		   	       "             when REL.STATUS = 'F' then 0 " + 
		   	       "             when REL.STATUS = 'X' then 0 " + 
		   	       "             when REL.STATUS = 'P' then 4 " + 
		   	       "             when REL.STATUS = 'T' then 3 " + 
		   	       "             when REL.STATUS = 'H' then 0 " + 
		   	       "             when REL.STATUS = 'V' then 0 " + 
		   	       "       end ORDEM, " + 
		   	       "       REL.PAINEL " + 
		   	       "   from (select P.NUMPED, " + 
		   	       "               P.CODUSUR, " + 
		   	       "               P.STATUS, " + 
		   	       "               (select U.NOME from PCUSUARI U where U.CODUSUR = P.CODUSUR) nome, " + 
		   	       "               (Case When REPLACE(REPLACE(REPLACE(V.CPF,'.',''),'/',''),'-','') = REPLACE(REPLACE(REPLACE(C.CGCENT,'.',''),'/',''),'-','') " +
		   	       "                       Then (Select T.OBS2 From PCPEDC T Where T.NUMPED = P.NUMPED) " + 
		   	       "                          Else C.CLIENTE " + 
		   	       "               End) CLIENTE, " + 
		   	       "               Nvl(P.DATACHEGADACLI,P.DATAPEDIDO) DATAPEDIDO, " + 
		   	       "               Nvl(P.DATACHEGADACLI,P.DATAPEDIDO) DATAEMISSAOMAPA, " + 
		   	       "               P.DATACHEGADACLI, " + 
		   	       "               P.DATAINICIOSEP DATAINICIOSEP, " + 
		   	       "               P.CODFUNCSEP, " + 
		   	       "               P.DATAFIMSEP DATAFIMSEP, " + 
		   	       "               P.DATAFIMBALCAO DATAFIMBALCAO, " + 
		   	       "               P.CODFUNCBALCAO CODFUNCBALCAO, " + 
		   	       "               CASE when P.DATAINICIOSEP Is Null Then (Sysdate - Nvl(P.DATACHEGADACLI,P.DATAPEDIDO)) " + 
		   	       "                     else (P.DATAINICIOSEP - Nvl(P.DATACHEGADACLI,P.DATAPEDIDO)) " + 
		   	       "               end AGUARDSEP, " + 
		   	       "               CASE when P.DATAINICIOSEP Is Null Then (Sysdate - Sysdate) " + 
		   	       "                     when P.DATAFIMSEP    Is Null Then (sysdate - P.DATAINICIOSEP) " + 
		   	       "                     else (P.DATAFIMSEP - P.DATAINICIOSEP) " + 
		   	       "               end EMSEPARACAO, " + 
		   	       "               Case When P.DATAINICIOBALCAO Is Null Then (Sysdate - Sysdate) " + 
		   	       "                     when P.DATAFIMBALCAO    Is null then (Sysdate - P.DATAINICIOBALCAO) " + 
		   	       "                     Else (P.DATAFIMBALCAO - P.DATAINICIOBALCAO) " + 
		   	       "               end EMCONFERENCIA, " + 
		   	       "	              (sysdate - Nvl(P.DATACHEGADACLI,P.DATAPEDIDO)) TEMPODECOR, " + 
		   	       "               P.PAINEL " + 
		   	       "           from TAB_PEDIDOC P " + 
		   	       "               ,PCCLIENT    C " + 
		   	       "               ,PCUSUARI    V " + 
		   	       "         where P.CODCCLI    = C.CODCLI " + 
		   	       "           And P.CODUSUR    = V.CODUSUR " + 
		   	       "           and Trunc(Nvl(P.DATACHEGADACLI,P.DATAPEDIDO)) >= TRUNC(sysdate) - 90 " + 
		   	       "           and P.CODFILIAL in ('1','2')																					"+ 
		   	       "           And NVL(P.RETIRA,'N') <> 'G' " + 
		   	       "           and P.POSICAO   <> 'C' " + 
		   	       "           and P.PAINEL     = 'S' 																								"+ 
		   	       "           and P.STATUS    In ('R','B','L','E','F','V','H','X','T')  											"+ 
		   	       "         Union All " + 
		   	       "         select P.NUMPED, " + 
		   	       "               P.CODUSUR, " + 
		   	       "               P.STATUS, " + 
		   	       " (select U.NOME from PCUSUARI U where U.CODUSUR = P.CODUSUR) nome, " + 
		   	       "               (Case When REPLACE(REPLACE(REPLACE(V.CPF,'.',''),'/',''),'-','') = REPLACE(REPLACE(REPLACE(C.CGCENT,'.',''),'/',''),'-','') " +
		   	       "                       Then (Select T.OBS2 From PCPEDC T Where T.NUMPED = P.NUMPED) " + 
		   	       "                           Else C.CLIENTE " + 
		   	       "               End) CLIENTE, " + 
		   	       "               Nvl(P.DATACHEGADACLI,P.DATAPEDIDO) DATAPEDIDO, " + 
		   	       "               Nvl(P.DATACHEGADACLI,P.DATAPEDIDO) DATAEMISSAOMAPA, " + 
		   	       "               P.DATACHEGADACLI, " + 
		   	       "               P.DATAINICIOSEP DATAINICIOSEP, " + 
		   	       "               P.CODFUNCSEP, " + 
		   	       "               P.DATAFIMSEP DTFINALSEP, " + 
		   	       "               P.DATAFIMBALCAO DATAFIMBALCAO, " + 
		   	       "               P.CODFUNCBALCAO CODFUNCBALCAO, " + 
		   	       "               CASE when P.DATAINICIOSEP Is Null Then (Sysdate - Nvl(P.DATACHEGADACLI,P.DATAPEDIDO)) " + 
		   	       "                     else (P.DATAINICIOSEP - Nvl(P.DATACHEGADACLI,P.DATAPEDIDO)) " + 
		   	       "               end AGUARDSEP, " + 
		   	       "               CASE when P.DATAINICIOSEP Is Null Then (Sysdate - Sysdate) " + 
		   	       "                     when P.DATAFIMSEP    Is Null Then (sysdate - P.DATAINICIOSEP) " + 
		   	       "                     else (P.DATAFIMSEP - P.DATAINICIOSEP) " + 
		   	       "               end EMSEPARACAO, " + 
		   	       "               Case When P.DATAINICIOBALCAO Is Null Then (Sysdate - Sysdate) " + 
		   	       "                     when P.DATAFIMBALCAO    Is null then (Sysdate - P.DATAINICIOBALCAO) " + 
		   	       "                     Else (P.DATAFIMBALCAO - P.DATAINICIOBALCAO) " + 
		   	       "               end EMCONFERENCIA, " + 
		   	       "               (sysdate - Nvl(P.DATACHEGADACLI,P.DATAPEDIDO)) TEMPODECOR, " + 
		   	       "               P.PAINEL " + 
		   	       "           from TAB_PEDIDOC P " + 
		   	       "               ,PCCLIENT    C " + 
		   	       "               ,PCUSUARI    V " + 
		   	       "         where P.CODCCLI    = C.CODCLI " + 
		   	       "           And P.CODUSUR    = V.CODUSUR " + 
		   	       "           and Trunc(Nvl(P.DATACHEGADACLI,P.DATAPEDIDO)) >= TRUNC(sysdate) - 90 " + 
		   	       "           and P.CODFILIAL in ('1','2') " +
		   	       "           and P.POSICAO   <> 'C' 	 "+
		   	       "           And NVL(P.RETIRA,'N') <> 'G' " +
		   	       "           and P.PAINEL     = 'N' " +
		   	       "           and P.STATUS    In ('R','B','L','E','F','V','H','X','T') ) REL " +
		   	       " Where (REL.STATUS not in ('L','E') or (REL.STATUS in ('L','E') and (REL.DATACHEGADACLI is not null))) " + 
		   	       andWhere +
		   	       " order by ORDEM ,REL.TEMPODECOR DESC ";
	}
	
	public List<PedidoPayload> getDadosDoResultSet(List<Object[]> results) {
		List<PedidoPayload> pedidoResult = new ArrayList<>();
	    TabPedidosFilter pedidofilter = new TabPedidosFilter();
	    if (results != null) {
	    	for (Object[] objects : results) {
	    		PedidoPayload pedido = new PedidoPayload();
	    		int i = 0;
	    		
	    		pedido.setNUMPED((BigDecimal) objects[i++]);
	    		pedido.setNOME((String) objects[i++]);
	    		pedido.setCLIENTE((String) objects[i++]);
	    		pedido.setDATAPEDIDO(getLocalDateTime(objects[i++]));
	    		pedido.setDATAEMISSAOMAPA(getLocalDateTime(objects[i++]));
	    		pedido.setDATAINICIOSEP(getLocalDateTime(objects[i++]));
	    		pedido.setDATAFIMSEP(getLocalDateTime(objects[i++]));
	    		pedido.setDATACHEGADACLI(getLocalDateTime(objects[i++]));
	    		pedido.setCODFUNCSEP((BigDecimal) objects[i++]);
	    		pedido.setDATAFIMBALCAO(getLocalDateTime(objects[i++]));
	    		pedido.setCODFUNCBALCAO((BigDecimal) objects[i++]);
	    		pedido.setDATAATUAL(getLocalDateTime(objects[i++]));
	    		pedido.setAGUARDSEP((String) objects[i++]);
	    		pedido.setEMSEPARACAO((String) objects[i++]);
	    		pedido.setEMCONFERENCIA((String) objects[i++]);
	    		pedido.setTEMPODECOR((String) objects[i++]);
	    		pedido.setPOSICAO((String) objects[i++]);
	    		pedido.setORDEM((BigDecimal) objects[i++]);
	    		pedido.setPAINEL((String) objects[i++]);
	    		
	    		if(pedidofilter.getNumped() == null) {
	    			pedidoResult.add(pedido);
	    		}
			}
	    }

	    return pedidoResult;
	}

	public List<PedidoPayload> findAll() {
	    List<Object[]> results = entityManager.createNativeQuery(getConsulta(""))
	    		.getResultList();
	    
	    return getDadosDoResultSet(results);
	}
	

	public List<PedidoPayload> findById(BigDecimal nUMPED){
	    List<Object[]> results = entityManager.createNativeQuery(getConsulta(" and REL.numped = :numped "))
    		.setParameter("numped", nUMPED)
	    		.getResultList();
	    
	    return getDadosDoResultSet(results);
	}
		
	private Date getLocalDateTime(Object object) {
		if (object != null) {
			return Date.from(((Timestamp) object).toLocalDateTime().atZone(ZoneId.systemDefault()).toInstant());
		}
		return null;
	}


	public List<PedidoPayload> findByFiltro(TabPedidosFilter filter) {
		String andWhere = "";
		if (filter.getDataPedidoDe() != null) {
			andWhere += " and REL.DATAPEDIDO >= :dataPedidoDe ";
		}
		if (filter.getDataPedidoAte() != null) {
			andWhere += " and REL.DATAPEDIDO <= :dataPedidoAte";
		}
		if (filter.getNomeCliente() != null) {
			andWhere += " and REL.CLIENTE like :nomeCliente";
		}
		if (filter.getNomeVendedor() != null) {
			andWhere += " and REL.NOME like :nomeVendedor";
		}
		
		Query nativeQuery = entityManager.createNativeQuery(getConsulta(andWhere));
		
		if (filter.getDataPedidoDe() != null) {
			nativeQuery.setParameter("dataPedidoDe",filter.getDataPedidoDe());
		}
		if (filter.getDataPedidoAte() != null) {
			nativeQuery.setParameter("dataPedidoAte", filter.getDataPedidoAte());
		}
		if (filter.getNomeCliente() != null) {
			nativeQuery.setParameter("nomeCliente", "%"+filter.getNomeCliente()+"%");
		} 
		if (filter.getNomeVendedor() != null) {
			nativeQuery.setParameter("nomeVendedor", "%"+filter.getNomeVendedor()+"%");
		} 
		    
		
		List<Object[]> results = nativeQuery.getResultList();
	    return getDadosDoResultSet(results);
	}
}