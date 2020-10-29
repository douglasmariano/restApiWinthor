package com.example.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tab_pedidoc")
public class TabPedido {
	
	private long NUMPED;
	private long CODUSUR;
	private long CODCCLI;
	private String STATUS;
	private BigDecimal VLTOTAL;
	private String POSICAO;
	private LocalDate DATAPEDIDO;
	private LocalDate DATACHEGADACLI;
	private Long CODFUNCSEP;
	private LocalDate DATAINICIOSEP;
	private LocalDate DATAFIMSEP;
	private long CODFILIAL;
	private Long CODFUNCBALCAO;
	private LocalDate DATAINICIOBALCAO;
	private LocalDate DATAFIMBALCAO;
	private String PAINEL;
	private String ORIGINAL;
	private LocalDate DATAPACOTE;
	private String FINALIZADO;
	private Long QTITEM;
	private String ESTOQUE;
	private String RETIRA;
	private Long CODFUNCPACOTE;
	private String RETIRANTE;
	
	public TabPedido() {

    }
	
	public TabPedido( long NUMPED, long CODUSUR, long CODCCLI, String STATUS, BigDecimal VLTOTAL, String POSICAO, LocalDate DATAPEDIDO,
			LocalDate DATACHEGADACLI,Long CODFUNCSEP,LocalDate DATAINICIOSEP,LocalDate DATAFIMSEP,long CODFILIAL,Long CODFUNCBALCAO,
			LocalDate DATAINICIOBALCAO,LocalDate DATAFIMBALCAO,String PAINEL,String ORIGINAL,LocalDate DATAPACOTE,String FINALIZADO, 
			Long QTITEM, String ESTOQUE, String RETIRA, Long CODFUNCPACOTE,String RETIRANTE ) {
				this.NUMPED = NUMPED;
				this.CODCCLI = CODCCLI;
				this.CODFILIAL = CODFILIAL;
				this.CODFUNCBALCAO = CODFUNCBALCAO;
				this.CODFUNCPACOTE = CODFUNCPACOTE;
				this.CODFUNCSEP = CODFUNCSEP;
				this.CODUSUR = CODUSUR;
				this.DATACHEGADACLI = DATACHEGADACLI;
				this.DATAFIMBALCAO = DATAFIMBALCAO;
				this.DATAFIMSEP = DATAFIMSEP;
				this.DATAINICIOBALCAO = DATAINICIOBALCAO;
				this.DATAINICIOSEP = DATAINICIOSEP;
				this.DATAPACOTE = DATAPACOTE;
				this.DATAPEDIDO = DATAPEDIDO;
				this.ESTOQUE = ESTOQUE;
				this.FINALIZADO = FINALIZADO;
				this.NUMPED = NUMPED;
				this.ORIGINAL = ORIGINAL;
				this.PAINEL = PAINEL;
				this.POSICAO = POSICAO;
				this.QTITEM = QTITEM;
				this.RETIRA = RETIRA;
				this.RETIRANTE =RETIRANTE;
				this.STATUS = STATUS;
				this.VLTOTAL = VLTOTAL;		
	}
	
	@Id
    @Column(name = "NUMPED")
	public long getNUMPED() {
		return NUMPED;
	}

	public void setNUMPED(long nUMPED) {
		NUMPED = nUMPED;
	}
    @Column(name = "CODUSUR")
	public long getCODUSUR() {
		return CODUSUR;
	}
  
	public void setCODUSUR(long cODUSUR) {
		CODUSUR = cODUSUR;
	}
    @Column(name = "CODCCLI")
	public long getCODCCLI() {
		return CODCCLI;
	}
 
	public void setCODCCLI(long cODCCLI) {
		CODCCLI = cODCCLI;
	}
    @Column(name = "STATUS")
	public String getSTATUS() {
		return STATUS;
	}
	
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	@Column(name = "VLTOTAL")
	public BigDecimal getVLTOTAL() {
		return VLTOTAL;
	}
	
	public void setVLTOTAL(BigDecimal vLTOTAL) {
		VLTOTAL = vLTOTAL;
	}
	@Column(name = "POSICAO")
	public String getPOSICAO() {
		return POSICAO;
	}
	
	public void setPOSICAO(String pOSICAO) {
		POSICAO = pOSICAO;
	}
	@Column(name = "DATAPEDIDO")
	public LocalDate getDATAPEDIDO() {
		return DATAPEDIDO;
	}
	
	public void setDATAPEDIDO(LocalDate dATAPEDIDO) {
		DATAPEDIDO = dATAPEDIDO;
	}
	@Column(name = "DATACHEGADACLI")
	public LocalDate getDATACHEGADACLI() {
		return DATACHEGADACLI;
	}

	public void setDATACHEGADACLI(LocalDate dATACHEGADACLI) {
		DATACHEGADACLI = dATACHEGADACLI;
	}
	@Column(name = "CODFUNCSEP")
	public Long getCODFUNCSEP() {
		return CODFUNCSEP;
	}

	public void setCODFUNCSEP(Long cODFUNCSEP) {
		CODFUNCSEP = cODFUNCSEP;
	}
	@Column(name = "DATAINICIOSEP")
	public LocalDate getDATAINICIOSEP() {
		return DATAINICIOSEP;
	}

	public void setDATAINICIOSEP(LocalDate dATAINICIOSEP) {
		DATAINICIOSEP = dATAINICIOSEP;
	}
	@Column(name = "DATAFIMSEP")
	public LocalDate getDATAFIMSEP() {
		return DATAFIMSEP;
	}

	public void setDATAFIMSEP(LocalDate dATAFIMSEP) {
		DATAFIMSEP = dATAFIMSEP;
	}
	@Column(name = "CODFILIAL")
	public long getCODFILIAL() {
		return CODFILIAL;
	}

	public void setCODFILIAL(long cODFILIAL) {
		CODFILIAL = cODFILIAL;
	}
	@Column(name = "CODFUNCBALCAO")
	public Long getCODFUNCBALCAO() {
		return CODFUNCBALCAO;
	}

	public void setCODFUNCBALCAO(Long cODFUNCBALCAO) {
		CODFUNCBALCAO = cODFUNCBALCAO;
	}
	
	@Column(name = "DATAINICIOBALCAO")
	public LocalDate getDATAINICIOBALCAO() {
		return DATAINICIOBALCAO;
	}

	public void setDATAINICIOBALCAO(LocalDate dATAINICIOBALCAO) {
		DATAINICIOBALCAO = dATAINICIOBALCAO;
	}
	@Column(name = "DATAFIMBALCAO")
	public LocalDate getDATAFIMBALCAO() {
		return DATAFIMBALCAO;
	}

	public void setDATAFIMBALCAO(LocalDate dATAFIMBALCAO) {
		DATAFIMBALCAO = dATAFIMBALCAO;
	}
	@Column(name = "PAINEL")
	public String getPAINEL() {
		return PAINEL;
	}

	public void setPAINEL(String pAINEL) {
		PAINEL = pAINEL;
	}
	@Column(name = "ORIGINAL")
	public String getORIGINAL() {
		return ORIGINAL;
	}

	public void setORIGINAL(String oRIGINAL) {
		ORIGINAL = oRIGINAL;
	}
	@Column(name = "DATAPACOTE")
	public LocalDate getDATAPACOTE() {
		return DATAPACOTE;
	}
	
	public void setDATAPACOTE(LocalDate dATAPACOTE) {
		DATAPACOTE = dATAPACOTE;
	}
	@Column(name = "FINALIZADO")
	public String getFINALIZADO() {
		return FINALIZADO;
	}

	public void setFINALIZADO(String fINALIZADO) {
		FINALIZADO = fINALIZADO;
	}
	@Column(name = "QTITEM")
	public Long getQTITEM() {
		return QTITEM;
	}

	public void setQTITEM(Long qTITEM) {
		QTITEM = qTITEM;
	}
	@Column(name = "ESTOQUE")
	public String getESTOQUE() {
		return ESTOQUE;
	}

	public void setESTOQUE(String eSTOQUE) {
		ESTOQUE = eSTOQUE;
	}
	@Column(name = "RETIRA")
	public String getRETIRA() {
		return RETIRA;
	}

	public void setRETIRA(String rETIRA) {
		RETIRA = rETIRA;
	}
	@Column(name = "CODFUNCPACOTE")
	public Long getCODFUNCPACOTE() {
		return CODFUNCPACOTE;
	}

	public void setCODFUNCPACOTE(Long cODFUNCPACOTE) {
		CODFUNCPACOTE = cODFUNCPACOTE;
	}
	@Column(name = "RETIRANTE")
	public String getRETIRANTE() {
		return RETIRANTE;
	}

	public void setRETIRANTE(String rETIRANTE) {
		RETIRANTE = rETIRANTE;
	}
	

}
