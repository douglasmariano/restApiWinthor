package com.example.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tab_pedidoc")
public class TabPedido {
	@Id
    @Column(name = "NUMPED")
	private Integer NUMPED;
	
	
	@Column(name = "STATUS")
	private String STATUS;
	
	@Column(name = "VLTOTAL")
	private BigDecimal VLTOTAL;
	
	@Column(name = "POSICAO")
	private String POSICAO;
	
	@Column(name = "DATAPEDIDO")
	private LocalDate DATAPEDIDO;
	
	@Column(name = "DATACHEGADACLI")
	private LocalDate DATACHEGADACLI;
	
	@Column(name = "DATAEMISSAOMAPA")
	private LocalDate DATAEMISSAOMAPA;
	
	@Column(name = "CODFUNCSEP")
	private Long CODFUNCSEP;
	
	@Column(name = "DATAINICIOSEP")
	private LocalDate DATAINICIOSEP;

	@Column(name = "DATAFIMSEP")
	private LocalDate DATAFIMSEP;
	
	@Column(name = "AGUARDSEP")
	private LocalDate AGUARDSEP;
	
	@Column(name = "DATAATUAL")
	private LocalDate DATAATUAL;
	
	@Column(name = "EMSEPARACAO")
	private LocalDate EMSEPARACAO;
	
	@Column(name = "EMCONFERENCIA")
	private LocalDate EMCONFERENCIA;
	
	@Column(name = "TEMPODECOR")
	private LocalDate TEMPODECOR;
	
	
	@Column(name = "ORDEM")
	private Long ORDEM;
	
	@Column(name = "CODFILIAL")
	private long CODFILIAL;
	
	@Column(name = "CODFUNCBALCAO")
	private Long CODFUNCBALCAO;
	
	@Column(name = "DATAINICIOBALCAO")
	private LocalDate DATAINICIOBALCAO;
	
	@Column(name = "DATAFIMBALCAO")
	private LocalDate DATAFIMBALCAO;
	
	@Column(name = "PAINEL")
	private String PAINEL;
	
	@Column(name = "ORIGINAL")
	private String ORIGINAL;
	
	@Column(name = "DATAPACOTE")
	private LocalDate DATAPACOTE;
	
	@Column(name = "FINALIZADO")
	private String FINALIZADO;
	
	@Column(name = "QTITEM")
	private Long QTITEM;
	
	@Column(name = "ESTOQUE")
	private String ESTOQUE;
	
	@Column(name = "RETIRA")
	private String RETIRA;
	
	
	
	@Column(name = "CODFUNCPACOTE")
	private Long CODFUNCPACOTE;
	
	@Column(name = "RETIRANTE")
	private String RETIRANTE;
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "codusur")
	private Vendedor vendedor;
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "codccli")
	private Cliente cliente;
	
	public TabPedido() {

    }
	
	public TabPedido( Integer NUMPED, String STATUS, BigDecimal VLTOTAL, String POSICAO, LocalDate DATAPEDIDO,LocalDate AGUARDSEP,LocalDate DATAATUAL,LocalDate EMSEPARACAO,
			LocalDate TEMPODECOR,LocalDate EMCONFERENCIA, Long ORDEM, LocalDate DATACHEGADACLI, LocalDate DATAEMISSAOMAPA,Long CODFUNCSEP,LocalDate DATAINICIOSEP,LocalDate DATAFIMSEP,long CODFILIAL,Long CODFUNCBALCAO,
			LocalDate DATAINICIOBALCAO,LocalDate DATAFIMBALCAO,String PAINEL,String ORIGINAL,LocalDate DATAPACOTE,String FINALIZADO, 
			Long QTITEM, String ESTOQUE, String RETIRA, Long CODFUNCPACOTE,String RETIRANTE, Vendedor vendedor, Cliente cliente ) {
				this.NUMPED = NUMPED;
				this.CODFILIAL = CODFILIAL;
				this.CODFUNCBALCAO = CODFUNCBALCAO;
				this.CODFUNCPACOTE = CODFUNCPACOTE;
				this.CODFUNCSEP = CODFUNCSEP;
				this.DATACHEGADACLI = DATACHEGADACLI;
				this.DATAEMISSAOMAPA = DATAEMISSAOMAPA;
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
				this.vendedor = vendedor;
				this.cliente = cliente;
				this.AGUARDSEP = AGUARDSEP;
				this.DATAATUAL = DATAATUAL;
				this.EMSEPARACAO=EMSEPARACAO;
				this.EMCONFERENCIA =EMCONFERENCIA;
				this.TEMPODECOR =TEMPODECOR;
				this.ORDEM = ORDEM;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (NUMPED ^ (NUMPED >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TabPedido other = (TabPedido) obj;
		if (NUMPED != other.NUMPED)
			return false;
		return true;
	}
	
	
	public long getNUMPED() {
		return NUMPED;
	}

	public void setNUMPED(Integer nUMPED) {
		NUMPED = nUMPED;
	}
    	    
    
	public String getSTATUS() {
		return STATUS;
	}
	
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	
	public BigDecimal getVLTOTAL() {
		return VLTOTAL;
	}
	
	public void setVLTOTAL(BigDecimal vLTOTAL) {
		VLTOTAL = vLTOTAL;
	}

	public String getPOSICAO() {
		return POSICAO;
	}
	
	public void setPOSICAO(String pOSICAO) {
		POSICAO = pOSICAO;
	}

	public LocalDate getDATAPEDIDO() {
		return DATAPEDIDO;
	}
	
	

	public void setDATAPEDIDO(LocalDate dATAPEDIDO) {
		DATAPEDIDO = dATAPEDIDO;
	}

	public LocalDate getDATACHEGADACLI() {
		return DATACHEGADACLI;
	}

	public void setDATACHEGADACLI(LocalDate dATACHEGADACLI) {
		DATACHEGADACLI = dATACHEGADACLI;
	}

	public Long getCODFUNCSEP() {
		return CODFUNCSEP;
	}

	public void setCODFUNCSEP(Long cODFUNCSEP) {
		CODFUNCSEP = cODFUNCSEP;
	}
	
	public LocalDate getDATAINICIOSEP() {
		return DATAINICIOSEP;
	}

	public void setDATAINICIOSEP(LocalDate dATAINICIOSEP) {
		DATAINICIOSEP = dATAINICIOSEP;
	}

	public LocalDate getDATAFIMSEP() {
		return DATAFIMSEP;
	}

	public void setDATAFIMSEP(LocalDate dATAFIMSEP) {
		DATAFIMSEP = dATAFIMSEP;
	}

	public long getCODFILIAL() {
		return CODFILIAL;
	}

	public void setCODFILIAL(long cODFILIAL) {
		CODFILIAL = cODFILIAL;
	}

	public Long getCODFUNCBALCAO() {
		return CODFUNCBALCAO;
	}

	public void setCODFUNCBALCAO(Long cODFUNCBALCAO) {
		CODFUNCBALCAO = cODFUNCBALCAO;
	}
	

	public LocalDate getDATAINICIOBALCAO() {
		return DATAINICIOBALCAO;
	}

	public void setDATAINICIOBALCAO(LocalDate dATAINICIOBALCAO) {
		DATAINICIOBALCAO = dATAINICIOBALCAO;
	}

	public LocalDate getDATAFIMBALCAO() {
		return DATAFIMBALCAO;
	}

	public void setDATAFIMBALCAO(LocalDate dATAFIMBALCAO) {
		DATAFIMBALCAO = dATAFIMBALCAO;
	}

	public String getPAINEL() {
		return PAINEL;
	}

	public void setPAINEL(String pAINEL) {
		PAINEL = pAINEL;
	}

	public String getORIGINAL() {
		return ORIGINAL;
	}

	public void setORIGINAL(String oRIGINAL) {
		ORIGINAL = oRIGINAL;
	}

	public LocalDate getDATAPACOTE() {
		return DATAPACOTE;
	}
	
	public void setDATAPACOTE(LocalDate dATAPACOTE) {
		DATAPACOTE = dATAPACOTE;
	}

	public String getFINALIZADO() {
		return FINALIZADO;
	}

	public void setFINALIZADO(String fINALIZADO) {
		FINALIZADO = fINALIZADO;
	}

	public Long getQTITEM() {
		return QTITEM;
	}

	public void setQTITEM(Long qTITEM) {
		QTITEM = qTITEM;
	}

	public String getESTOQUE() {
		return ESTOQUE;
	}

	public void setESTOQUE(String eSTOQUE) {
		ESTOQUE = eSTOQUE;
	}

	public String getRETIRA() {
		return RETIRA;
	}

	public void setRETIRA(String rETIRA) {
		RETIRA = rETIRA;
	}

	public Long getCODFUNCPACOTE() {
		return CODFUNCPACOTE;
	}

	public void setCODFUNCPACOTE(Long cODFUNCPACOTE) {
		CODFUNCPACOTE = cODFUNCPACOTE;
	}

	public String getRETIRANTE() {
		return RETIRANTE;
	}

	public void setRETIRANTE(String rETIRANTE) {
		RETIRANTE = rETIRANTE;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getDATAEMISSAOMAPA() {
		return DATAEMISSAOMAPA;
	}

	public void setDATAEMISSAOMAPA(LocalDate dATAEMISSAOMAPA) {
		DATAEMISSAOMAPA = dATAEMISSAOMAPA;
	}

	public LocalDate getAGUARDSEP() {
		return AGUARDSEP;
	}

	public void setAGUARDSEP(LocalDate aGUARDSEP) {
		AGUARDSEP = aGUARDSEP;
	}

	public LocalDate getDATAATUAL() {
		return DATAATUAL;
	}

	public void setDATAATUAL(LocalDate dATAATUAL) {
		DATAATUAL = dATAATUAL;
	}

	public LocalDate getEMSEPARACAO() {
		return EMSEPARACAO;
	}

	public void setEMSEPARACAO(LocalDate eMSEPARACAO) {
		EMSEPARACAO = eMSEPARACAO;
	}

	public LocalDate getEMCONFERENCIA() {
		return EMCONFERENCIA;
	}

	public void setEMCONFERENCIA(LocalDate eMCONFERENCIA) {
		EMCONFERENCIA = eMCONFERENCIA;
	}

	public LocalDate getTEMPODECOR() {
		return TEMPODECOR;
	}

	public void setTEMPODECOR(LocalDate tEMPODECOR) {
		TEMPODECOR = tEMPODECOR;
	}

	public Long getORDEM() {
		return ORDEM;
	}

	public void setORDEM(Long oRDEM) {
		ORDEM = oRDEM;
	}
	
	

}
