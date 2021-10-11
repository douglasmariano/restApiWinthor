package com.ajel.repository.filter;

import java.math.BigDecimal;
import java.util.List;

public class AjelEntregaFilter {
    
    private BigDecimal codentrega;
    
    private BigDecimal numnota;
    
    private List<Long> transportadora;

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
    
    
    
}
