package com.ajel.repository.filter;

import java.math.BigDecimal;

public class AjelTransporteFilter {
    
    private BigDecimal codtransporte;
    
    private BigDecimal numnota;
    
    //private List<Long> transportadora;    
  

    public BigDecimal getCodtransporte() {
        return codtransporte;
    }

    public void setCodtransporte(BigDecimal codtransporte) {
        this.codtransporte = codtransporte;
    }

    public BigDecimal getNumnota() {
        return numnota;
    }

    public void setNumnota(BigDecimal numnota) {
        this.numnota = numnota;
    }       
    
}
