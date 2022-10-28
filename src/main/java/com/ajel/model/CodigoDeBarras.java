package com.ajel.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="pcbarra")
public class CodigoDeBarras {
    

    @EmbeddedId
    public CodigoDeBarrasPK id;  

    @Column(name = "dtultalt")
    public Date dtultalt;

    @Column(name = "codfuncalt")
    public BigDecimal codfuncalt;
    
    @Column(name = "dtcadastro")
    public Date dtcadastro;

    @Column(name = "codfunccad")
    public BigDecimal codfunccad;
    
    @Column(name = "dtexclusao")
    public Date dtexclusao;

    @Column(name = "codfuncexclusao")
    public BigDecimal codfuncexclusao;
    
        
    public CodigoDeBarras() {
    }


    public CodigoDeBarras(CodigoDeBarrasPK id, Date dtultalt, BigDecimal codfuncalt, Date dtcadastro,
            BigDecimal codfunccad, Date dtexclusao, BigDecimal codfuncexclusao) {
        super();
        this.id = id;
        this.dtultalt = dtultalt;
        this.codfuncalt = codfuncalt;
        this.dtcadastro = dtcadastro;
        this.codfunccad = codfunccad;
        this.dtexclusao = dtexclusao;
        this.codfuncexclusao = codfuncexclusao;
    }


   

    public CodigoDeBarrasPK getId() {
        return id;
    }


    public void setId(CodigoDeBarrasPK id) {
        this.id = id;
    }


    public Date getDtultalt() {
        return dtultalt;
    }


    public void setDtultalt(Date dtultalt) {
        this.dtultalt = dtultalt;
    }


    public BigDecimal getCodfuncalt() {
        return codfuncalt;
    }


    public void setCodfuncalt(BigDecimal codfuncalt) {
        this.codfuncalt = codfuncalt;
    }


    public Date getDtcadastro() {
        return dtcadastro;
    }


    public void setDtcadastro(Date dtcadastro) {
        this.dtcadastro = dtcadastro;
    }


    public BigDecimal getCodfunccad() {
        return codfunccad;
    }


    public void setCodfunccad(BigDecimal codfunccad) {
        this.codfunccad = codfunccad;
    }


    public Date getDtexclusao() {
        return dtexclusao;
    }


    public void setDtexclusao(Date dtexclusao) {
        this.dtexclusao = dtexclusao;
    }


    public BigDecimal getCodfuncexclusao() {
        return codfuncexclusao;
    }


    public void setCodfuncexclusao(BigDecimal codfuncexclusao) {
        this.codfuncexclusao = codfuncexclusao;
    }
  

    
}