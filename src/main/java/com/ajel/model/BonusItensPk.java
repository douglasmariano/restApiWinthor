package com.ajel.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BonusItensPk implements  Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Column(name="codprod")
    private Long codprod;
    
    @Column(name="numbonus")
    private Long numbonus;   
    
    @Column(name="numlote")
    private String numlote;

    public BonusItensPk() {
        
    }
    

    public BonusItensPk(Long codprod, Long numbonus, String numlote) {
        super();
        this.codprod = codprod;
        this.numbonus = numbonus;
        this.numlote = numlote;
    }

    public Long getCodprod() {
        return codprod;
    }

    public void setCodprod(Long codprod) {
        this.codprod = codprod;
    }

    public Long getNumbonus() {
        return numbonus;
    }

    public void setNumbonus(Long numbonus) {
        this.numbonus = numbonus;
    }


    public String getNumlote() {
        return numlote;
    }


    public void setNumlote(String numlote) {
        this.numlote = numlote;
    }

    
   
   
}