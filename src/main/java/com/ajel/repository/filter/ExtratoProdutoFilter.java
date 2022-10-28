package com.ajel.repository.filter;

import java.math.BigDecimal;

public class ExtratoProdutoFilter {
    
    private BigDecimal codfilial;
    private BigDecimal codprod;

    public BigDecimal getCodprod() {
        return codprod;
    }

    public void setCodprod(BigDecimal codprod) {
        this.codprod = codprod;
    }

    public BigDecimal getCodfilial() {
        return codfilial;
    }

    public void setCodfilial(BigDecimal codfilial) {
        this.codfilial = codfilial;
    }
      
    
}
