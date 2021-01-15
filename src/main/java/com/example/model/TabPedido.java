package com.example.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tab_pedidoc")
public class TabPedido {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "numped" ) 
	private BigDecimal numped; 

	@ManyToOne(optional=false)
	@JoinColumn(name = "codusur")
	private Vendedor vendedor;
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "codccli")
	private Cliente cliente;	

	@Column(name = "status" ) 
	private String status; 

	@Column(name = "vltotal" ) 
	private BigDecimal vltotal; 

	@Column(name = "posicao" ) 
	private String posicao; 

	@Column(name = "datapedido" ) 
	private Date datapedido; 

	@Column(name = "datachegadacli" ) 
	private Date datachegadacli; 

	@Column(name = "codfuncsep" ) 
	private Long codfuncsep; 

	@Column(name = "datainiciosep" ) 
	private Date datainiciosep; 

	@Column(name = "datafimsep" ) 
	private Date datafimsep; 

	@Column(name = "codfilial" ) 
	private Long codfilial; 

	@Column(name = "codfuncbalcao" ) 
	private Long codfuncbalcao; 

	@Column(name = "datainiciobalcao" ) 
	private Date datainiciobalcao; 

	@Column(name = "datafimbalcao" ) 
	private Date datafimbalcao; 

	@Column(name = "painel" ) 
	private String painel; 

	@Column(name = "original" ) 
	private String original; 

	@Column(name = "datapacote" ) 
	private Date datapacote; 

	@Column(name = "finalizado" ) 
	private String finalizado; 

	@Column(name = "qtitem" ) 
	private Long qtitem; 

	@Column(name = "estoque" ) 
	private String estoque; 

	@Column(name = "retira" ) 
	private String retira; 

	@Column(name = "codfuncpacote" ) 
	private Long codfuncpacote; 

	@Column(name = "retirante" ) 
	private String retirante; 


	public TabPedido() {

    }


	public TabPedido(BigDecimal numped, Vendedor vendedor, Cliente cliente, String status, BigDecimal vltotal,
			String posicao, Date datapedido, Date datachegadacli, Long codfuncsep, Date datainiciosep,
			Date datafimsep, Long codfilial, Long codfuncbalcao, Date datainiciobalcao,
			Date datafimbalcao, String painel, String original, Date datapacote, String finalizado,
			Long qtitem, String estoque, String retira, Long codfuncpacote, String retirante) {
		super();
		this.numped = numped;
		this.vendedor = vendedor;
		this.cliente = cliente;
		this.status = status;
		this.vltotal = vltotal;
		this.posicao = posicao;
		this.datapedido = datapedido;
		this.datachegadacli = datachegadacli;
		this.codfuncsep = codfuncsep;
		this.datainiciosep = datainiciosep;
		this.datafimsep = datafimsep;
		this.codfilial = codfilial;
		this.codfuncbalcao = codfuncbalcao;
		this.datainiciobalcao = datainiciobalcao;
		this.datafimbalcao = datafimbalcao;
		this.painel = painel;
		this.original = original;
		this.datapacote = datapacote;
		this.finalizado = finalizado;
		this.qtitem = qtitem;
		this.estoque = estoque;
		this.retira = retira;
		this.codfuncpacote = codfuncpacote;
		this.retirante = retirante;
	}


	public BigDecimal getNumped() {
		return numped;
	}


	public void setNumped(BigDecimal numped) {
		this.numped = numped;
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


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public BigDecimal getVltotal() {
		return vltotal;
	}


	public void setVltotal(BigDecimal vltotal) {
		this.vltotal = vltotal;
	}


	public String getPosicao() {
		return posicao;
	}


	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}


	public Date getDatapedido() {
		return datapedido;
	}


	public void setDatapedido(Date datapedido) {
		this.datapedido = datapedido;
	}


	public Date getDatachegadacli() {
		return datachegadacli;
	}


	public void setDatachegadacli(Date datachegadacli) {
		this.datachegadacli = datachegadacli;
	}


	public Long getCodfuncsep() {
		return codfuncsep;
	}


	public void setCodfuncsep(Long codfuncsep) {
		this.codfuncsep = codfuncsep;
	}


	public Date getDatainiciosep() {
		return datainiciosep;
	}


	public void setDatainiciosep(Date datainiciosep) {
		this.datainiciosep = datainiciosep;
	}


	public Date getDatafimsep() {
		return datafimsep;
	}


	public void setDatafimsep(Date datafimsep) {
		this.datafimsep = datafimsep;
	}


	public Long getCodfilial() {
		return codfilial;
	}


	public void setCodfilial(Long codfilial) {
		this.codfilial = codfilial;
	}


	public Long getCodfuncbalcao() {
		return codfuncbalcao;
	}


	public void setCodfuncbalcao(Long codfuncbalcao) {
		this.codfuncbalcao = codfuncbalcao;
	}


	public Date getDatainiciobalcao() {
		return datainiciobalcao;
	}


	public void setDatainiciobalcao(Date datainiciobalcao) {
		this.datainiciobalcao = datainiciobalcao;
	}


	public Date getDatafimbalcao() {
		return datafimbalcao;
	}


	public void setDatafimbalcao(Date datafimbalcao) {
		this.datafimbalcao = datafimbalcao;
	}


	public String getPainel() {
		return painel;
	}


	public void setPainel(String painel) {
		this.painel = painel;
	}


	public String getOriginal() {
		return original;
	}


	public void setOriginal(String original) {
		this.original = original;
	}


	public Date getDatapacote() {
		return datapacote;
	}


	public void setDatapacote(Date datapacote) {
		this.datapacote = datapacote;
	}


	public String getFinalizado() {
		return finalizado;
	}


	public void setFinalizado(String finalizado) {
		this.finalizado = finalizado;
	}


	public Long getQtitem() {
		return qtitem;
	}


	public void setQtitem(Long qtitem) {
		this.qtitem = qtitem;
	}


	public String getEstoque() {
		return estoque;
	}


	public void setEstoque(String estoque) {
		this.estoque = estoque;
	}


	public String getRetira() {
		return retira;
	}


	public void setRetira(String retira) {
		this.retira = retira;
	}


	public Long getCodfuncpacote() {
		return codfuncpacote;
	}


	public void setCodfuncpacote(Long codfuncpacote) {
		this.codfuncpacote = codfuncpacote;
	}


	public String getRetirante() {
		return retirante;
	}


	public void setRetirante(String retirante) {
		this.retirante = retirante;
	}
	
	
	
	

}
