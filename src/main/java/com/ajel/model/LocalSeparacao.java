package com.ajel.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AJEL_LOCALSEPARACAO")
public class LocalSeparacao {


    
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codpedidoc")
    public Long  codpedidoc;

    @Column(name = "numped")
    public Long  numped;

    @Column(name = "datapedido")
    public Date  datapedido;

    @Column(name = "codfuncsep")
    public Long  codfuncsep;

    @Column(name = "datainiciosep")
    public Date  datainiciosep;

    @Column(name = "datafimsep")
    public Date  datafimsep;

    @Column(name = "codfilial")
    public String  codfilial;

    @Column(name = "finalizado")
    public String  finalizado;

    @Column(name = "qtitem")
    public Long  qtitem;

    @Column(name = "localseparacao")
    public String  localseparacao;
    
    
    public LocalSeparacao() {
        
    }

    public LocalSeparacao(Long codpedidoc, Long numped, Date datapedido, Long codfuncsep, Date datainiciosep, Date datafimsep,
            String codfilial, String finalizado, Long qtitem, String localseparacao) {
        super();
        this.codpedidoc = codpedidoc;
        this.numped = numped;
        this.datapedido = datapedido;
        this.codfuncsep = codfuncsep;
        this.datainiciosep = datainiciosep;
        this.datafimsep = datafimsep;
        this.codfilial = codfilial;
        this.finalizado = finalizado;
        this.qtitem = qtitem;
        this.localseparacao = localseparacao;
    }

    public Long getCodpedidoc() {
        return codpedidoc;
    }

    public void setCodpedidoc(Long codpedidoc) {
        this.codpedidoc = codpedidoc;
    }

    public Long getNumped() {
        return numped;
    }

    public void setNumped(Long numped) {
        this.numped = numped;
    }

    public Date getDatapedido() {
        return datapedido;
    }

    public void setDatapedido(Date datapedido) {
        this.datapedido = datapedido;
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

    public String getCodfilial() {
        return codfilial;
    }

    public void setCodfilial(String codfilial) {
        this.codfilial = codfilial;
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

    public String getLocalseparacao() {
        return localseparacao;
    }

    public void setLocalseparacao(String localseparacao) {
        this.localseparacao = localseparacao;
    }
    
    
    

}

