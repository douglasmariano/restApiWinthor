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
public class PainelAcompanhaPedidoService {

    @PersistenceContext
    private EntityManager entityManager;

    public String getPainelAcompanhamentoPedido(String andWhere) {
        return  " Select T.CODFILIAL  "+
                "       ,T.NUMPED  "+
                "       ,(Case When REPLACE(REPLACE(REPLACE(V.CPF,'.',''),'/',''),'-','') = REPLACE(REPLACE(REPLACE(C.CGCENT,'.',''),'/',''),'-','')  "+
                "                       Then NVL((Select TRIM(P.OBS2) From PCPEDC P Where P.NUMPED = T.NUMPED),C.CLIENTE)  "+
                "                           Else C.CLIENTE  "+
                "                End) CLIENTE  "+
                "       ,case When T.STATUS = 'A' Then 'Aguardando Cliente'  "+
                "             When T.STATUS = 'B' Then 'Balcão'  "+
                "             When T.STATUS = 'E' Then 'Em Separação'  "+
                "             When T.STATUS = 'G' Then 'Entrega'  "+
                "             When T.STATUS = 'L' Then 'Em Separação'  "+
                "             When T.STATUS = 'F' Then 'Conferência'  "+
                "             When T.STATUS = 'N' Then 'Digitado'  "+
                "             When T.STATUS = 'P' Then 'Pacote'  "+
                "             When T.STATUS = 'R' Then 'Retira'  "+
                "             When T.STATUS = 'H' Then 'Vendedor chamou Cliente'  "+
                "             When T.STATUS = 'T' Then 'Corte'  "+
                "             When T.STATUS = 'X' Then 'Caixa'  "+
                "        end STATUSEXT  "+
                "       ,T.STATUS  "+
                "       ,DECODE(T.STATUS,'T',0,'N',1,'A',2,'H',3,'B',4,'R',5,'F',6,'E',7,'X',8,'P',9,'L',10,'G',11) ORDEM  "+
                "       ,NVL(DATACHEGADACLI,DATAPEDIDO) DTPEDIDO  "+
                "       ,T.POSICAO  "+
                "       ,T.CODFUNCSEP  "+
                "       ,S.NOME_GUERRA FUNCSEP  "+
                "       ,T.DATAINICIOSEP  "+
                "       ,T.DATAFIMSEP  "+
                "       ,T.CODFUNCBALCAO  "+
                "       ,B.NOME_GUERRA FUNCBALC  "+
                "       ,T.DATAINICIOBALCAO  "+
                "       ,T.DATAFIMBALCAO  "+
                "       ,round((to_number(TO_DATE(TO_CHAR(sysdate,'HH24:MI'),'HH24:MI') - TO_DATE(to_CHAR(NVL(DATACHEGADACLI,DATAPEDIDO),'HH24:MI'), 'hh24:mi')) * 1440)) TEMPOTOTAL  "+
                "       ,Case When T.DATAINICIOSEP Is Not Null Then  "+
                "               Case When T.DATAFIMSEP is Null Then round((to_number(TO_DATE(TO_CHAR(sysdate,'HH24:MI'),'HH24:MI') - TO_DATE(to_CHAR(T.DATAINICIOSEP,'HH24:MI'), 'hh24:mi')) * 1440))  "+
                "                    Else round((to_number(TO_DATE(TO_CHAR(T.DATAFIMSEP,'HH24:MI'),'HH24:MI') - TO_DATE(to_CHAR(T.DATAINICIOSEP,'HH24:MI'), 'hh24:mi')) * 1440))  "+
                "               End  "+
                "             Else 0  "+
                "        End TEMPOSEP  "+
                "       ,Case When T.DATAINICIOBALCAO Is Not Null Then  "+
                "               Case When T.DATAFIMBALCAO is Null Then round((to_number(TO_DATE(TO_CHAR(sysdate,'HH24:MI'),'HH24:MI') - TO_DATE(to_CHAR(T.DATAINICIOBALCAO,'HH24:MI'), 'hh24:mi')) * 1440))  "+
                "                    Else round((to_number(TO_DATE(TO_CHAR(DATAFIMBALCAO,'HH24:MI'),'HH24:MI') - TO_DATE(to_CHAR(T.DATAINICIOBALCAO,'HH24:MI'), 'hh24:mi')) * 1440))  "+
                "               End  "+
                "             Else 0  "+
                "        End TEMPOBALC  "+
                "       ,T.ORIGINAL  "+
                "       ,T.RETIRA  "+
                "       ,T.CODUSUR CODVENDEDOR "+
                "       ,substr(V.NOME,1,60) VENDEDOR  "+
                "       ,(case when T.CODFUNCSEP is null then 'false'  "+
                "              when T.DATAFIMSEP is not null or t.posicao = 'F' then 'true'  "+
                "              else 'false'  "+
                "         end) DESCBUTTON  "+
                "   From TAB_PEDIDOC T  "+
                "       ,PCCLIENT    C  "+
                "       ,PCEMPR      S  "+
                "       ,PCEMPR      B  "+
                "       ,PCUSUARI    V  "+
                "  Where T.CODCCLI           = C.CODCLI  "+
                "    And T.CODUSUR           = V.CODUSUR  "+
                "    And T.CODFUNCSEP        = S.MATRICULA(+)  "+
                "    And T.CODFUNCBALCAO     = B.MATRICULA(+)  "+
             //   "    And NVL(TRUNC(T.DATACHEGADACLI),TRUNC(T.DATAPEDIDO)) Between sysdate - 8 and sysdate   "+
                "    And DECODE(T.STATUS,'T',0,'N',1,'A',2,'H',3,'B',4,'R',5,'F',6,'E',7,'X',8,'P',9,'L',10,'G',11) in (0,1,2,3,4,5,6,7,8,9,10,11) "+
                 andWhere +
                "  Order By NVL(T.DATACHEGADACLI,T.DATAPEDIDO) Desc,T.codccli, T.CODFILIAL, ORDEM   ";
    }
    
    
    public String getPainelPorProduto(String andWhere) {
        return 
                "           SELECT " +
                "               tpc.NUMPED, " +
                "               c.CLIENTE , " +
                "               tp.CODPROD, " +
                "               pd.DESCRICAO , " +
                "               tp.QT , " +
                "               est.QTESTGER , " +
                "               tpc.DATAPEDIDO, " +
                "               CASE " +
                "                   WHEN pd.RUA BETWEEN 1 AND 199 THEN 'GERAL' " +
                "                   WHEN pd.RUA = 300 THEN 'CABO' " +
                "                   WHEN pd.RUA BETWEEN 200 AND 299 THEN 'GALPAO' " +
                "                   ELSE 'OUTROS' " +
                "               END AS tipoSeparacao, " +
                "               tpc.STATUS, " +
                "               tpc.DATACHEGADACLI, " +
                "               CASE " +
                "                   WHEN tpc.retira = 'S' THEN 'RETIRA' " +
                "                   WHEN tpc.retira = 'G' THEN 'ENTREGA' " +
                "                   WHEN tpc.retira = 'N' " +
                "                       AND tpc.status = 'N' THEN 'NADA' " +
                "                   WHEN tpc.posicao = 'F' " +
                "                       AND tpc.retira = 'S' THEN 'RETIRA' " +
                "                   WHEN tpc.posicao = 'F' " +
                "                       AND tpc.retira = 'G' THEN 'ENTREGA' " +
                "                   WHEN (tpc.status = 'P' " +
                "                       OR tpc.status = 'N' " +
                "                       OR tpc.status = 'B' " +
                "                       OR tpc.status = 'E' " +
                "                       OR tpc.status = 'F') " +
                "                           AND (tpc.posicao = 'F' " +
                "                           OR tpc.posicao = 'M' " +
                "                           OR tpc.posicao = 'B') " +
                "                               AND tpc.retira = 'N' THEN 'BALCAO' " +
                "                   WHEN tpc.posicao = 'C' THEN 'CANCELADO' " +
                "                   WHEN tpc.status = 'X' THEN 'CAIXA' " +
                "                   ELSE 'ERROR' " +
                "               END AS posicaopedido, " +
                "               tpc.DATAINICIOSEP," +
                "               tpc.DATAFIMSEP," +
                "               tpc.POSICAO " +    
                "           FROM " +
                "               TAB_PEDIDOI tp " +
                "           INNER JOIN pcprodut pd ON " +
                "               tp.CODPROD = pd.CODPROD " +
                "           INNER JOIN TAB_PEDIDOC tpc ON " +
                "               tpc.NUMPED = tp.NUMPED " +
                "           INNER JOIN pcclient c ON " +
                "               c.CODCLI = tpc.CODCCLI " +
                "           INNER JOIN PCEST est ON " +
                "               est.CODFILIAL = tpc.CODFILIAL " +
                "               AND est.CODPROD = tp.CODPROD " +
                "           WHERE  1 = 1" +
                andWhere+                
                "           GROUP BY " +
                "               tpc.NUMPED, " +
                "               c.CLIENTE, " +
                "               tp.CODPROD, " +
                "               pd.DESCRICAO , " +
                "               tp.QT , " +
                "               est.QTESTGER, " +
                "               tpc.DATAPEDIDO, " +
                "               pd.RUA, " +
                "               tpc.STATUS, " +
                "               tpc.DATACHEGADACLI , " +
                "               tpc.DATAINICIOSEP , " +
                "               tpc.DATAFIMSEP, " +
                "               tpc.retira, " +
                "               tpc.posicao " +
                "           ORDER BY " +
                "               tpc.NUMPED, " +
                "               pd.RUA ";
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
        
        Query nativeQuery = entityManager.createNativeQuery(getPainelAcompanhamentoPedido(andWhere));
        
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
           
                List<Object[]> resultDoFor = entityManager.createNativeQuery(getPainelPorProduto(" and tpc.NUMPED in :numped "))
                        .setParameter("numped", sublist)
                            .getResultList();
                results.addAll(resultDoFor);            
        }        
        return getDadosPainelDoResultSet(results);
    }  

    public List<PainelAcompanhaPedidoPayload> findAllPainel() {
        List<Object[]> results = entityManager.createNativeQuery(getPainelAcompanhamentoPedido(""))
                .getResultList();
        return getDadosDoResultSet(results);
    }  
    
    public List<PainelAcompanhaPedidoPayload> findById(BigDecimal NUMPED){
        List<Object[]> results = entityManager.createNativeQuery(getPainelAcompanhamentoPedido(" and T.NUMPED like :numped "))
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