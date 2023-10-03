package com.ajel.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pcnfsaid")
public class NotaFiscalSaida {
    
    @Id
    @Column(name = "numtransvenda")
    private Long numtransvenda;
    
    @Column(name = "especie")
    private String especie;
    
    @Column(name = "serie")
    private String serie;
    
    @Column(name = "numnota")
    private Long numnota;
    
    @Column(name = "vltotal")
    private BigDecimal vltotal;
    
    @ManyToOne
    @JoinColumn(name = "codcli")
    private Cliente codcli;
    
    @ManyToOne
    @JoinColumn(name = "codusur")
    private Vendedor codusur;
    
    @Column(name = "codfilial")
    private Long codfilial;
    
    @Column(name = "dtsaida")
    private Date dtsaida;
    
    @Column(name = "numped")
    private Long numped;
    
    @Column(name = "coddevol")
    private Long coddevol;
    
    @Column(name = "codfunclanc")
    private Long codfunclanc;
    
    @Column(name = "dtcanhoto")
    private Date dtcanhoto;
    
    @Column(name = "obsnfcarreg")
    private String obsnfcarreg;
   
    @Column(name = "dtcancel")
    private Date dtcancel;
    
    public NotaFiscalSaida() {
        
    }
    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((numtransvenda == null) ? 0 : numtransvenda.hashCode());
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
        NotaFiscalSaida other = (NotaFiscalSaida) obj;
        if (numtransvenda == null) {
            if (other.numtransvenda != null)
                return false;
        } else if (!numtransvenda.equals(other.numtransvenda))
            return false;
        return true;
    }

    
    public NotaFiscalSaida(Long numtransvenda, String especie, String serie, Long numnota, BigDecimal vltotal,
            Cliente codcli, Vendedor codusur, Long codfilial, Date dtsaida, Long numped, Long coddevol,
            Long codfunclanc, Date dtcanhoto, String obsnfcarreg, Date dtcancel) {
        super();
        this.numtransvenda = numtransvenda;
        this.especie = especie;
        this.serie = serie;
        this.numnota = numnota;
        this.vltotal = vltotal;
        this.codcli = codcli;
        this.codusur = codusur;
        this.codfilial = codfilial;
        this.dtsaida = dtsaida;
        this.numped = numped;
        this.coddevol = coddevol;
        this.codfunclanc = codfunclanc;
        this.dtcanhoto = dtcanhoto;
        this.obsnfcarreg = obsnfcarreg;
        this.dtcancel = dtcancel;
    }

    public Long getNumtransvenda() {
        return numtransvenda;
    }

    public void setNumtransvenda(Long numtransvenda) {
        this.numtransvenda = numtransvenda;
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

    public Long getCodfilial() {
        return codfilial;
    }

    public void setCodfilial(Long codfilial) {
        this.codfilial = codfilial;
    }

    public Date getDtsaida() {
        return dtsaida;
    }

    public void setDtsaida(Date dtsaida) {
        this.dtsaida = dtsaida;
    }

    public Long getNumped() {
        return numped;
    }

    public void setNumped(Long numped) {
        this.numped = numped;
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

    public Date getDtcanhoto() {
        return dtcanhoto;
    }

    public void setDtcanhoto(Date dtcanhoto) {
        this.dtcanhoto = dtcanhoto;
    }

    public String getObsnfcarreg() {
        return obsnfcarreg;
    }

    public void setObsnfcarreg(String obsnfcarreg) {
        this.obsnfcarreg = obsnfcarreg;
    }


    public Date getDtcancel() {
        return dtcancel;
    }


    public void setDtcancel(Date dtcancel) {
        this.dtcancel = dtcancel;
    }
    
    

    
}
