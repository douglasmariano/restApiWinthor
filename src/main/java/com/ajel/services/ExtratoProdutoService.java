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

import com.ajel.controller.payloads.ExtratoProdutoPayload;
import com.ajel.controller.payloads.ProdutoEstoquePayload;
import com.ajel.repository.filter.ExtratoProdutoFilter;
import com.ajel.repository.filter.ProdutoEstoqueFilter;

@Service
public class ExtratoProdutoService {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public String getExtratoProduto(){
		return 	" SELECT DTMOV " +
		        "      , HORA " +
		        "      , CODOPER " +
		        "      , NOMECODOPER " +
		        "      , HISTORICO " +
		        "      , HISTORICO2 " +
		        "      , NUMCAR " +
		        "      , NUMOP " +
		        "      , NUMTRANSENT " +
		        "      , NUMTRANSVENDA " +
		        "      , CODUSUR " +
		        "      , CODCLI " +
		        "      , CLIENTE " +
		        "      , CGC " +
		        "      , FANTASIA " +
		        "      , NUMNOTA " +
		        "      , NUMSEQ " +
		        "      , NUMSEQPED " +
		        "      , PUNIT " +
		        "      , QTENTRADA " +
		        "      , QTSAIDA " +
		        "      , NUMLOTE " +
		        "      , ROWNUM " +
		        " FROM ( " +
		        " SELECT TRUNC(PCMOV.DTMOV) DTMOV " +
		        "      , TO_CHAR(DTMOVLOG, 'HH24:MI') HORA " +
		        "      , PCMOV.CODOPER " +
		        "      , PCMOV.NUMOP" +
		        "      , PCMOV.NUMSEQ" +
		        "      , PCMOV.NUMSEQPED" +
		        "      , ROWNUM" +
		        " , DECODE(PCMOV.CODOPER , 'E', DECODE(GREATEST(PCMOV.QT,0),0,'Entrada Cancelada','Entrada Merc.')" +
		        "                              ,'EB',DECODE(GREATEST(PCMOV.QT,0),0,'Bonif. Cancelada','Entrada Bonific.')" +
		        "                              ,'ET',DECODE(GREATEST(PCMOV.QT,0),0,'Entrada Transf. Cancelada','Entrada Transf.')" +
		        "                              ,'EA',DECODE(GREATEST(PCMOV.QT,0),0,'Entrada Ajuste Cancelada','Ajuste Estoque')" +
		        "                              ,'E1',DECODE(GREATEST(PCMOV.QT,0),0,'Entrada Avaria Cancelada','Entrada Avaria')" +
		        "                              ,'EI',DECODE(GREATEST(PCMOV.QT,0),0,'Ajuste Invent. Cancelado','Ajuste Invent.')" +
		        "                              ,'ED',DECODE(GREATEST(PCMOV.QT,0),0,'Devolução Cancelada','Dev. Cliente')" +
		        "                              ,'EN',DECODE(GREATEST(PCMOV.QT,0),0,'Dev. Venda Consig. Cancelada','Dev. Venda Consignada')" +
		        "                              ,'ER',DECODE(GREATEST(PCMOV.QT,0),0,'Simples Remessa Cancelada','Simples Remessa')" +
		        "                              ,'ES',DECODE(GREATEST(PCMOV.QT,0),0,'Sobra Mercadoria Cancelamento','Sobra de Mercadoria')" +
		        "                              ,'EM',DECODE(GREATEST(PCMOV.QT,0),0,'Ent. Mat. Consumo Cancelada','Entrada Materiais de Consumo')" +
		        "                              ,'EC',DECODE(GREATEST(PCMOV.QT,0),0,'Ent. Consig. Cancelada','Entrada Consignação')" +
		        "                              ,'EO',DECODE(GREATEST(PCMOV.QT,0),0,'Dev. Comodato Cancelada','Devolução de Comodato')" +
		        "                              ,'EX',DECODE(GREATEST(PCMOV.QT,0),0,'Dev. Avulsa Cancelada','Devolução Avulsa')" +
		        "                              ,'EG',DECODE(GREATEST(PCMOV.QT,0),0,'Entrada Benefic. Cancelada','Entrada de Beneficiamento')" +
		        "                              ,'S', DECODE(GREATEST(PCMOV.QT,0),0,'NF Cancelada','Saida')" +
		        "                              ,'SD',DECODE(GREATEST(PCMOV.QT,0),0,'Dev. Cancelada','Dev. Fornecedor')" +
		        "                              ,'SB',DECODE(GREATEST(PCMOV.QT,0),0,'Saida Bonific. Cancelada','Saida Bonific.')" +
		        "                              ,'ST',DECODE(GREATEST(PCMOV.QT,0),0,'Saida Transf. Cancelada','Saida Transf.')" +
		        "                              ,'S1',DECODE(GREATEST(PCMOV.QT,0),0,'Avaria Reaprov. Cancelada','Avaria por Reaproveitamento')" +
		        "                              ,'SS',DECODE(GREATEST(PCMOV.QT,0),0,'Saída Sobra Cancelada','Saída de Sobra')" +
		        "                              ,'SA',DECODE(GREATEST(PCMOV.QT,0),0,'Saída Ajuste Cancelada','Ajuste Estoque')" +
		        "                              ,'SI',DECODE(GREATEST(PCMOV.QT,0),0,'Ajuste Invent. Cancelado','Ajuste Invent.')" +
		        "                              ,'SR',DECODE(GREATEST(PCMOV.QT,0),0,'Simples Remessa Cancelada','Simples Remessa')" +
		        "                              ,'SC',DECODE(GREATEST(PCMOV.QT,0),0,'Saída Consig. Cancelada','Saída Consignação')" +
		        "                              ,'SO',DECODE(GREATEST(PCMOV.QT,0),0,'Remessa Comodato Cancelada','Remessa de Comodato')" +
		        "                              ,'SF',DECODE(GREATEST(PCMOV.QT,0),0,'Dev. Comodato Fornec. Cancelada','Devolução de Comodato a Fornecedor')" +
		        "                              ,'RA',DECODE(GREATEST(PCMOV.QT,0),0,'Req. Avulsa Cancelada','Requisição Avulsa')" +
		        "                              ,'EP',DECODE(GREATEST(PCMOV.QT,0),0,'Cancelamento Produção','Entrada Produção')" +
		        "                              ,'SP',DECODE(GREATEST(PCMOV.QT,0),0,'Cancelamento Produção','Requisição Mat.Prima')" +
		        "                              ,'SV',DECODE(GREATEST(PCMOV.QT,0),0,'Saída Avaria Cancelada','Saída por Avaria')" +
		        "                              ,'SM',DECODE(GREATEST(PCMOV.QT,0),0,'Saída Mat. Consumo Cancelada','Saída Materiais de Consumo')" +
		        "                              ,'SL',DECODE(GREATEST(PCMOV.QT,0),0,'Saída Perda Cancelada','Saída de Perda')" +
		        "                              ,'EL',DECODE(GREATEST(PCMOV.QT,0),0,'Ent. Perda Cancelada','Entrada de Perda')" +
		        "                              ,'EF',DECODE(GREATEST(PCMOV.QT,0),0,'Entrada Comodato Cancelada','Entrada de Comodato')" +
		        "                              ,'SN',DECODE(GREATEST(PCMOV.QT,0),0,'Saída Benefic. Cancelada','Saída de Beneficiamento')" +
		        "                              ,'EV',DECODE(GREATEST(PCMOV.QT,0),0,'Ent. Dev. Rem. Benefic. Cancelada','Entrada Devolução de Remessa para Beneficiamento')" +
		        "                              ,'EG',DECODE(GREATEST(PCMOV.QT,0),0,'Ent. Benefic. Cancelada','Entrada de Beneficiamento')" +
		        "                              ,'Desconhecido') NOMECODOPER" +
		        "      ,(CASE                                                                                                                                                         " +
		        "         WHEN SUBSTR(PCMOV.CODOPER, 1, 1) = 'S' THEN                                                                                                               " +
		        "          (SELECT /*+ index(PCLANC PCLANC_IDX1)*/                                                                                                                    " +
		        "            PCLANC.HISTORICO  " +
		        "             FROM PCLANC  " +
		        "            WHERE DTLANC = TRUNC(PCMOV.DTMOV)  " +
		        "              AND DTESTORNOBAIXA IS NULL  " +
		        "              AND ROWNUM = 1  " +
		        "              AND NUMTRANSVENDA = PCMOV.NUMTRANSVENDA  " +
		        "              AND (PCMOV.CODOPER) <> 'SP'  " +
		        "              AND PCLANC.historico IS NOT NULL  " +
		        "              AND ROWNUM = 1)  " +
		        "         WHEN SUBSTR(PCMOV.CODOPER, 1, 1) = 'E' THEN  " +
		        "          (SELECT /*+ index(PCLANC PCLANC_IDX1)*/  " +
		        "            PCLANC.HISTORICO   " +
		        "             FROM PCLANC  " +
		        "            WHERE DTLANC = TRUNC(PCMOV.DTMOV)  " +
		        "              AND DTESTORNOBAIXA IS NULL  " +
		        "              AND ROWNUM = 1  " +
		        "              AND NUMTRANSENT = PCMOV.NUMTRANSENT  " +
		        "              AND (PCMOV.CODOPER) NOT IN ('EP', 'EX')  " +
		        "              AND PCLANC.historico IS NOT NULL  " +
		        "              AND ROWNUM = 1)  " +
		        "         ELSE  " +
		        "          ''  " +
		        "       END) HISTORICO  " +
		        "      ,(CASE  " +
		        "         WHEN SUBSTR(PCMOV.CODOPER, 1, 1) = 'S' THEN  " +
		        "          (SELECT /*+ index(PCLANC PCLANC_IDX1)*/  " +
		        "            PCLANC.HISTORICO2  " +
		        "             FROM PCLANC  " +
		        "            WHERE DTLANC = TRUNC(PCMOV.DTMOV)  " +
		        "              AND DTESTORNOBAIXA IS NULL  " +
		        "              AND ROWNUM = 1  " +
		        "              AND NUMTRANSVENDA = PCMOV.NUMTRANSVENDA  " +
		        "              AND (PCMOV.CODOPER) <> 'SP'  " +
		        "              AND PCLANC.historico2 IS NOT NULL  " +
		        "              AND ROWNUM = 1)  " +
		        "         WHEN SUBSTR(PCMOV.CODOPER, 1, 1) = 'E' THEN  " +
		        "          (SELECT /*+ index(PCLANC PCLANC_IDX1)*/  " +
		        "            PCLANC.HISTORICO2  " +
		        "             FROM PCLANC  " +
		        "            WHERE DTLANC = TRUNC(PCMOV.DTMOV)  " +
		        "              AND DTESTORNOBAIXA IS NULL  " +
		        "              AND ROWNUM = 1  " +
		        "              AND NUMTRANSENT = PCMOV.NUMTRANSENT  " +
		        "              AND (PCMOV.CODOPER) NOT IN ('EP', 'EX')  " +
		        "              AND PCLANC.historico2 IS NOT NULL  " +
		        "              AND ROWNUM = 1)  " +
		        "         ELSE  " +
		        "          ''  " +
		        "       END) HISTORICO2  " +
		        "      , NVL(PCMOV.NUMCAR,0) NUMCAR " +
		        "      , NVL(PCMOV.NUMTRANSENT,0) NUMTRANSENT " +
		        "      , NVL(PCMOV.NUMTRANSVENDA,0) NUMTRANSVENDA " +
		        "      , PCMOV.CODUSUR " +
		        "      , CASE WHEN (PCMOV.CODOPER IN ('EP','SP','EA', 'SA', 'S1', 'SL', 'EI', 'SI', 'EL', 'ES','SV')) THEN " +
		        "             PCMOV.CODFUNCLANC " +
		        "        ELSE  " +
		        "             CASE WHEN (PCMOV.CODOPER IN ('E', 'EB', 'ET', 'EG', 'ER', 'EC')) THEN " +
		        "                  PCMOV.CODFORNEC " +
		        "             ELSE " +
		        "                  PCMOV.CODCLI " +
		        "             END " +
		        "        END  CODCLI  " +
		        "      , CASE WHEN (PCMOV.CODOPER IN ('EP','SP','EA', 'SA', 'S1', 'SL', 'EI', 'SI', 'EL', 'ES','SV')) THEN " +
		        "             PCEMPR.NOME " +
		        "        ELSE " +
		        "             CASE WHEN (PCMOV.CODOPER IN ('E', 'EB', 'ET', 'EG', 'ER', 'EC')) THEN " +
		        "                 CASE " +
		        "                     WHEN (CODOPER = 'ET') AND " +
		        "                          (SELECT COUNT(*) " +
		        "                             FROM PCNFENT " +
		        "                            WHERE NUMTRANSENT = PCMOV.NUMTRANSENT " +
		        "                              AND TIPODESCARGA IN ('6', '8')) > 0 THEN " +
		        "                      (SELECT CLIENTE " +
		        "                         FROM PCCLIENT C " +
		        "                        WHERE CODCLI = PCMOV.CODFORNEC) " +
		        "                     ELSE" +
		        "                      PCFORNEC.FORNECEDOR END" +
		        "             ELSE" +
		        "                  PCCLIENT.CLIENTE" +
		        "             END" +
		        "        END CLIENTE" +
		        "      , CASE WHEN (PCMOV.CODOPER IN ('EP','SP','EA', 'SA', 'EI', 'SI', 'S1', 'SL', 'EL', 'ES', 'SV')) THEN" +
		        "             PCEMPR.CPF" +
		        "        ELSE" +
		        "             CASE WHEN (PCMOV.CODOPER IN ('E', 'EB', 'ET', 'EG', 'ER', 'SD')) THEN" +
		        "                 CASE" +
		        "                     WHEN (CODOPER = 'ET') AND" +
		        "                          (SELECT COUNT(*)" +
		        "                             FROM PCNFENT" +
		        "                            WHERE NUMTRANSENT = PCMOV.NUMTRANSENT" +
		        "                              AND TIPODESCARGA IN ('6', '8')) > 0 THEN" +
		        "                      (SELECT CGCENT" +
		        "                         FROM PCCLIENT C" +
		        "                        WHERE CODCLI = PCMOV.CODFORNEC)" +
		        "                     ELSE" +
		        "                      PCFORNEC.CGC END" +
		        "             ELSE" +
		        "                  PCCLIENT.CGCENT" +
		        "             END" +
		        "        END CGC" +
		        "      , CASE WHEN (PCMOV.CODOPER IN ('EP','SP','EA', 'SA', 'EI', 'SI', 'S1', 'SL', 'EL', 'ES', 'SV')) THEN" +
		        "             PCEMPR.NOME" +
		        "        ELSE" +
		        "             CASE WHEN (PCMOV.CODOPER IN ('E', 'EB', 'ET', 'EG', 'ER', 'SD')) THEN" +
		        "                 CASE" +
		        "                     WHEN (CODOPER = 'ET') AND" +
		        "                          (SELECT COUNT(*)" +
		        "                             FROM PCNFENT" +
		        "                            WHERE NUMTRANSENT = PCMOV.NUMTRANSENT" +
		        "                              AND TIPODESCARGA IN ('6', '8')) > 0 THEN" +
		        "                      (SELECT FANTASIA" +
		        "                         FROM PCCLIENT C" +
		        "                        WHERE CODCLI = PCMOV.CODFORNEC)" +
		        "                     ELSE" +
		        "                      PCFORNEC.FANTASIA END" +
		        "             ELSE" +
		        "                  PCCLIENT.FANTASIA" +
		        "             END" +
		        "        END FANTASIA" +
		        "      , PCMOV.NUMNOTA" +
		        "      , NVL(PCMOV.PUNIT,0) PUNIT" +
		        "      , CASE WHEN (SUBSTR(PCMOV.CODOPER,1,1) = 'E') OR (SUBSTR(PCMOV.CODOPER,1,1) = 'D') THEN" +
		        "             CASE WHEN (DECODE(NVL(PCMOVCOMPLE.QTRETORNOTV13, 0), 0, NVL(PCMOV.QT, 0), PCMOVCOMPLE.QTRETORNOTV13) > 0) THEN" +
		        "                  DECODE(NVL(PCMOVCOMPLE.QTRETORNOTV13, 0), 0, NVL(PCMOV.QT, 0), PCMOVCOMPLE.QTRETORNOTV13)" +
		        "             END " +
		        "        ELSE " +
		        "             CASE WHEN (DECODE(NVL(PCMOVCOMPLE.QTRETORNOTV13, 0), 0, NVL(PCMOV.QT, 0), PCMOVCOMPLE.QTRETORNOTV13) < 0) THEN " +
		        "                  NVL((DECODE(NVL(PCMOVCOMPLE.QTRETORNOTV13, 0), 0, NVL(PCMOV.QT, 0), PCMOVCOMPLE.QTRETORNOTV13)*(-1)),0) " +
		        "             END " +
		        "        END QTENTRADA " +
		        "      , CASE WHEN (SUBSTR(PCMOV.CODOPER,1,1) = 'S') OR (SUBSTR(PCMOV.CODOPER,1,1) = 'R') THEN " +
		        "             CASE WHEN (PCMOV.QT > 0) THEN " +
		        "                   NVL(PCMOV.QT*(-1),0) " +
		        "             END " +
		        "        ELSE " +
		        "             CASE WHEN (PCMOV.QT < 0) THEN " +
		        "                  NVL(PCMOV.QT,0) " +
		        "             END " +
		        "        END QTSAIDA " +
		        "      , PCMOV.NUMLOTE " +
		        "   FROM PCMOV " +
		        "      , PCEMPR " +
		        "      , PCCLIENT " +
		        "      , PCFORNEC " +
		        "      , PCPRODUT " +
		        "      , PCMOVCOMPLE " +
		        "  WHERE PCMOV.CODPROD = :CODPROD"  +
		        "    AND PCMOV.CODPROD = PCPRODUT.CODPROD " +
		        "    AND PCMOV.NUMTRANSITEM = PCMOVCOMPLE.NUMTRANSITEM(+) " +
		        "    AND NVL(PCMOVCOMPLE.MOVEST, 'S') = 'S'  " +
		        "    AND PCMOV.CODFORNEC = PCFORNEC.CODFORNEC(+) " +
		        "    AND PCMOV.CODFUNCLANC = PCEMPR.MATRICULA(+) " +
		        "    /*AND PCMOV.CODUSUR = PCEMPR.MATRICULA(+)*/ " +
		        "    AND PCMOV.CODCLI = PCCLIENT.CODCLI(+)" +
		        "    AND TRUNC(PCMOV.DTMOV) BETWEEN (SELECT MAX(DTMOV) FROM pcmov WHERE codprod = :CODPROD AND codoper = 'E') AND trunc(SYSDATE)" +
		        "    AND NVL(PCMOV.CODFILIALNF, PCMOV.CODFILIAL) = :CODFILIAL" +
		        "    AND PCMOV.STATUS IN ('B','AB')" +
		        "    AND ( NOT EXISTS" +
		        "    (SELECT NUMPED FROM PCPEDC WHERE NUMPED = DECODE(PCMOV.CODOPER, 'EP', -1, 'SP',-1, PCMOV.NUMPED) AND CONDVENDA = 7) OR (SUBSTR(PCMOV.CODOPER,1,1) = 'E'))" +
		        "    AND NOT EXISTS (SELECT DISTINCT (PCNFSAID.NUMTRANSVENDA)" +
		        "            FROM PCNFSAID, PCPRODUT" +
		        "           WHERE PCNFSAID.NUMTRANSVENDA = PCMOV.NUMTRANSVENDA" +
		        "             AND PCNFSAID.CODFILIAL = PCMOV.CODFILIAL" +
		        "             AND PCMOV.CODOPER = 'S'" +
		        "             AND PCNFSAID.CONDVENDA IN (4, 7, 14)" +
		        "             AND PCMOV.CODPROD = PCPRODUT.CODPROD" +
		        "             AND PCPRODUT.TIPOMERC = 'CB')" +
		        "    AND NOT (PCMOV.CODOPER IN ('EA','SA') AND" +
		        "             PCMOVCOMPLE.NUMINVENT IS NOT NULL)" +
		        "     AND NOT (FERRAMENTAS.F_BUSCARPARAMETRO_ALFA('DEVOLVESIMPLESREMTV13TOTAL',PCMOV.CODFILIAL,'N') = 'S'" +
		        "  AND PCMOV.ROTINACAD LIKE '%1332%' AND NVL(PCMOVCOMPLE.QTRETORNOTV13,0) = 0)" +
		        "    AND NOT EXISTS (SELECT NUMNOTA FROM PCNFSAID WHERE NUMTRANSVENDA = PCMOV.NUMTRANSVENDA AND SITUACAONFE IN (110,205,301,302,303))" +
		        " ORDER BY PCMOV.DTMOV, PCMOV.DTMOVLOG, TO_NUMBER(PCMOV.HORALANC), TO_NUMBER(PCMOV.MINUTOLANC)" +
		        "      )" ;
	}
	
	public List<ExtratoProdutoPayload> getDadosDoResultSet(List<Object[]> results) {
		List<ExtratoProdutoPayload> pedidoResult = new ArrayList<>();	    
	    if (results != null) {
	    	for (Object[] objects : results) {
	    	    ExtratoProdutoPayload extratoProduto = new ExtratoProdutoPayload();
	    		int i = 0;
	    			    		
	    		extratoProduto.setDtmov(getLocalDateTime(objects[i++]));
	    		extratoProduto.setHora((String) objects[i++]);
	    		extratoProduto.setCodoper((String) objects[i++]);
	    		extratoProduto.setNomecodoper((String) objects[i++]);
	    		extratoProduto.setHistorico((String) objects[i++]);
	    		extratoProduto.setHistorico2((String) objects[i++]);
	    		extratoProduto.setNumcar((BigDecimal) objects[i++]);
	    		extratoProduto.setNumop((BigDecimal) objects[i++]);
	    		extratoProduto.setNumtransent((BigDecimal) objects[i++]);
	    		extratoProduto.setNumtransvenda((BigDecimal) objects[i++]);
	    		extratoProduto.setCodusur((BigDecimal) objects[i++]);
	    		extratoProduto.setCodcli((BigDecimal) objects[i++]);
	    		extratoProduto.setCliente((String) objects[i++]);
	    		extratoProduto.setCgc((String) objects[i++]);
	    		extratoProduto.setFantasia((String) objects[i++]);
	    		extratoProduto.setNumnota((BigDecimal) objects[i++]);
	    		extratoProduto.setNumseq((BigDecimal) objects[i++]);
	    		extratoProduto.setNumseqped((BigDecimal) objects[i++]);
	    		extratoProduto.setPunit((BigDecimal) objects[i++]);
	    		extratoProduto.setQtentrada((BigDecimal) objects[i++]);
	    		extratoProduto.setQtsaida((BigDecimal) objects[i++]);
	    		extratoProduto.setNumlote((String) objects[i++]);
	    		extratoProduto.setRownum((BigDecimal) objects[i++]);
	    		
	    			pedidoResult.add(extratoProduto);
	    		}
	    }

	    return pedidoResult;
	}

	public List<ExtratoProdutoPayload> findAll() {
	    List<Object[]> results = entityManager.createNativeQuery(getExtratoProduto())
	    		.getResultList();	    
	    return getDadosDoResultSet(results);
	}
	
	String sql = getExtratoProduto();
	
    public List<ExtratoProdutoPayload> findByCodprodEFilial(ExtratoProdutoFilter filter) {
       
        Query nativeQuery = entityManager.createNativeQuery(getExtratoProduto());
        nativeQuery.setParameter("CODPROD", filter.getCodprod());
        nativeQuery.setParameter("CODFILIAL", filter.getCodfilial());
        
        
              
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