package com.ajel.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name ="ajel_transporte")
public class Transporte {
    
    @SequenceGenerator(name = "SEQ_codtransporte", sequenceName = "SEQ_codtransporte", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_codtransporte")
    @Id
    @Column(name = "codtransporte")
    public Long  codtransporte;

    @Column(name = "codmotorista")
    public BigDecimal  codmotorista;

    @Column(name = "codveiculo")
    public BigDecimal codveiculo;
    

    @Column(name = "destino")
    public String destino;


    @Column(name = "dtexclusao")
    public Date dtexclusao;

    @Column(name = "dtinclusao")
    public Date dtinclusao;

    @Column(name = "tipocarga")
    public String tipocarga;

    @Column(name = "codfuncajud")
    public BigDecimal codfuncajud;

    @Column(name = "obsdestino")
    public String obsdestino;

    @Column(name = "qtvolumes")
    public BigDecimal qtvolumes;

    @Column(name = "codfuncultalter")
    public BigDecimal codfuncultalter;

    @Column(name = "dtultalter")
    public Date dtultalter;
    
    public Transporte(){
        
    }

    public Transporte(Long codtransporte, BigDecimal codmotorista, BigDecimal codveiculo, String destino, Date dtexclusao,
            Date dtinclusao, String tipocarga, BigDecimal codfuncajud, String obsdestino, BigDecimal qtvolumes,
            BigDecimal codfuncultalter, Date dtultalter) {
        super();
        this.codtransporte = codtransporte;
        this.codmotorista = codmotorista;
        this.codveiculo = codveiculo;
        this.destino = destino;
        this.dtexclusao = dtexclusao;
        this.dtinclusao = dtinclusao;
        this.tipocarga = tipocarga;
        this.codfuncajud = codfuncajud;
        this.obsdestino = obsdestino;
        this.qtvolumes = qtvolumes;
        this.codfuncultalter = codfuncultalter;
        this.dtultalter = dtultalter;
    }

    public Long getCodtransporte() {
        return codtransporte;
    }

    public void setCodtransporte(Long codtransporte) {
        this.codtransporte = codtransporte;
    }

    public BigDecimal getCodmotorista() {
        return codmotorista;
    }

    public void setCodmotorista(BigDecimal codmotorista) {
        this.codmotorista = codmotorista;
    }

    public BigDecimal getCodveiculo() {
        return codveiculo;
    }

    public void setCodveiculo(BigDecimal codveiculo) {
        this.codveiculo = codveiculo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getDtexclusao() {
        return dtexclusao;
    }

    public void setDtexclusao(Date dtexclusao) {
        this.dtexclusao = dtexclusao;
    }

    public Date getDtinclusao() {
        return dtinclusao;
    }

    public void setDtinclusao(Date dtinclusao) {
        this.dtinclusao = dtinclusao;
    }

    public String getTipocarga() {
        return tipocarga;
    }

    public void setTipocarga(String tipocarga) {
        this.tipocarga = tipocarga;
    }

    public BigDecimal getCodfuncajud() {
        return codfuncajud;
    }

    public void setCodfuncajud(BigDecimal codfuncajud) {
        this.codfuncajud = codfuncajud;
    }

    public String getObsdestino() {
        return obsdestino;
    }

    public void setObsdestino(String obsdestino) {
        this.obsdestino = obsdestino;
    }

    public BigDecimal getQtvolumes() {
        return qtvolumes;
    }

    public void setQtvolumes(BigDecimal qtvolumes) {
        this.qtvolumes = qtvolumes;
    }

    public BigDecimal getCodfuncultalter() {
        return codfuncultalter;
    }

    public void setCodfuncultalter(BigDecimal codfuncultalter) {
        this.codfuncultalter = codfuncultalter;
    }

    public Date getDtultalter() {
        return dtultalter;
    }

    public void setDtultalter(Date dtultalter) {
        this.dtultalter = dtultalter;
    }

}