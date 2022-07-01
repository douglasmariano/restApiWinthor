package com.ajel.services;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.ajel.controller.payloads.PainelAcompanhaPedidoPayload;

@Service
public class PainelAcompanhaPedidoService {

    @PersistenceContext
    private EntityManager entityManager;

    public String getPainelAcompanhamentoPedido() {
        return " SELECT tpc.NUMPED,c.CLIENTE , tp.CODPROD,pd.DESCRICAO , tp.QT  ,est.QTESTGER , tpc.DATAPEDIDO," +
                " CASE   " +
                "    WHEN pd.RUA BETWEEN 1 AND 199 THEN 'GERAL'" +
                "    WHEN pd.RUA = 300 THEN 'CABO'" +
                "    WHEN pd.RUA BETWEEN 200 AND 299 THEN 'GALPAO'" +
                "    ELSE 'OUTROS' " +
                "    END AS tipoSeparacao," +
                "    tpc.STATUS," +
                "    tpc.DATACHEGADACLI, " +
                "    CASE" +
                "        WHEN tpc.retira = 'S'  THEN 'RETIRA'   " +
                "        WHEN tpc.retira = 'G'  THEN 'ENTREGA' " +
                "        WHEN tpc.posicao = 'F' and tpc.retira = 'S' THEN 'RETIRA'" +
                "                 WHEN tpc.posicao <> 'N' and tpc.retira = 'N' THEN 'BALCAO'" +
                "                 WHEN tpc.posicao = 'F' and tpc.retira = 'G' THEN 'ENTREGA'" +
                "        WHEN tpc.posicao = 'C' THEN 'CANCELADO'            " +
                "        WHEN tpc.retira = 'N' AND tpc.status = 'N' THEN 'NADA'" +
                "   ELSE 'ERROR' END as posicao" +
                "    FROM TAB_PEDIDOI tp" +
                " INNER JOIN pcprodut pd on tp.CODPROD = pd.CODPROD" +
                " INNER JOIN TAB_PEDIDOC tpc ON tpc.NUMPED = tp.NUMPED" +
                " INNER JOIN pcclient c ON c.CODCLI = tpc.CODCCLI" +
                " INNER JOIN PCEST est ON est.CODFILIAL = tpc.CODFILIAL AND est.CODPROD = tp.CODPROD " +
                " WHERE trunc(tpc.DATAPEDIDO)  = trunc(sysdate)" +
                " AND tpc.STATUS NOT IN ('P', 'C')" +
                " GROUP BY tpc.NUMPED, c.CLIENTE,tp.CODPROD,pd.DESCRICAO ,tp.QT ,est.QTESTGER, tpc.DATAPEDIDO, pd.RUA,tpc.STATUS,"+
                "    tpc.DATACHEGADACLI ,tpc.DATAINICIOSEP ,tpc.DATAFIMSEP, tpc.retira, tpc.posicao" +
                " ORDER BY tpc.NUMPED, pd.RUA ";
    }

    public List<PainelAcompanhaPedidoPayload> getDadosDoResultSet(List<Object[]> results) {
        List<PainelAcompanhaPedidoPayload> PainelAcompanharPedidoResult = new ArrayList<>();

        if (results != null) {
            for (Object[] objects : results) {
                PainelAcompanhaPedidoPayload painelAcompanharPedido = new PainelAcompanhaPedidoPayload();
                int i = 0;

                painelAcompanharPedido.setNUMPED((BigDecimal) objects[i++]);
                painelAcompanharPedido.setCLIENTE((String) objects[i++]);
                painelAcompanharPedido.setCODPROD((BigDecimal) objects[i++]);
                painelAcompanharPedido.setDESCRICAO((String) objects[i++]);
                painelAcompanharPedido.setQT((BigDecimal) objects[i++]);
                painelAcompanharPedido.setQTESTGER((BigDecimal) objects[i++]);
                painelAcompanharPedido.setDATAPEDIDO(getLocalDateTime(objects[i++]));
                painelAcompanharPedido.setTIPOSEPARACAO((String) objects[i++]);
                painelAcompanharPedido.setSTATUS((String) objects[i++]);
                painelAcompanharPedido.setDATACHEGADACLI(getLocalDateTime(objects[i++]));
                painelAcompanharPedido.setPOSICAO((String) objects[i++]);
               
                PainelAcompanharPedidoResult.add(painelAcompanharPedido);
            }
        }

        return PainelAcompanharPedidoResult;
    }

   

    public List<PainelAcompanhaPedidoPayload> findAllPainel() {
        List<Object[]> results = entityManager.createNativeQuery(getPainelAcompanhamentoPedido())
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