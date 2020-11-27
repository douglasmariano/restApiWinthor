package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.TabPedido;
import com.example.repository.tabpedido.TabPedidoRepositoryQuery;

public interface TabPedidoRepository extends JpaRepository<TabPedido, Long>, TabPedidoRepositoryQuery{	
		
	@Query(value ="	        select REL.NUMPED,          "+                                                                                                                                   
	       "       REL.nome,                                  "+                                                                                                                   
	       "       REL.CLIENTE,                              "+                                                                                                                   
	       "       REL.DATAPEDIDO,                             "+                                                                                                                  
	       "       REL.DATAEMISSAOMAPA,	                         "+                                                                                                                  
	       "       REL.DATAINICIOSEP,                                  "+                                                                                                          
	       "       REL.DATAFIMSEP,                                       "+                                                                                                       
	       "       REL.DATACHEGADACLI,                                    "+                                                                                                      
	       "       REL.CODFUNCSEP,                                          "+                                                                                                    
	       "       REL.DATAFIMBALCAO,                                      "+                                                                                                   
	       "       REL.CODFUNCBALCAO,                                            "+                                                                                                 
	       "       sysdate DATAATUAL,                                            "+                                                                                               
	       "       lpad(Trunc(mod(REL.AGUARDSEP*24, 60)),2,0) || ':' ||           "+                                                                                            
	       "       lpad(Trunc(mod(REL.AGUARDSEP*24*60, 60)),2,0) || ':' ||        "+                                                                                            
	       "       lpad(Trunc(mod(REL.AGUARDSEP*24*60*60, 60)),2,0) AGUARDSEP,       "+                                                                                           
	       "       lpad(Trunc(mod(REL.EMSEPARACAO*24, 60)),2,0) || ':' ||              "+                                                                                       
	       "       lpad(Trunc(mod(REL.EMSEPARACAO*24*60, 60)),2,0) || ':' ||           "+                                                                                       
	       "       lpad(Trunc(mod(REL.EMSEPARACAO*24*60*60, 60)),2,0) EMSEPARACAO,     "+                                                                                         
	       "       lpad(Trunc(mod(REL.EMCONFERENCIA*24, 60)),2,0) || ':' ||            "+                                                                                       
	       "       lpad(Trunc(mod(REL.EMCONFERENCIA*24*60, 60)),2,0) || ':' ||         "+                                                                                       
	       "       lpad(Trunc(mod(REL.EMCONFERENCIA*24*60*60, 60)),2,0) EMCONFERENCIA,  "+                                                                                        
	       "       lpad(Trunc(mod(REL.TEMPODECOR*24, 60)),2,0) || ':' ||                "+                                                                                      
	       "       lpad(Trunc(mod(REL.TEMPODECOR*24*60, 60)),2,0) || ':' ||             "+                                                                                      
	       "       lpad(Trunc(mod(REL.TEMPODECOR*24*60*60, 60)),2,0) TEMPODECOR,        "+                                                                                        
	       "       case when REL.STATUS in ('R','B') then 'Aguardando Separação'         "+                                                                                 
	       "             when REL.STATUS in ('L','E') then 'Em Separação'                "+                                                                                  
	       "             when REL.STATUS = 'F' then 'Conferência'                        "+                                                                                    
	       "             when REL.STATUS = 'H' then 'Procure o Vendedor'                 "+                                                                                    
	       "             when REL.STATUS = 'V' then 'Procure o Vendedor'                 "+                                                                                    
	       "             when REL.STATUS = 'X' then 'Dirija-se ao Caixa'                 "+                                                                                    
	       "             when REL.STATUS = 'T' then 'Vendedor Alterando Pedido'          "+                                                                                    
	       "             when REL.STATUS = 'P' then 'Pacote'                             "+                                                                                    
	       "       end POSICAO,                                                          "+                                                                                       
	       "       case when REL.STATUS in ('L','E') then 1                              "+                                                                                   
	       "             when REL.STATUS in ('R','B') then 2                             "+                                                                                    
	       "             when REL.STATUS = 'F' then 0                                    "+                                                                                      
	       "             when REL.STATUS = 'X' then 0                                    "+                                                                                      
	       "             when REL.STATUS = 'P' then 4                                    "+                                                                                      
	       "             when REL.STATUS = 'T' then 3                                    "+                                                                                      
	       "             when REL.STATUS = 'H' then 0                                    "+                                                                                      
	       "             when REL.STATUS = 'V' then 0                                    "+                                                                                      
	       "       end ORDEM,                                                            "+                                                                                       
	       "       REL.PAINEL                                                            "+                                                                                       
	       "   from (select P.NUMPED,                                                     "+                                                                                       
	       "               P.CODUSUR,                                                      "+                                                                                     
	       "               P.STATUS,                                                            "+                                                                                
	       "               (select U.NOME from PCUSUARI U where U.CODUSUR = P.CODUSUR) nome,                        "+                                                             
	       "               (Case When REPLACE(REPLACE(REPLACE(V.CPF,'.',''),'/',''),'-','') = REPLACE(REPLACE(REPLACE(C.CGCENT,'.',''),'/',''),'-','')  "+
	       "                       Then (Select T.OBS2 From PCPEDC T Where T.NUMPED = P.NUMPED)                    "+                                                              
	       "                          Else C.CLIENTE                                                         "+                                                                   
	       "               End) CLIENTE,                                                                   "+                                                                     
	       "               to_date(Nvl(P.DATACHEGADACLI,P.DATAPEDIDO), 'DD/MM/YYYY hh24:mi') DATAPEDIDO,        "+                                                                
	       "               Nvl(P.DATACHEGADACLI,P.DATAPEDIDO) DATAEMISSAOMAPA,                                     "+                                                               
	       "               P.DATACHEGADACLI,                                                                         "+                                                           
	       "               P.DATAINICIOSEP DATAINICIOSEP,                                                         "+                                                               
	       "               P.CODFUNCSEP,                                                                           "+                                                             
	       "               P.DATAFIMSEP DATAFIMSEP,                                                               "+                                                              
	       "               P.DATAFIMBALCAO DATAFIMBALCAO,                                                         "+                                                            
	       "               P.CODFUNCBALCAO CODFUNCBALCAO,                                                             "+                                                            
	       "               CASE when P.DATAINICIOSEP Is Null Then (Sysdate - Nvl(P.DATACHEGADACLI,P.DATAPEDIDO))      "+                                                          
	       "                     else (P.DATAINICIOSEP - Nvl(P.DATACHEGADACLI,P.DATAPEDIDO))                            "+                                                         
	       "               end AGUARDSEP,                                                                                 "+                                                      
	       "               CASE when P.DATAINICIOSEP Is Null Then (Sysdate - Sysdate)                                       "+                                                    
	       "                     when P.DATAFIMSEP    Is Null Then (sysdate - P.DATAINICIOSEP)                               "+                                                   
	       "                     else (P.DATAFIMSEP - P.DATAINICIOSEP)                                                       "+                                                 
	       "               end EMSEPARACAO,                                                                           "+                                                          
	       "               Case When P.DATAINICIOBALCAO Is Null Then (Sysdate - Sysdate)                             "+                                                          
	       "                     when P.DATAFIMBALCAO    Is null then (Sysdate - P.DATAINICIOBALCAO)                   "+                                                          
	       "                     Else (P.DATAFIMBALCAO - P.DATAINICIOBALCAO)                                           "+                                                          
	       "               end EMCONFERENCIA,                                                                           "+                                                        
	       "	              (sysdate - Nvl(P.DATACHEGADACLI,P.DATAPEDIDO)) TEMPODECOR,                                "+                                                           
	       "               P.PAINEL                                                                                        "+                                                     
	       "           from TAB_PEDIDOC P                                                                                    "+                                                    
	       "               ,PCCLIENT    C                                                                                      "+                                                  
	       "               ,PCUSUARI    V                                                                                        "+                                                
	       "         where P.CODCCLI    = C.CODCLI                                                                                 "+                                             
	       "           And P.CODUSUR    = V.CODUSUR                                                                                  "+                                           
	       "           and Trunc(Nvl(P.DATACHEGADACLI,P.DATAPEDIDO)) >= TRUNC(sysdate) - 1                                             "+                                         
	       "           and P.CODFILIAL in ('1','2')																					"+ 
	       "           And NVL(P.RETIRA,'N') <> 'G'                                                                                   "+                                       
	       "           and P.POSICAO   <> 'C'                                                                                              "+                                    
	       "           and P.PAINEL     = 'S' 																								"+ 
	       "           and P.STATUS    In ('R','B','L','E','F','V','H','X','T')  											"+ 
	       "         Union All                                                                                              "+                                                      
	       "         select P.NUMPED,                                                                                           "+                                                  
	       "               P.CODUSUR,                                                                                               "+                                             
	       "               P.STATUS,                                                                                                    "+   
	       " (select U.NOME from PCUSUARI U where U.CODUSUR = P.CODUSUR) nome,         "+                                                                             
	       "               (Case When REPLACE(REPLACE(REPLACE(V.CPF,'.',''),'/',''),'-','') = REPLACE(REPLACE(REPLACE(C.CGCENT,'.',''),'/',''),'-','')   "+
	       "                       Then (Select T.OBS2 From PCPEDC T Where T.NUMPED = P.NUMPED)                                                "+                                   
	       "                           Else C.CLIENTE                                                                                             "+                                
	       "               End) CLIENTE,                                                                                                             "+                             
	       "               to_date(Nvl(P.DATACHEGADACLI,P.DATAPEDIDO), 'DD/MM/YYYY hh24:mi') DATAPEDIDO,                                                   "+                      
	       "               Nvl(P.DATACHEGADACLI,P.DATAPEDIDO) DATAEMISSAOMAPA,                                                                            "+                         
	       "               P.DATACHEGADACLI,                                                                                                             "+                        
	       "               P.DATAINICIOSEP DATAINICIOSEP,                                                                                                  "+                       
	       "               P.CODFUNCSEP,                                                                                                                   "+                      
	       "               P.DATAFIMSEP DTFINALSEP,                                                                                                         "+                     
	       "               P.DATAFIMBALCAO DATAFIMBALCAO,                                                                                                  "+                    
	       "               P.CODFUNCBALCAO CODFUNCBALCAO,                                                                                                        "+                  
	       "               CASE when P.DATAINICIOSEP Is Null Then (Sysdate - Nvl(P.DATACHEGADACLI,P.DATAPEDIDO))                                                "+                 
	       "                     else (P.DATAINICIOSEP - Nvl(P.DATACHEGADACLI,P.DATAPEDIDO))                                                                     "+                 
	       "               end AGUARDSEP,                                                                                                                         "+               
	       "               CASE when P.DATAINICIOSEP Is Null Then (Sysdate - Sysdate)                                                                              "+              
	       "                     when P.DATAFIMSEP    Is Null Then (sysdate - P.DATAINICIOSEP)                                                                      "+              
	       "                     else (P.DATAFIMSEP - P.DATAINICIOSEP)                                                                                               "+             
	       "               end EMSEPARACAO,                                                                                                                           "+           
	       "               Case When P.DATAINICIOBALCAO Is Null Then (Sysdate - Sysdate)                                                                               "+          
	       "                     when P.DATAFIMBALCAO    Is null then (Sysdate - P.DATAINICIOBALCAO)                                                                    "+          
	       "                     Else (P.DATAFIMBALCAO - P.DATAINICIOBALCAO)                                                                                             "+         
	       "               end EMCONFERENCIA,                                                                                                                             "+       
	       "               (sysdate - Nvl(P.DATACHEGADACLI,P.DATAPEDIDO)) TEMPODECOR,                                                                                      "+      
	       "               P.PAINEL                                                                                                                                         "+     
	       "           from TAB_PEDIDOC P                                                                                                                                   "+     
	       "               ,PCCLIENT    C                                                                                                                                    "+     
	       "               ,PCUSUARI    V                                                                                                                                     "+    
	       "         where P.CODCCLI    = C.CODCLI                                                                                                                             "+  
	       "           And P.CODUSUR    = V.CODUSUR                                                                                                                           "+   
	       "           and Trunc(Nvl(P.DATACHEGADACLI,P.DATAPEDIDO)) >= TRUNC(sysdate) - 15                                                                                  "+     
	       "           and P.CODFILIAL in ('1','2')                                                                                                                      "+
	       "           and P.POSICAO   <> 'C' 	 "+
	       "           And NVL(P.RETIRA,'N') <> 'G'   "+
	       "           and P.PAINEL     = 'N'  "+
	       "           and P.STATUS    In ('R','B','L','E','F','V','H','X','T') ) REL   "+
	       " Where (REL.STATUS not in ('L','E') or (REL.STATUS in ('L','E') and (REL.DATACHEGADACLI is not null)))    "+                                                   
	       " order by ORDEM ,REL.TEMPODECOR DESC	         ", nativeQuery = true)
	    List<TabPedido> findAll();

}
