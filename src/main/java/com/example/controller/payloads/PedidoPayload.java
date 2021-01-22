package com.example.controller.payloads;

import java.math.BigDecimal;
import java.util.Date;

public class PedidoPayload {
	
	private BigDecimal NUMPED;
	private String NOME;
	private String CLIENTE;
	
	
	private Date DATAPEDIDO;
	private Date DATADIGITACAO;
	
	
	private Date DATAEMISSAOMAPA;
	
	private Date DATAINICIOSEP;
	
	private Date DATAFIMSEP;
	
	private Date DATACHEGADACLI;
	private BigDecimal CODFUNCSEP;
	
	private Date DATAFIMBALCAO;
	private BigDecimal CODFUNCBALCAO;
	
	private Date DATAATUAL;
	private String AGUARDSEP;
	private String EMSEPARACAO;
	private String EMCONFERENCIA;
	private String TEMPODECOR;
	private String POSICAO;
	private BigDecimal ORDEM;
	private String PAINEL;
	
	public BigDecimal getNUMPED() {
		return NUMPED;
	}
	public void setNUMPED(BigDecimal nUMPED) {
		NUMPED = nUMPED;
	}
	public String getNOME() {
		return NOME;
	}
	public void setNOME(String nOME) {
		NOME = nOME;
	}
	public String getCLIENTE() {
		return CLIENTE;
	}
	public void setCLIENTE(String cLIENTE) {
		CLIENTE = cLIENTE;
	}
	public Date getDATAPEDIDO() {
		return DATAPEDIDO;
	}
	public void setDATAPEDIDO(Date dATAPEDIDO) {
		DATAPEDIDO = dATAPEDIDO;
	}
	
	public Date getDATADIGITACAO() {
		return DATADIGITACAO;
	}
	public void setDATADIGITACAO(Date dATADIGITACAO) {
		DATADIGITACAO = dATADIGITACAO;
	}
	public Date getDATAEMISSAOMAPA() {
		return DATAEMISSAOMAPA;
	}
	public void setDATAEMISSAOMAPA(Date dATAEMISSAOMAPA) {
		DATAEMISSAOMAPA = dATAEMISSAOMAPA;
	}
	public Date getDATAINICIOSEP() {
		return DATAINICIOSEP;
	}
	public void setDATAINICIOSEP(Date dATAINICIOSEP) {
		DATAINICIOSEP = dATAINICIOSEP;
	}
	public Date getDATAFIMSEP() {
		return DATAFIMSEP;
	}
	public void setDATAFIMSEP(Date dATAFIMSEP) {
		DATAFIMSEP = dATAFIMSEP;
	}
	public Date getDATACHEGADACLI() {
		return DATACHEGADACLI;
	}
	public void setDATACHEGADACLI(Date dATACHEGADACLI) {
		DATACHEGADACLI = dATACHEGADACLI;
	}
	public BigDecimal getCODFUNCSEP() {
		return CODFUNCSEP;
	}
	public void setCODFUNCSEP(BigDecimal cODFUNCSEP) {
		CODFUNCSEP = cODFUNCSEP;
	}
	public Date getDATAFIMBALCAO() {
		return DATAFIMBALCAO;
	}
	public void setDATAFIMBALCAO(Date dATAFIMBALCAO) {
		DATAFIMBALCAO = dATAFIMBALCAO;
	}
	public BigDecimal getCODFUNCBALCAO() {
		return CODFUNCBALCAO;
	}
	public void setCODFUNCBALCAO(BigDecimal cODFUNCBALCAO) {
		CODFUNCBALCAO = cODFUNCBALCAO;
	}
	public Date getDATAATUAL() {
		return DATAATUAL;
	}
	public void setDATAATUAL(Date dATAATUAL) {
		DATAATUAL = dATAATUAL;
	}
	public String getAGUARDSEP() {
		return AGUARDSEP;
	}
	public void setAGUARDSEP(String aGUARDSEP) {
		AGUARDSEP = aGUARDSEP;
	}
	public String getEMSEPARACAO() {
		return EMSEPARACAO;
	}
	public void setEMSEPARACAO(String eMSEPARACAO) {
		EMSEPARACAO = eMSEPARACAO;
	}
	public String getEMCONFERENCIA() {
		return EMCONFERENCIA;
	}
	public void setEMCONFERENCIA(String eMCONFERENCIA) {
		EMCONFERENCIA = eMCONFERENCIA;
	}
	public String getTEMPODECOR() {
		return TEMPODECOR;
	}
	public void setTEMPODECOR(String tEMPODECOR) {
		TEMPODECOR = tEMPODECOR;
	}
	public String getPOSICAO() {
		return POSICAO;
	}
	public void setPOSICAO(String pOSICAO) {
		POSICAO = pOSICAO;
	}
	public BigDecimal getORDEM() {
		return ORDEM;
	}
	public void setORDEM(BigDecimal oRDEM) {
		ORDEM = oRDEM;
	}
	public String getPAINEL() {
		return PAINEL;
	}
	public void setPAINEL(String pAINEL) {
		PAINEL = pAINEL;
	}

	
}
