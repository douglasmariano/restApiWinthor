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

import com.ajel.controller.payloads.PedidoPayload;
import com.ajel.repository.filter.TabPedidosFilter;

@Service
public class TabPedidoService {

	@PersistenceContext
	private EntityManager entityManager;
	
	public String getClienteChegou(String andWhere) {
		return " select REL.NUMPED, " + 
		   	       "       REL.nome, " + 
		   	       "       REL.CLIENTE, " + 
		   	       "       REL.DATAPEDIDO, " + 
		   	       "       REL.DATADIGITACAO, " +
		   	       "       REL.DATAEMISSAOMAPA,	 " + 
		   	       "       REL.DATAINICIOSEP, " + 
		   	       "       REL.DATAFIMSEP, " + 
		   	       "       REL.DATACHEGADACLI, " + 
		   	       "       REL.CODFUNCSEP, " + 
		   	       "       REL.DATAFIMBALCAO, " + 
		   	       "       REL.CODFUNCBALCAO, " +		   	       
		   	       "       sysdate DATAATUAL, " + 
		   	       "	   REL.OBS, "	+
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
		   	       "             when REL.STATUS = 'N' then 'Digitado' " +  
				   "             when REL.STATUS = 'A' then 'Aguardando Cliente' " +  
				   "             when REL.STATUS = 'B' then 'Balcão' " +  
				   "             when REL.STATUS = 'E' then 'Em Separação' " + 
				   "             when REL.STATUS = 'L' then 'Finalizar' " +   
				   "             when REL.STATUS = 'C' then 'Cancelado' " +  
				   "             when REL.STATUS = 'R' then 'Retira' " +  
				   "             when REL.STATUS = 'Z' then 'Finalizado' " +  
		   	       "       end STATUS, " + 
		   	       "       case when REL.STATUS in ('A','E') then 1 " + 
		   	       "             when REL.STATUS in ('R','B') then 2 " + 
		   	       "             when REL.STATUS = 'F' then 0 " + 
		   	       "             when REL.STATUS = 'X' then 0 " + 
		   	       "             when REL.STATUS = 'P' then 4 " + 
		   	       "             when REL.STATUS = 'T' then 3 " + 
		   	       "             when REL.STATUS = 'H' then 0 " + 
		   	       "             when REL.STATUS = 'V' then 0 " + 
		   	       "       end ORDEM, " + 
		   	       "       REL.PAINEL, " + 
		   	       "       REL.POSICAO, " + 
		   	       "   	    REL.COBRANCA, " +
		   	       "   	    REL.TIPOPRODUTO " +
		   	       "   from (select P.NUMPED NUMPED, " + 
		   	       "               P.CODUSUR, " + 
		   	       "               P.STATUS, " + 
		   	       "               (select U.NOME from PCUSUARI U where U.CODUSUR = P.CODUSUR) nome, " + 
		   	       "               (Case When REPLACE(REPLACE(REPLACE(V.CPF,'.',''),'/',''),'-','') = REPLACE(REPLACE(REPLACE(C.CGCENT,'.',''),'/',''),'-','') " +
		   	       "                       Then (Select T.OBS2 From PCPEDC T Where T.NUMPED = P.NUMPED) " + 
		   	       "                          Else C.CLIENTE " + 
		   	       "               End) CLIENTE, " + 
		   	       "               Nvl(P.DATACHEGADACLI,P.DATAPEDIDO) DATAPEDIDO, " + 
		   	       "               Nvl(P.DATACHEGADACLI,P.DATAPEDIDO) DATAEMISSAOMAPA, " + 
		   	       "               P.DATAPEDIDO as DATADIGITACAO, " +
		   	       "               P.DATACHEGADACLI, " + 
		   	       "               P.DATAINICIOSEP DATAINICIOSEP, " + 
		   	       "               P.CODFUNCSEP, " + 
		   	       "               P.DATAFIMSEP DATAFIMSEP, " + 
		   	       "               P.DATAFIMBALCAO DATAFIMBALCAO, " + 
		   	       "               P.CODFUNCBALCAO CODFUNCBALCAO, " + 	
		   	       "               NVL(F.OBS,'') OBS, " +
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
		   	       "               P.PAINEL, " +
    		   	    "                      CASE " +
                    "         WHEN P.retira = 'S'  THEN 'RETIRA' "+
                    "         WHEN P.retira = 'G'  THEN 'ENTREGA' " +
                    "         WHEN P.retira = 'N' AND P.STATUS = 'N' THEN 'NADA' " +
                    "         WHEN P.posicao = 'F' and P.retira = 'S' THEN 'RETIRA' " +
                    "         WHEN P.posicao = 'F' and P.retira = 'G' THEN 'ENTREGA' " +
                    "         WHEN (P.status = 'P' OR P.status = 'N' OR P.status = 'B' OR P.status = 'E' OR  P.status = 'F') and (P.posicao = 'F' OR P.posicao = 'M' OR P.posicao = 'B') AND P.retira = 'N' THEN 'BALCAO'" +
                    "         WHEN P.posicao = 'C' THEN 'CANCELADO' " +
                    "    ELSE 'ERROR' END as posicao,"+
                    "            F.CODCOB AS cobranca, " +
                    "            (SELECT CASE WHEN socabo = '10' OR socabo = '01' THEN 'MATERIAL E CABO' " +
                    "                WHEN socabo = '1' THEN 'CABO' "+
                    "                WHEN socabo = '0' THEN 'MATERIAL' END AS socabo "+
                    "                FROM "+
                    "                    (SELECT * FROM VW_pedido_so_cabo WHERE numped = NUMPED)"+
                    "                    WHERE numped = f.numped"+
                    "                     GROUP BY numped, socabo) AS TIPOPRODUTO     "+              
		   	       "           from TAB_PEDIDOC P " + 
		   	       "               ,PCCLIENT    C " + 
		   	       "               ,PCUSUARI    V " +
		   	       "			   ,PCPEDC    	F " +
		   	       "         where P.CODCCLI    = C.CODCLI " + 
		   	       "           And P.CODUSUR    = V.CODUSUR " + 
		   	       "           And P.NUMPED    = F.NUMPED " + 
		   	       "           and Trunc(Nvl(P.DATACHEGADACLI,P.DATAPEDIDO)) >= TRUNC(sysdate) - 15 " +
		   	       "           and P.CODFILIAL in ('1','2','3','4')																					"+ 
		   	      // "           And NVL(P.RETIRA,'N') <> 'G' " + 
		   	       "           and P.POSICAO   <> 'C' " + 
		   	       "           and P.PAINEL     = 'S' 																								"+ 
		   	       "           and P.STATUS    In ('A','R','B','E','V','H','T','F')  											"+ 
		   	       "         Union All " +  
		   	       "         select P.NUMPED NUMPED, " + 
		   	       "               P.CODUSUR, " + 
		   	       "               P.STATUS, " + 
		   	       " (select U.NOME from PCUSUARI U where U.CODUSUR = P.CODUSUR) nome, " + 
		   	       "               (Case When REPLACE(REPLACE(REPLACE(V.CPF,'.',''),'/',''),'-','') = REPLACE(REPLACE(REPLACE(C.CGCENT,'.',''),'/',''),'-','') " +
		   	       "                       Then (Select T.OBS2 From PCPEDC T Where T.NUMPED = P.NUMPED) " + 
		   	       "                           Else C.CLIENTE " + 
		   	       "               End) CLIENTE, " + 
		   	       "               Nvl(P.DATACHEGADACLI,P.DATAPEDIDO) DATAPEDIDO, " + 
		   	       "               Nvl(P.DATACHEGADACLI,P.DATAPEDIDO) DATAEMISSAOMAPA, " +
		   	       "               P.DATAPEDIDO as DATADIGITACAO, " +
		   	       "               P.DATACHEGADACLI, " + 
		   	       "               P.DATAINICIOSEP DATAINICIOSEP, " + 
		   	       "               P.CODFUNCSEP, " + 
		   	       "               P.DATAFIMSEP DATAFIMSEP, " + 
		   	       "               P.DATAFIMBALCAO DATAFIMBALCAO, " + 
		   	       "               P.CODFUNCBALCAO CODFUNCBALCAO, " +
		   	       "               NVL(F.OBS,'') OBS, " +
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
		   	       "               P.PAINEL, " + 
		   	       "                      CASE " +
		   	       "         WHEN P.retira = 'S'  THEN 'RETIRA' "+
		   	       "         WHEN P.retira = 'G'  THEN 'ENTREGA' " +
		   	       "         WHEN P.retira = 'N' AND P.status = 'N' THEN 'NADA' " +
		   	       "         WHEN P.posicao = 'F' and P.retira = 'S' THEN 'RETIRA' " +
		   	       "         WHEN P.posicao = 'F' and P.retira = 'G' THEN 'ENTREGA' " +
		   	       "         WHEN (P.status = 'P' OR P.status = 'N' OR P.status = 'B' OR P.status = 'E' OR  P.status = 'F') and (P.posicao = 'F' OR P.posicao = 'M' OR P.posicao = 'B') AND P.retira = 'N' THEN 'BALCAO'" +
		   	       "         WHEN P.posicao = 'C' THEN 'CANCELADO' " +
		   	    "    ELSE 'ERROR' END as posicao,"+
                "            F.CODCOB AS cobranca, " +
                "            (SELECT CASE WHEN socabo = '10' OR socabo = '01' THEN 'MATERIAL E CABO' " +
                "                WHEN socabo = '1' THEN 'CABO' "+
                "                WHEN socabo = '0' THEN 'MATERIAL' END AS socabo "+
                "                FROM "+
                "                    (SELECT * FROM VW_pedido_so_cabo WHERE numped = NUMPED)"+
                "                    WHERE numped = f.numped"+
                "                     GROUP BY numped, socabo) AS TIPOPRODUTO     "+     
		   	       "           from TAB_PEDIDOC P " + 
		   	       "               ,PCCLIENT    C " + 
		   	       "               ,PCUSUARI    V " + 
		   	       "			   ,PCPEDC    	F " +
		   	       "         where P.CODCCLI    = C.CODCLI " + 
		   	       "           And P.CODUSUR    = V.CODUSUR " +	
		   	       "           And P.NUMPED    = F.NUMPED " + 
		   	       "           and Trunc(Nvl(P.DATACHEGADACLI,P.DATAPEDIDO)) >= TRUNC(sysdate) - 15 " +
		   	       "           and P.CODFILIAL in ('1','2','3','4')    " +
		   	       "           and P.POSICAO   <> 'C' 	 "+
		   	       "           And NVL(P.RETIRA,'N') in ('S','G') " +
		   	       "           and P.PAINEL     = 'N' " +
		   	       "           and P.STATUS    In ('A','R','B','E','V','H','T','P','F') ) REL " +
		   	       " Where 1 = 1 " + 
		   	       andWhere +
		   	       " order by datapedido desc,ORDEM ,REL.TEMPODECOR DESC ";
	}
	
	public String getPainelCliente(){
		return 	"select REL.NUMPED," +                                                                                                                                                  
		        "       REL.NOME," +                                                                                                                                                     
		        "       REL.CLIENTE," +                                                                                                                                                 
		        "       REL.DTPEDIDO," +
		        "       REL.DATADIGITACAO, " +
		        "       REL.DTEMISSAOMAPA," +                                                                                                                                           
		        "       REL.DTINICIALSEP," +                                                                                                                                            
		        "       REL.DTFINALSEP," +                                                                                                                                              
		        "       REL.DATACHEGADACLI," +                                                                                                                                          
		        "       REL.CODFUNCSEP," +                                                                                                                                              
		        "       REL.DTFINALCHECKOUT," +                                                                                                                                         
		        "       REL.CODFUNCCONF," +                                                                                                                                           
		        "       sysdate DATAATUAL," +
		        "       REL.OBS, "   +
		        "       lpad(Trunc(mod(REL.AGUARDSEP*24, 60)),2,0) || ':' || " +                                                                                                      
		        "       lpad(Trunc(mod(REL.AGUARDSEP*24*60, 60)),2,0) || ':' || " +                                                                                                   
		        "       lpad(Trunc(mod(REL.AGUARDSEP*24*60*60, 60)),2,0) AGUARDSEP," +                                                                                                
		        "       lpad(Trunc(mod(REL.EMSEPARACAO*24, 60)),2,0) || ':' || " +                                                                                                    
		        "       lpad(Trunc(mod(REL.EMSEPARACAO*24*60, 60)),2,0) || ':' ||" +                                                                                                  
		        "       lpad(Trunc(mod(REL.EMSEPARACAO*24*60*60, 60)),2,0) EMSEPARACAO," +                                                                                            
		        "       lpad(Trunc(mod(REL.EMCONFERENCIA*24, 60)),2,0) || ':' || " +                                                                                                  
		        "       lpad(Trunc(mod(REL.EMCONFERENCIA*24*60, 60)),2,0) || ':' ||" +                                                                                                
		        "       lpad(Trunc(mod(REL.EMCONFERENCIA*24*60*60, 60)),2,0) EMCONFERENCIA," +                                                                                        
		        "       lpad(Trunc(mod(REL.TEMPODECOR*24, 60)),2,0) || ':' ||" +                                                                                                      
		        "       lpad(Trunc(mod(REL.TEMPODECOR*24*60, 60)),2,0) || ':' ||" +                                                                                                   
		        "       lpad(Trunc(mod(REL.TEMPODECOR*24*60*60, 60)),2,0) TEMPODECOR," +                                                                                              
		        "       case when REL.STATUS in ('R','B') then 'Aguardando Separação' " +                                                                                         
		        "            when REL.STATUS in ('L','E') then 'Em Separação'" +                                                                                                  
		        "            when REL.STATUS = 'F' then 'Conferência' " +                                                                                                           
		        "            when REL.STATUS = 'H' then 'Procure o Vendedor' " +                                                                                                    
		        "            when REL.STATUS = 'V' then 'Procure o Vendedor' " +                                                                                                  
		        "            when REL.STATUS = 'X' then 'Dirija-se ao Caixa' " +                                                                                                    
		        "            when REL.STATUS = 'T' then 'Vendedor Alterando Pedido' " +                                                                                             
		        "            when REL.STATUS = 'P' then 'Pacote'" +                                                                                                                 
		        "       end STATUS," +                                                                                                                                              
		        "       case when REL.STATUS in ('L','E') then 1  " +                                                                                                               
		        "            when REL.STATUS in ('R','B') then 2  " +                                                                                                               
		        "            when REL.STATUS = 'F' then 0 " +                                                                                                                         
		        "            when REL.STATUS = 'X' then 0 " +                                                                                                                      
		        "            when REL.STATUS = 'P' then 4 " +                                                                                                                         
		        "            when REL.STATUS = 'T' then 3 " +                                                                                                                         
		        "            when REL.STATUS = 'H' then 0 " +                                                                                                                         
		        "            when REL.STATUS = 'V' then 0 " +                                                                                                                         
		        "       end ORDEM," +                                                                                                                                                 
		        "       REL.PAINEL, " +
		        "       REL.POSICAO, " + 
		        "         REL.COBRANCA, " +
                "        REL.TIPOPRODUTO " +
		        "  from (select P.NUMPED," +                                                                                                                                          
		        "               P.CODUSUR," +                                                                                                                                         
		        "               P.STATUS," +                                                                                                                                          
		        "               (select U.NOME from PCUSUARI U where U.CODUSUR = P.CODUSUR) NOME," +                                                                                   
		        "               (Case When REPLACE(REPLACE(REPLACE(V.CPF,'.',''),'/',''),'-','') = REPLACE(REPLACE(REPLACE(C.CGCENT,'.',''),'/',''),'-','')" +  
		        "                      Then NVL((Select T.OBS2 From PCPEDC T Where T.NUMPED = P.NUMPED),C.CLIENTE)" + 
		        "                          Else Rpad(substr(DECODE(C.CODCLI,1,DECODE((SELECT COUNT(*) " +
		        "                                                                       FROM PCVENDACONSUM " +
		        "                                                                      WHERE NUMPED = P.NUMPED),0, C.CLIENTE,VV.CLIENTE)" + 
		        "                                                          ,2,DECODE((SELECT COUNT(*) " +
		        "                                                                       FROM PCVENDACONSUM " +
		        "                                                                      WHERE NUMPED = P.NUMPED),0, C.CLIENTE,VV.CLIENTE) " +
		        "                                                          ,3,DECODE((SELECT COUNT(*) " +
		        "                                                                       FROM PCVENDACONSUM " +
		        "                                                                      WHERE NUMPED = P.NUMPED),0, C.CLIENTE,VV.CLIENTE) " +
		        "                                                          ,C.CLIENTE),1,30),30,' ') " +
		        "               End) CLIENTE," +                                                                                                                                      
		        "               to_date(Nvl(P.DATACHEGADACLI,P.DATAPEDIDO), 'DD/MM/YYYY hh24:mi') DTPEDIDO," +                                                                      
		        "               Nvl(P.DATACHEGADACLI,P.DATAPEDIDO) DTEMISSAOMAPA," +
		        "               P.DATAPEDIDO as DATADIGITACAO, " +
		        "               P.DATACHEGADACLI," +                                                                                                                                  
		        "               P.DATAINICIOSEP DTINICIALSEP," +                                                                                                                      
		        "               P.CODFUNCSEP," +                                                                                                                                      
		        "               P.DATAFIMSEP DTFINALSEP," +                                                                                                                           
		        "               P.DATAFIMBALCAO DTFINALCHECKOUT," +                                                                                                                   
		        "               P.CODFUNCBALCAO CODFUNCCONF," + 
		        "               F.OBS," +
		        "               CASE when P.DATAINICIOSEP Is Null Then (Sysdate - Nvl(P.DATACHEGADACLI,P.DATAPEDIDO))" +                                                                
		        "                    else (P.DATAINICIOSEP - Nvl(P.DATACHEGADACLI,P.DATAPEDIDO))" +                                                                                     
		        "               end AGUARDSEP," +                                                                                                                                     
		        "               CASE when P.DATAINICIOSEP Is Null Then (Sysdate - Sysdate)" +                                                                                           
		        "                    when P.DATAFIMSEP    Is Null Then (sysdate - P.DATAINICIOSEP) " +                                                                                  
		        "                    else (P.DATAFIMSEP - P.DATAINICIOSEP) " +                                                                                                          
		        "               end EMSEPARACAO," +                                                                                                                                   
		        "               Case When P.DATAINICIOBALCAO Is Null Then (Sysdate - Sysdate) " +                                                                                       
		        "                    when P.DATAFIMBALCAO    Is null then (Sysdate - P.DATAINICIOBALCAO)  " +                                                                           
		        "                    Else (P.DATAFIMBALCAO - P.DATAINICIOBALCAO) " +                                                                                                    
		        "               end EMCONFERENCIA," +                                                                                                                                 
		        "               (sysdate - Nvl(P.DATACHEGADACLI,P.DATAPEDIDO)) TEMPODECOR," +                                                                                         
		        "               P.PAINEL,  " + 
		        "                      CASE " +
                "         WHEN P.retira = 'S'  THEN 'RETIRA' "+
                "         WHEN P.retira = 'G'  THEN 'ENTREGA' " +
                "         WHEN P.retira = 'N' AND P.status = 'N' THEN 'NADA' " +
                "         WHEN P.posicao = 'F' and P.retira = 'S' THEN 'RETIRA' " +
                "         WHEN P.posicao = 'F' and P.retira = 'G' THEN 'ENTREGA' " +
                "         WHEN (P.status = 'P' OR P.status = 'N' OR P.status = 'B' OR P.status = 'E' OR  P.status = 'F') and (P.posicao = 'F' OR P.posicao = 'M' OR P.posicao = 'B') AND P.retira = 'N' THEN 'BALCAO'" +
                "         WHEN P.posicao = 'C' THEN 'CANCELADO' " +
                "    ELSE 'ERROR' END as posicao,"+
                "            F.CODCOB AS cobranca, " +
                "            (SELECT CASE WHEN socabo = '10' OR socabo = '01' THEN 'MATERIAL E CABO' " +
                "                WHEN socabo = '1' THEN 'CABO' "+
                "                WHEN socabo = '0' THEN 'MATERIAL' END AS socabo "+
                "                FROM "+
                "                    (SELECT * FROM VW_pedido_so_cabo WHERE numped = NUMPED)"+
                "                    WHERE numped = f.numped"+
                "                     GROUP BY numped, socabo) AS TIPOPRODUTO     "+    
		        "          from TAB_PEDIDOC P " +                                                                                                                                       
		        "              ,PCCLIENT    C " +                                                                                                                                       
		        "              ,PCUSUARI    V " +                                                                                                                                       
		        "              ,PCVENDACONSUM VV " +
		        "              ,PCPEDC       F " +
		        "         where P.CODCCLI    = C.CODCLI " + 
		        "           And P.CODUSUR    = V.CODUSUR " +
		        "           And P.NUMPED     = VV.NUMPED(+) " +
		        "           And P.NUMPED    = F.NUMPED " +
		        "           and Trunc(Nvl(P.DATACHEGADACLI,P.DATAPEDIDO)) >= TRUNC(sysdate) - 1 " +
		        "           and P.CODFILIAL in ('1','2','3','4') " +
		        "           And NVL(P.RETIRA,'N') <> 'G' " +
		        "           and P.POSICAO   <> 'C' " +
		        "           and P.PAINEL     = 'S' " +
		        "           and P.STATUS    In ('R','B','L','E','F','V','H','X','T') " + 
		        "        Union All " +                                                                                                                                                  
		        "        select P.NUMPED," +                                                                                                                                          
		        "               P.CODUSUR," +                                                                                                                                         
		        "               P.STATUS," +                                                                                                                                          
		        "               (select U.NOME from PCUSUARI U where U.CODUSUR = P.CODUSUR) NOME," +                                                                                   
		        "               (Case When REPLACE(REPLACE(REPLACE(V.CPF,'.',''),'/',''),'-','') = REPLACE(REPLACE(REPLACE(C.CGCENT,'.',''),'/',''),'-','') " + 
		        "                      Then NVL((Select T.OBS2 From PCPEDC T Where T.NUMPED = P.NUMPED),C.CLIENTE) " +
		        "                          Else Rpad(substr(DECODE(C.CODCLI,1,DECODE((SELECT COUNT(*) " +
		        "                                                                       FROM PCVENDACONSUM " +
		        "                                                                      WHERE NUMPED = P.NUMPED),0, C.CLIENTE,VV.CLIENTE) " +
		        "                                                          ,2,DECODE((SELECT COUNT(*)" + 
		        "                                                                       FROM PCVENDACONSUM " +
		        "                                                                      WHERE NUMPED = P.NUMPED),0, C.CLIENTE,VV.CLIENTE)" + 
		        "                                                          ,3,DECODE((SELECT COUNT(*)" + 
		        "                                                                       FROM PCVENDACONSUM " +
		        "                                                                      WHERE NUMPED = P.NUMPED),0, C.CLIENTE,VV.CLIENTE) " +
		        "                                                          ,C.CLIENTE),1,30),30,' ')" + 
		        "               End) CLIENTE," +                                                                                                                                      
		        "               to_date(Nvl(P.DATACHEGADACLI,P.DATAPEDIDO), 'DD/MM/YYYY hh24:mi') DTPEDIDO," +                                                                      
		        "               Nvl(P.DATACHEGADACLI,P.DATAPEDIDO) DTEMISSAOMAPA," +  
		        "               P.DATAPEDIDO as DATADIGITACAO, " +
		        "               P.DATACHEGADACLI," +                                                                                                                                  
		        "               P.DATAINICIOSEP DTINICIALSEP," +                                                                                                                      
		        "               P.CODFUNCSEP," +                                                                                                                                      
		        "               P.DATAFIMSEP DTFINALSEP," +                                                                                                                           
		        "               P.DATAFIMBALCAO DTFINALCHECKOUT," +                                                                                                                   
		        "               P.CODFUNCBALCAO CODFUNCCONF," + 
		        "               F.OBS," +
		        "               CASE when P.DATAINICIOSEP Is Null Then (Sysdate - Nvl(P.DATACHEGADACLI,P.DATAPEDIDO)) " +                                                               
		        "                    else (P.DATAINICIOSEP - Nvl(P.DATACHEGADACLI,P.DATAPEDIDO))" +                                                                                     
		        "               end AGUARDSEP," +                                                                                                                                     
		        "               CASE when P.DATAINICIOSEP Is Null Then (Sysdate - Sysdate) " +                                                                                          
		        "                    when P.DATAFIMSEP    Is Null Then (sysdate - P.DATAINICIOSEP)" +                                                                                   
		        "                    else (P.DATAFIMSEP - P.DATAINICIOSEP)" +                                                                                                           
		        "               end EMSEPARACAO," +                                                                                                                                   
		        "               Case When P.DATAINICIOBALCAO Is Null Then (Sysdate - Sysdate) " +                                                                                       
		        "                    when P.DATAFIMBALCAO    Is null then (Sysdate - P.DATAINICIOBALCAO)  " +                                                                           
		        "                    Else (P.DATAFIMBALCAO - P.DATAINICIOBALCAO) " +                                                                                                    
		        "               end EMCONFERENCIA," +                                                                                                                                 
		        "               (sysdate - Nvl(P.DATACHEGADACLI,P.DATAPEDIDO)) TEMPODECOR," +                                                                                         
		        "               P.PAINEL, " +
		        "                      CASE " +
                "         WHEN P.retira = 'S'  THEN 'RETIRA' "+
                "         WHEN P.retira = 'G'  THEN 'ENTREGA' " +
                "         WHEN P.retira = 'N' AND P.status = 'N' THEN 'NADA' " +
                "         WHEN P.posicao = 'F' and P.retira = 'S' THEN 'RETIRA' " +
                "         WHEN P.posicao = 'F' and P.retira = 'G' THEN 'ENTREGA' " +
                "         WHEN (P.status = 'P' OR P.status = 'N' OR P.status = 'B' OR P.status = 'E' OR  P.status = 'F') and (P.posicao = 'F' OR P.posicao = 'M' OR P.posicao = 'B') AND P.retira = 'N' THEN 'BALCAO'" +
                "         WHEN P.posicao = 'C' THEN 'CANCELADO' " +
                "    ELSE 'ERROR' END as posicao,"+
                "            F.CODCOB AS cobranca, " +
                "            (SELECT CASE WHEN socabo = '10' OR socabo = '01' THEN 'MATERIAL E CABO' " +
                "                WHEN socabo = '1' THEN 'CABO' "+
                "                WHEN socabo = '0' THEN 'MATERIAL' END AS socabo "+
                "                FROM "+
                "                    (SELECT * FROM VW_pedido_so_cabo WHERE numped = NUMPED)"+
                "                    WHERE numped = f.numped"+
                "                     GROUP BY numped, socabo) AS TIPOPRODUTO     "+    
		        "          from TAB_PEDIDOC P " +                                                                                                                                       
		        "              ,PCCLIENT    C " +                                                                                                                                       
		        "              ,PCUSUARI    V " +                                                                                                                                       
		        "              ,PCVENDACONSUM VV " +
                "              ,PCPEDC       F " +                                                                                                                                    
		        "         where P.CODCCLI    = C.CODCLI " +
		        "           And P.CODUSUR    = V.CODUSUR " +
		        "           And P.NUMPED     = VV.NUMPED(+) " +
		        "           And P.NUMPED    = F.NUMPED " +
		        "           and Trunc(Nvl(P.DATACHEGADACLI,P.DATAPEDIDO)) >= TRUNC(sysdate) - 1" + 
		        "           and P.CODFILIAL in ('1','2','3','4')" + 
		        "           and P.POSICAO   <> 'C' " +
		        "           And NVL(P.RETIRA,'N') <> 'G'  " +
		        "           and P.PAINEL     = 'N' " +
		        "           and P.STATUS    In ('R','B','L','E','F','V','H','X','T') ) REL " + 
		        " Where (REL.STATUS not in ('L','E') or (REL.STATUS in ('L','E') and (REL.DATACHEGADACLI is not null))) " +                                                     
		        " order by ORDEM ,REL.TEMPODECOR desc "   ;
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
	    		pedido.setDATADIGITACAO(getLocalDateTime(objects[i++]));
	    		pedido.setDATAEMISSAOMAPA(getLocalDateTime(objects[i++]));
	    		pedido.setDATAINICIOSEP(getLocalDateTime(objects[i++]));
	    		pedido.setDATAFIMSEP(getLocalDateTime(objects[i++]));
	    		pedido.setDATACHEGADACLI(getLocalDateTime(objects[i++]));
	    		pedido.setCODFUNCSEP((BigDecimal) objects[i++]);
	    		pedido.setDATAFIMBALCAO(getLocalDateTime(objects[i++]));
	    		pedido.setCODFUNCBALCAO((BigDecimal) objects[i++]);
	    		pedido.setDATAATUAL(getLocalDateTime(objects[i++]));
	    		pedido.setOBS((String) objects[i++]);
	    		pedido.setAGUARDSEP((String) objects[i++]);
	    		pedido.setEMSEPARACAO((String) objects[i++]);
	    		pedido.setEMCONFERENCIA((String) objects[i++]);
	    		pedido.setTEMPODECOR((String) objects[i++]);
	    		pedido.setSTATUS((String) objects[i++]);
	    		pedido.setORDEM((BigDecimal) objects[i++]);
	    		pedido.setPAINEL((String) objects[i++]);
	    		pedido.setPOSICAO((String) objects[i++]);
	    		pedido.setCOBRANCA((String) objects[i++]);
	    		pedido.setTIPOPRODUTO((String) objects[i++]);
	    		
	    		
	    		if(pedidofilter.getNumped() == null) {
	    			pedidoResult.add(pedido);
	    		}
			}
	    }

	    return pedidoResult;
	}

	public List<PedidoPayload> findAll() {
	    List<Object[]> results = entityManager.createNativeQuery(getClienteChegou(""))
	    		.getResultList();	    
	    return getDadosDoResultSet(results);
	}
	
	public List<PedidoPayload> findAllPainel() {
	    List<Object[]> results = entityManager.createNativeQuery(getPainelCliente())
	    		.getResultList();	    
	    return getDadosDoResultSet(results);
	}
	

	public List<PedidoPayload> findById(BigDecimal NUMPED){
	    List<Object[]> results = entityManager.createNativeQuery(getClienteChegou(" and REL.NUMPED like :numped "))
    		.setParameter("numped", "%"+NUMPED+"%")
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
		
		Query nativeQuery = entityManager.createNativeQuery(getClienteChegou(andWhere));
		
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