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

import com.ajel.controller.payloads.PainelAcompanhaSeparacaoPayload;

@Service
public class PainelAcompanhaSeparacaoService {

    @PersistenceContext
    private EntityManager entityManager;

    public String getPainelAcompanhamentoSeparacao() {
        return  " SELECT * from( "+
                " SELECT "+
                "     TO_CHAR(FLOOR((SYSDATE - t.datapedido) * 24), 'FM00') || ':' || TO_CHAR(MOD(FLOOR((SYSDATE - t.datapedido) * 24 * 60), 60), 'FM00') AS tempodecorrido, "+
                "     LISTAGG(als.LOCALSEPARACAO, ', ') WITHIN GROUP (ORDER BY als.LOCALSEPARACAO) AS LOCALSEPARACAO, "+
                "     CASE "+
                "         WHEN t.retira = 'S' THEN 'RETIRA' "+
                "         WHEN t.retira = 'G' THEN 'ENTREGA' "+
                "         WHEN t.retira = 'N' AND t.status = 'N' THEN 'NADA' "+
                "         WHEN t.posicao = 'F' AND t.retira = 'S' THEN 'RETIRA' "+
                "         WHEN t.posicao = 'F' AND t.retira = 'G' THEN 'ENTREGA' "+
                "         WHEN (t.status IN ('P', 'N', 'B', 'E', 'F') AND t.posicao IN ('F', 'M', 'B') AND t.retira = 'N') THEN 'BALCAO' "+
                "         WHEN t.posicao = 'C' THEN 'CANCELADO' "+
                "         ELSE 'ERROR' "+
                "     END AS tiposeparacao, "+
                "     t.numped, "+
                "     t.codusur AS codigovendedor, "+
                "     pcu.nome, "+
                "     t.codccli AS codigocliente, "+
                "     pcc.cliente, "+
                "     t.vltotal, "+
                "     t.posicao, "+
                "     t.datapedido, "+
                "     t.datachegadacli, "+
                "     t.codfilial, "+
                "     t.qtitem, "+
                "     ( "+
                "         SELECT "+
                "             COUNT(*) "+
                "         FROM "+
                "             PCMENS "+
                "         WHERE "+
                "             REGEXP_LIKE(mens1, '^[[:digit:]]+$') AND mens1 = TO_CHAR(t.numped) "+
                "     ) AS viasimpressas, "+
                "     ( "+
                "         SELECT "+
                "             COUNT(*) "+
                "         FROM "+
                "             PCMENS "+
                "         WHERE "+
                "             REGEXP_LIKE(mens1, '^[[:digit:]]+$') AND mens1 = TO_CHAR(t.numped) AND mens8 LIKE '8030' "+
                "     ) AS viasimpressasgalpao "+
                " FROM "+
                "     TAB_PEDIDOC t "+
                " LEFT JOIN AJEL_LOCALSEPARACAO als ON t.numped = als.numped "+
                " LEFT JOIN pcclient pcc ON t.codccli = pcc.codcli "+
                " LEFT JOIN PCUSUARI pcu ON t.codusur = pcu.codusur "+
                " WHERE "+
                "     trunc(t.DATAPEDIDO) = trunc(SYSDATE) - 365 "+
                "     AND t.DATAINICIOSEP IS NULL "+
                "     AND t.POSICAO NOT IN ('F', 'C', 'L') "+
                " GROUP BY "+
                "     TO_CHAR(FLOOR((SYSDATE - t.datapedido) * 24), 'FM00') || ':' || TO_CHAR(MOD(FLOOR((SYSDATE - t.datapedido) * 24 * 60), 60), 'FM00'), "+
                "      CASE "+
                "         WHEN t.retira = 'S' THEN 'RETIRA' "+
                "         WHEN t.retira = 'G' THEN 'ENTREGA' "+
                "         WHEN t.retira = 'N' AND t.status = 'N' THEN 'NADA' "+
                "         WHEN t.posicao = 'F' AND t.retira = 'S' THEN 'RETIRA' "+
                "         WHEN t.posicao = 'F' AND t.retira = 'G' THEN 'ENTREGA' "+
                "         WHEN (t.status IN ('P', 'N', 'B', 'E', 'F') AND t.posicao IN ('F', 'M', 'B') AND t.retira = 'N') THEN 'BALCAO' "+
                "         WHEN t.posicao = 'C' THEN 'CANCELADO' "+
                "         ELSE 'ERROR' "+
                "     END, "+
                "     t.numped, "+
                "     t.codusur, "+
                "      pcu.nome, "+
                "     t.codccli, "+
                "     pcc.cliente, "+
                "     t.vltotal, "+
                "     t.posicao, "+
                "     t.datapedido, "+
                "     t.datachegadacli, "+
                "     t.codfilial, "+
                "     t.qtitem) tabelaseparacao "+
                " ORDER BY "+
                " CASE WHEN tiposeparacao = 'NADA' THEN 1 ELSE 0 END, "+
                "     3, "+
                "     1 ";
    }
  

    public List<PainelAcompanhaSeparacaoPayload> getDadosDoResultSet(List<Object[]> results) {
        List<PainelAcompanhaSeparacaoPayload> PainelAcompanharSeparacaoResult = new ArrayList<>();

        if (results != null) {
            for (Object[] objects : results) {
                PainelAcompanhaSeparacaoPayload painelAcompanharSeparacao = new PainelAcompanhaSeparacaoPayload();
                int i = 0;

                painelAcompanharSeparacao.setTempodecorrido((String) objects[i++]);
                painelAcompanharSeparacao.setLocalseparacao((String) objects[i++]);
                painelAcompanharSeparacao.setTiposeparacao((String) objects[i++]);
                painelAcompanharSeparacao.setNumped((BigDecimal) objects[i++]);
                painelAcompanharSeparacao.setCodigovendedor((BigDecimal) objects[i++]);
                painelAcompanharSeparacao.setNome((String) objects[i++]);
                painelAcompanharSeparacao.setCodigocliente((BigDecimal) objects[i++]);
                painelAcompanharSeparacao.setCliente((String) objects[i++]);
                painelAcompanharSeparacao.setVltotal((BigDecimal) objects[i++]);
                painelAcompanharSeparacao.setPosicao((String) objects[i++]);
                painelAcompanharSeparacao.setDatapedido((Date) objects[i++]);
                painelAcompanharSeparacao.setDatachegadacli((Date) objects[i++]);
                painelAcompanharSeparacao.setCodfilial((String) objects[i++]);
                painelAcompanharSeparacao.setQtitem((BigDecimal) objects[i++]);
                painelAcompanharSeparacao.setViasimpressas((BigDecimal) objects[i++]);
                painelAcompanharSeparacao.setViasimpressasgalpao((BigDecimal) objects[i++]);
               
                PainelAcompanharSeparacaoResult.add(painelAcompanharSeparacao);
            }
        }

        return PainelAcompanharSeparacaoResult;
    } 
    
    
    public List<PainelAcompanhaSeparacaoPayload> findAllPainel() {
        List<Object[]> results = entityManager.createNativeQuery(getPainelAcompanhamentoSeparacao())
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