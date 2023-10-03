package com.ajel.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pcnfent")
public class NotaFiscalEntrada {
    
    @EmbeddedId
    private NotaFiscalEntradaPK notaFiscalEntradaPK;
    
    @Column(name = "especie")
    private String especie;
    
    @Column(name = "serie")
    private String serie;
    
    @Column(name = "numnota")
    private Long numnota;
    
    @Column(name = "vltotal")
    private BigDecimal vltotal;
    
    @ManyToOne
    @JoinColumn(name = "codfornec")
    private Transportadora codfornec;
    
    @Column(name = "codfilial")
    private Long codfilial;
    
    @Column(name = "dtent")
    private Date dtent;
    
    @Column(name = "numbonus")
    private Long numbonus;
    
    @Column(name = "coddevol")
    private Long coddevol;
    
    @Column(name = "codfunclanc")
    private Long codfunclanc;
       
    @Column(name = "obs")
    private String obs;
   
    @Column(name = "dtcancel")
    private Date dtcancel;
    
    public NotaFiscalEntrada() {
        
    }
   
    public NotaFiscalEntrada(NotaFiscalEntradaPK notaFiscalEntradaPK, String especie, String serie, Long numnota,
            BigDecimal vltotal, Transportadora codfornec, Long codfilial, Date dtent, Long numbonus, Long coddevol,
            Long codfunclanc, String obs, Date dtcancel) {
        super();
        this.notaFiscalEntradaPK = notaFiscalEntradaPK;
        this.especie = especie;
        this.serie = serie;
        this.numnota = numnota;
        this.vltotal = vltotal;
        this.codfornec = codfornec;
        this.codfilial = codfilial;
        this.dtent = dtent;
        this.numbonus = numbonus;
        this.coddevol = coddevol;
        this.codfunclanc = codfunclanc;
        this.obs = obs;
        this.dtcancel = dtcancel;
    }



    public NotaFiscalEntradaPK getNotaFiscalEntradaPK() {
        return notaFiscalEntradaPK;
    }



    public void setNotaFiscalEntradaPK(NotaFiscalEntradaPK notaFiscalEntradaPK) {
        this.notaFiscalEntradaPK = notaFiscalEntradaPK;
    }



    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Long getNumnota() {
        return numnota;
    }

    public void setNumnota(Long numnota) {
        this.numnota = numnota;
    }

    public BigDecimal getVltotal() {
        return vltotal;
    }

    public void setVltotal(BigDecimal vltotal) {
        this.vltotal = vltotal;
    }

    public Transportadora getCodfornec() {
        return codfornec;
    }

    public void setCodfornec(Transportadora codfornec) {
        this.codfornec = codfornec;
    }

    public Long getCodfilial() {
        return codfilial;
    }

    public void setCodfilial(Long codfilial) {
        this.codfilial = codfilial;
    }

    public Date getDtent() {
        return dtent;
    }

    public void setDtent(Date dtent) {
        this.dtent = dtent;
    }

    public Long getNumbonus() {
        return numbonus;
    }

    public void setNumbonus(Long numbonus) {
        this.numbonus = numbonus;
    }

    public Long getCoddevol() {
        return coddevol;
    }

    public void setCoddevol(Long coddevol) {
        this.coddevol = coddevol;
    }

    public Long getCodfunclanc() {
        return codfunclanc;
    }

    public void setCodfunclanc(Long codfunclanc) {
        this.codfunclanc = codfunclanc;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Date getDtcancel() {
        return dtcancel;
    }

    public void setDtcancel(Date dtcancel) {
        this.dtcancel = dtcancel;
    }
   
    
}
