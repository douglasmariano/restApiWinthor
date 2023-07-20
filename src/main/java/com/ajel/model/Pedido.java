package com.ajel.model;

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
@Table(name = "pcpedc")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "numped")
    private BigDecimal numped;
   
    @Column(name = "data")
    private Date data;
    
    @ManyToOne(optional=false)
    @JoinColumn(name = "codcli")
    private Cliente codcli;
    
    @ManyToOne(optional=false)
    @JoinColumn(name = "codusur")
    private Vendedor codusur;
    
    @Column(name = "codfilial")
    private String codfilial;
    
    @Column(name = "codpraca")
    private Long codpraca;
    
    @Column(name = "posicao")
    private String posicao;
    
    @Column(name = "codsupervisor")
    private Long codsupervisor;
    
    @Column(name = "codplpag")
    private Long codplpag;
    
    @Column(name = "dtemissaomapa")
    private Date dtemissaomapa;
    
    @Column(name = "dtfinalcheckout")
    private Date dtfinalcheckout;
    
    
    @Column(name = "dtfinalsep")
    private Date dtfinalsep;

   
    @Column(name = "numcar")
    private Long numcar;
   
    @Column(name = "numtransvenda")
    private Long numtransvenda;
    
    @Column(name = "codfuncconf")
    private Long codfuncconf;
    


    
    public Pedido() {}




    public Pedido(BigDecimal numped, Date data, Cliente codcli, Vendedor codusur, String codfilial, Long codpraca,
            String posicao, Long codsupervisor, Long codplpag, Date dtemissaomapa, Date dtfinalcheckout, Date dtfinalsep,
            Long numcar, Long numtransvenda, Long codfuncconf) {
        super();
        this.numped = numped;
        this.data = data;
        this.codcli = codcli;
        this.codusur = codusur;
        this.codfilial = codfilial;
        this.codpraca = codpraca;
        this.posicao = posicao;
        this.codsupervisor = codsupervisor;
        this.codplpag = codplpag;
        this.dtemissaomapa = dtemissaomapa;
        this.dtfinalcheckout = dtfinalcheckout;
        this.dtfinalsep = dtfinalsep;
        this.numcar = numcar;
        this.numtransvenda = numtransvenda;
        this.codfuncconf = codfuncconf;
    }




    public BigDecimal getNumped() {
        return numped;
    }




    public void setNumped(BigDecimal numped) {
        this.numped = numped;
    }




    public Date getData() {
        return data;
    }




    public void setData(Date data) {
        this.data = data;
    }




    public Cliente getCodcli() {
        return codcli;
    }




    public void setCodcli(Cliente codcli) {
        this.codcli = codcli;
    }




    public Vendedor getCodusur() {
        return codusur;
    }




    public void setCodusur(Vendedor codusur) {
        this.codusur = codusur;
    }




    public String getCodfilial() {
        return codfilial;
    }




    public void setCodfilial(String codfilial) {
        this.codfilial = codfilial;
    }




    public Long getCodpraca() {
        return codpraca;
    }




    public void setCodpraca(Long codpraca) {
        this.codpraca = codpraca;
    }




    public String getPosicao() {
        return posicao;
    }




    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }




    public Long getCodsupervisor() {
        return codsupervisor;
    }




    public void setCodsupervisor(Long codsupervisor) {
        this.codsupervisor = codsupervisor;
    }




    public Long getCodplpag() {
        return codplpag;
    }




    public void setCodplpag(Long codplpag) {
        this.codplpag = codplpag;
    }




    public Date getDtemissaomapa() {
        return dtemissaomapa;
    }




    public void setDtemissaomapa(Date dtemissaomapa) {
        this.dtemissaomapa = dtemissaomapa;
    }




    public Date getDtfinalcheckout() {
        return dtfinalcheckout;
    }




    public void setDtfinalcheckout(Date dtfinalcheckout) {
        this.dtfinalcheckout = dtfinalcheckout;
    }




    public Date getDtfinalsep() {
        return dtfinalsep;
    }




    public void setDtfinalsep(Date dtfinalsep) {
        this.dtfinalsep = dtfinalsep;
    }




    public Long getNumcar() {
        return numcar;
    }




    public void setNumcar(Long numcar) {
        this.numcar = numcar;
    }




    public Long getNumtransvenda() {
        return numtransvenda;
    }




    public void setNumtransvenda(Long numtransvenda) {
        this.numtransvenda = numtransvenda;
    }




    public Long getCodfuncconf() {
        return codfuncconf;
    }




    public void setCodfuncconf(Long codfuncconf) {
        this.codfuncconf = codfuncconf;
    }




}