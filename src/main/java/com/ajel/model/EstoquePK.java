package com.ajel.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EstoquePK implements  Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Column(name="codprod")
    private Long codprod;
    
    @Column(name="codfilial")
    private Long codfilial;    

    public EstoquePK() {
        
    }

    public EstoquePK(Long codprod, Long codfilial) {
        super();
        this.codprod = codprod;
        this.codfilial = codfilial;
    }

    public Long getCodprod() {
        return codprod;
    }

    public void setCodprod(Long codprod) {
        this.codprod = codprod;
    }

    public Long getCodfilial() {
        return codfilial;
    }

    public void setCodfilial(Long codfilial) {
        this.codfilial = codfilial;
    }
    

   
}