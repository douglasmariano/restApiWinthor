package com.ajel.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="ajel_entrega_transporte")
public class EntregaTransporte {
    
    @EmbeddedId
    public EntregaTransportePK id;    

    @Column(name = "coddevol")
    public BigDecimal coddevol;

    @Column(name = "dtsaida")
    public Date dtsaida;

    @Column(name = "dtchegada")
    public Date dtchegada;

    @Column(name = "codusur")
    public Long codusur;

    
    public EntregaTransporte() {
        
    }


    public EntregaTransporte(EntregaTransportePK id, BigDecimal coddevol, Date dtsaida, Date dtchegada,
            Long codusur) {
        super();
        this.id = id;
        this.coddevol = coddevol;
        this.dtsaida = dtsaida;
        this.dtchegada = dtchegada;
        this.codusur = codusur;
    }


    public EntregaTransportePK getId() {
        return id;
    }


    public void setId(EntregaTransportePK id) {
        this.id = id;
    }


    public BigDecimal getCoddevol() {
        return coddevol;
    }


    public void setCoddevol(BigDecimal coddevol) {
        this.coddevol = coddevol;
    }


    public Date getDtsaida() {
        return dtsaida;
    }


    public void setDtsaida(Date dtsaida) {
        this.dtsaida = dtsaida;
    }


    public Date getDtchegada() {
        return dtchegada;
    }


    public void setDtchegada(Date dtchegada) {
        this.dtchegada = dtchegada;
    }


    public Long getCodusur() {
        return codusur;
    }


    public void setCodusur(Long userIdByMatricula) {
        this.codusur = userIdByMatricula;
    }
    
    

}
