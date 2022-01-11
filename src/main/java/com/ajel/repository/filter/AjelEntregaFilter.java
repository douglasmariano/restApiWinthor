package com.ajel.repository.filter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class AjelEntregaFilter {
    
    private BigDecimal codentrega;
    
    private String codfilial;    
    
    private BigDecimal numnota;
    
    private List<Long> transportadora;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dtentrega;

    public BigDecimal getCodentrega() {
        return codentrega;
    }

    public void setCodentrega(BigDecimal codentrega) {
        this.codentrega = codentrega;
    }

    public BigDecimal getNumnota() {
        return numnota;
    }

    public void setNumnota(BigDecimal numnota) {
        this.numnota = numnota;
    }

    public List<Long> getTransportadora() {
        return transportadora;
    }

    public void setTransportadora(List<Long> transportadora) {
        this.transportadora = transportadora;
    }

    public Date getDtentrega() {
        return dtentrega;
    }

    public void setDtEntrega(Date dtentrega) {
        this.dtentrega = dtentrega;
    }

    public String getCodfilial() {
        return codfilial;
    }

    public void setCodfilial(String codfilial) {
        this.codfilial = codfilial;
    }
    
    
    
}
