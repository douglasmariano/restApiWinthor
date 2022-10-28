package com.ajel.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CodigoDeBarrasPK implements  Serializable {
    

     
    private static final long serialVersionUID = 1L;
    
    private Long codprod;
    private String codbarra;
   

    public CodigoDeBarrasPK() {
        
    }

    public CodigoDeBarrasPK(Long codprod, String codbarra) {
        super();
        this.codprod = codprod;
        this.codbarra = codbarra;
    }

    public Long getCodprod() {
        return codprod;
    }

    public void setCodprod(Long codprod) {
        this.codprod = codprod;
    }

    public String getCodbarra() {
        return codbarra;
    }

    public void setCodbarra(String codbarra) {
        this.codbarra = codbarra;
    }

  
   
}