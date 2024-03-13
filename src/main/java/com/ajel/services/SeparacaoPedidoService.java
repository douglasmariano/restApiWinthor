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

import com.ajel.controller.payloads.PainelAcompanhaPedidoPayload;
import com.ajel.controller.payloads.PainelDePedidoPorProdutoPayload;
import com.ajel.repository.filter.PainelAcompanhaPedidoFilter;

@Service
public class SeparacaoPedidoService {

    @PersistenceContext
    private EntityManager entityManager;

    public String getSeparacaoDePedido(String andWhere) {
        return  " Select T.CODFILIAL  " +
                "       ,T.NUMPED  " +
                "       ,(Case When REPLACE(REPLACE(REPLACE(V.CPF,'.',''),'/',''),'-','') = REPLACE(REPLACE(REPLACE(C.CGCENT,'.',''),'/',''),'-','')  " +
                "                       Then NVL((Select TRIM(P.OBS2) From PCPEDC P Where P.NUMPED = T.NUMPED),C.CLIENTE)  " +
                "                           Else C.CLIENTE  " +
                "                End) CLIENTE  " +
                "       ,case When T.STATUS = 'A' Then 'Aguardando Cliente'  " +
                "             When T.STATUS = 'B' Then 'Balcão'  " +
                "             When T.STATUS = 'E' Then 'Em Separação'  " +
                "             When T.STATUS = 'G' Then 'Entrega'  " +
                "             When T.STATUS = 'L' Then 'Em Separação'  " +
                "             When T.STATUS = 'F' Then 'Conferência'  " +
                "             When T.STATUS = 'N' Then 'Digitado'  " +
                "             When T.STATUS = 'P' Then 'Pacote'  " +
                "             When T.STATUS = 'R' Then 'Retira'  " +
                "             When T.STATUS = 'H' Then 'Vendedor chamou Cliente'  " +
                "             When T.STATUS = 'T' Then 'Corte'  " +
                "             When T.STATUS = 'X' Then 'Caixa'  " +
                "        end STATUSEXT  " +
                "       ,T.STATUS  " +
                "       ,DECODE(T.STATUS,'T',0,'N',1,'A',2,'H',3,'B',4,'R',5,'F',6,'E',7,'X',8,'P',9,'L',10,'G',11) ORDEM  " +
                "       ,NVL(DATACHEGADACLI,DATAPEDIDO) DTPEDIDO  " +
                "       ,T.POSICAO  " +
                "       ,T.CODFUNCSEP  " +
                "       ,S.NOME_GUERRA FUNCSEP  " +
                "       ,T.DATAINICIOSEP  " +
                "       ,T.DATAFIMSEP  " +
                "       ,T.CODFUNCBALCAO  " +
                "       ,B.NOME_GUERRA FUNCBALC  " +
                "       ,T.DATAINICIOBALCAO  " +
                "       ,T.DATAFIMBALCAO  " +
                "       ,round((to_number(TO_DATE(TO_CHAR(sysdate,'HH24:MI'),'HH24:MI') - TO_DATE(to_CHAR(NVL(DATACHEGADACLI,DATAPEDIDO),'HH24:MI'), 'hh24:mi')) * 1440)) TEMPOTOTAL  " +
                "       ,Case When T.DATAINICIOSEP Is Not Null Then  " +
                "               Case When T.DATAFIMSEP is Null Then round((to_number(TO_DATE(TO_CHAR(sysdate,'HH24:MI'),'HH24:MI') - TO_DATE(to_CHAR(T.DATAINICIOSEP,'HH24:MI'), 'hh24:mi')) * 1440))  " +
                "                    Else round((to_number(TO_DATE(TO_CHAR(T.DATAFIMSEP,'HH24:MI'),'HH24:MI') - TO_DATE(to_CHAR(T.DATAINICIOSEP,'HH24:MI'), 'hh24:mi')) * 1440))  " +
                "               End  " +
                "             Else 0  " +
                "        End TEMPOSEP  " +
                "       ,Case When T.DATAINICIOBALCAO Is Not Null Then  " +
                "               Case When T.DATAFIMBALCAO is Null Then round((to_number(TO_DATE(TO_CHAR(sysdate,'HH24:MI'),'HH24:MI') - TO_DATE(to_CHAR(T.DATAINICIOBALCAO,'HH24:MI'), 'hh24:mi')) * 1440))  " +
                "                    Else round((to_number(TO_DATE(TO_CHAR(DATAFIMBALCAO,'HH24:MI'),'HH24:MI') - TO_DATE(to_CHAR(T.DATAINICIOBALCAO,'HH24:MI'), 'hh24:mi')) * 1440))  " +
                "               End  " +
                "             Else 0  " +
                "        End TEMPOBALC  " +
                "       ,T.ORIGINAL  " +
                "       ,T.RETIRA  " +
                "       ,substr((T.CODUSUR||'-'||V.NOME),1,60) VENDEDOR  " +
                "       ,(case when T.CODFUNCSEP is null then 'Iniciar'  " +
                "              when T.DATAFIMSEP is null then 'Finalizar'  " +
                "              else 'Rem/Trans'  " +
                "         end) DESCBUTTON  " +
                "   From TAB_PEDIDOC T  " +
                "       ,PCCLIENT    C  " +
                "       ,PCEMPR      S  " +
                "       ,PCEMPR      B  " +
                "       ,PCUSUARI    V  " +
                "  Where T.CODCCLI           = C.CODCLI  " +
                "    And T.CODUSUR           = V.CODUSUR  " +
                "    And T.CODFUNCSEP        = S.MATRICULA(+)  " +
                "    And T.CODFUNCBALCAO     = B.MATRICULA(+)  " +
                "    And NVL(TRUNC(T.DATACHEGADACLI),TRUNC(T.DATAPEDIDO)) Between TO_DATE('19/04/2023','DD/MM/YYYY') and TO_DATE('19/10/2023','DD/MM/YYYY')  " +
                "    And DECODE(T.STATUS,'T',0,'N',1,'A',2,'H',3,'B',4,'R',5,'F',6,'E',7,'X',8,'P',9,'L',10,'G',11) in (0,2,4,5,7,10,11) " +
                "  Order By T.CODFILIAL, ORDEM, NVL(T.DATACHEGADACLI,T.DATAPEDIDO) Desc " ;
    }

    public List<PainelAcompanhaPedidoPayload> getDadosDoResultSet(List<Object[]> results) {
        List<PainelAcompanhaPedidoPayload> PainelAcompanharPedidoResult = new ArrayList<>();

        if (results != null) {
            for (Object[] objects : results) {
                PainelAcompanhaPedidoPayload painelAcompanharPedido = new PainelAcompanhaPedidoPayload();
                int i = 0;

                painelAcompanharPedido.setCODFILIAL((String) objects[i++]); 
                painelAcompanharPedido.setNUMPED((BigDecimal) objects[i++]); 
                painelAcompanharPedido.setCLIENTE((String) objects[i++]); 
                painelAcompanharPedido.setSTATUSEXT((String) objects[i++]); 
                painelAcompanharPedido.setSTATUS((String) objects[i++]); 
                painelAcompanharPedido.setORDEM((BigDecimal) objects[i++]); 
                painelAcompanharPedido.setDTPEDIDO((Date) objects[i++]); 
                painelAcompanharPedido.setPOSICAO((String) objects[i++]); 
                painelAcompanharPedido.setCODFUNCSEP((BigDecimal) objects[i++]); 
                painelAcompanharPedido.setFUNCSEP((String) objects[i++]); 
                painelAcompanharPedido.setDATAINICIOSEP((Date) objects[i++]); 
                painelAcompanharPedido.setDATAFIMSEP((Date) objects[i++]); 
                painelAcompanharPedido.setCODFUNCBALCAO((BigDecimal) objects[i++]); 
                painelAcompanharPedido.setFUNCBALC((String) objects[i++]); 
                painelAcompanharPedido.setDATAINICIOBALCAO((Date) objects[i++]); 
                painelAcompanharPedido.setDATAFIMBALCAO((Date) objects[i++]); 
                painelAcompanharPedido.setTEMPOTOTAL((BigDecimal) objects[i++]); 
                painelAcompanharPedido.setTEMPOSEP((BigDecimal) objects[i++]); 
                painelAcompanharPedido.setTEMPOBALC((BigDecimal) objects[i++]); 
                painelAcompanharPedido.setORIGINAL((String) objects[i++]); 
                painelAcompanharPedido.setRETIRA((String) objects[i++]); 
                painelAcompanharPedido.setCODVENDEDOR((BigDecimal) objects[i++]); 
                painelAcompanharPedido.setVENDEDOR((String) objects[i++]); 
                painelAcompanharPedido.setDESCBUTTON((String) objects[i++]); 
               
                PainelAcompanharPedidoResult.add(painelAcompanharPedido);
            }
        }

        return PainelAcompanharPedidoResult;
    }

    public List<PainelDePedidoPorProdutoPayload> getDadosPainelDoResultSet(List<Object[]> results) {
        List<PainelDePedidoPorProdutoPayload> PainelDePedidoPorProdutoResult = new ArrayList<>();

        if (results != null) {
            for (Object[] objects : results) {
                PainelDePedidoPorProdutoPayload painelDePedidoPorProduto = new PainelDePedidoPorProdutoPayload();
                int i = 0;

                painelDePedidoPorProduto.setNumped((BigDecimal) objects[i++]); 
                painelDePedidoPorProduto.setCliente((String) objects[i++]); 
                painelDePedidoPorProduto.setCodprod((BigDecimal) objects[i++]); 
                painelDePedidoPorProduto.setDescricao((String) objects[i++]); 
                painelDePedidoPorProduto.setQt((BigDecimal) objects[i++]); 
                painelDePedidoPorProduto.setQtestger((BigDecimal) objects[i++]); 
                painelDePedidoPorProduto.setDatapedido((Date) objects[i++]); 
                painelDePedidoPorProduto.setTiposeparacao((String) objects[i++]); 
                painelDePedidoPorProduto.setStatus((String) objects[i++]); 
                painelDePedidoPorProduto.setDatachegadacli((Date) objects[i++]);
                painelDePedidoPorProduto.setPosicaopedido((String) objects[i++]); 
                painelDePedidoPorProduto.setDatainiciosep((Date) objects[i++]);
                painelDePedidoPorProduto.setDatafimsep((Date) objects[i++]);
                painelDePedidoPorProduto.setPosicao((String) objects[i++]); 
               
                PainelDePedidoPorProdutoResult.add(painelDePedidoPorProduto);
            }
        }

        return PainelDePedidoPorProdutoResult;
    }
    
    public List<PainelAcompanhaPedidoPayload> findByFiltro(PainelAcompanhaPedidoFilter filter) {
        String andWhere = "";
        if (filter.getDataPedidoDe() != null) {
            andWhere += " and TRUNC(T.DATAPEDIDO) >= :dataPedidoDe ";
        }
        if (filter.getDataPedidoAte() != null) {
            andWhere += " and TRUNC(T.DATAPEDIDO) <= :dataPedidoAte";
        }
        if (filter.getNomeCliente() != null) {
            andWhere += " and C.CLIENTE like :nomeCliente";
        }
        if (filter.getNomeVendedor() != null) {
            andWhere += " and V.NOME like :nomeVendedor";
        }
        
        Query nativeQuery = entityManager.createNativeQuery(getSeparacaoDePedido(andWhere));
        
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

    public List<PainelDePedidoPorProdutoPayload> findAllPainelProduto(List<BigDecimal> filter) {
        
        int sublistSize = 500;

        int numberOfSublists = (int) Math.ceil((double) filter.size() / sublistSize);
        List<List<BigDecimal>> sublists = new ArrayList<>();

        for (int i = 0; i < numberOfSublists; i++) {
            int startIndex = i * sublistSize;
            int endIndex = Math.min(startIndex + sublistSize, filter.size());

            sublists.add(filter.subList(startIndex, endIndex));
        }
        int contador = 0;
        List<Object[]> results = new ArrayList<>();
        for (List<BigDecimal> sublist : sublists) {           
           
                List<Object[]> resultDoFor = entityManager.createNativeQuery(getSeparacaoDePedido(" and tpc.NUMPED in :numped "))
                        .setParameter("numped", sublist)
                            .getResultList();
                results.addAll(resultDoFor);            
        }        
        return getDadosPainelDoResultSet(results);
    }  

    public List<PainelAcompanhaPedidoPayload> findAllPainel() {
        List<Object[]> results = entityManager.createNativeQuery(getSeparacaoDePedido(""))
                .getResultList();
        return getDadosDoResultSet(results);
    }  
    
    public List<PainelAcompanhaPedidoPayload> findById(BigDecimal NUMPED){
        List<Object[]> results = entityManager.createNativeQuery(getSeparacaoDePedido(" and T.NUMPED like :numped "))
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

   
}