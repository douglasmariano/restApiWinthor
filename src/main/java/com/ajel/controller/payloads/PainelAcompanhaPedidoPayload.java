package com.ajel.controller.payloads;

import java.math.BigDecimal;
import java.util.Date;

public class PainelAcompanhaPedidoPayload {
   
    private BigDecimal NUMPED;
    private String CLIENTE; 
    private BigDecimal CODPROD;
    private String DESCRICAO;
    private BigDecimal QT;
    private BigDecimal QTESTGER; 
    private Date DATAPEDIDO; 
    private String TIPOSEPARACAO; 
    private String STATUS;   
    private Date DATACHEGADACLI;
    private String POSICAO;
    
    public BigDecimal getNUMPED() {
        return NUMPED;
    }
    public void setNUMPED(BigDecimal nUMPED) {
        NUMPED = nUMPED;
    }
    public String getCLIENTE() {
        return CLIENTE;
    }
    public void setCLIENTE(String cLIENTE) {
        CLIENTE = cLIENTE;
    }
    public BigDecimal getCODPROD() {
        return CODPROD;
    }
    public void setCODPROD(BigDecimal cODPROD) {
        CODPROD = cODPROD;
    }
    public String getTIPOSEPARACAO() {
        return TIPOSEPARACAO;
    }
    public void setTIPOSEPARACAO(String tIPOSEPARACAO) {
        TIPOSEPARACAO = tIPOSEPARACAO;
    }
    public String getSTATUS() {
        return STATUS;
    }
    public void setSTATUS(String sTATUS) {
        STATUS = sTATUS;
    }
    public Date getDATACHEGADACLI() {
        return DATACHEGADACLI;
    }
    public void setDATACHEGADACLI(Date dATACHEGADACLI) {
        DATACHEGADACLI = dATACHEGADACLI;
    }
    public String getDESCRICAO() {
        return DESCRICAO;
    }
    public void setDESCRICAO(String dESCRICAO) {
        DESCRICAO = dESCRICAO;
    }
    public BigDecimal getQT() {
        return QT;
    }
    public void setQT(BigDecimal qT) {
        QT = qT;
    }
    public BigDecimal getQTESTGER() {
        return QTESTGER;
    }
    public void setQTESTGER(BigDecimal qTESTGER) {
        QTESTGER = qTESTGER;
    }
    public Date getDATAPEDIDO() {
        return DATAPEDIDO;
    }
    public void setDATAPEDIDO(Date dATAPEDIDO) {
        DATAPEDIDO = dATAPEDIDO;
    }
    public String getPOSICAO() {
        return POSICAO;
    }
    public void setPOSICAO(String pOSICAO) {
        POSICAO = pOSICAO;
    } 

}
