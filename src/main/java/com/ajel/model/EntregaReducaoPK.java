package com.ajel.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EntregaReducaoPK implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Column(name="codfilial")
    private Long codfilial;  
    
    @Column(name="codentrega")
    private Long  codentrega;   

    @Column(name="numnota")
    private Long numnota;  
   
    public EntregaReducaoPK() {
        
    }

    public EntregaReducaoPK(Long codfilial, Long codentrega, Long numnota) {
        super();
        this.codfilial = codfilial;
        this.codentrega = codentrega;
        this.numnota = numnota;
    }

    public Long getCodfilial() {
        return codfilial;
    }

    public void setCodfilial(Long codfilial) {
        this.codfilial = codfilial;
    }

    public Long getCodentrega() {
        return codentrega;
    }

    public void setCodentrega(Long codentrega) {
        this.codentrega = codentrega;
    }

    public Long getNumnota() {
        return numnota;
    }

    public void setNumnota(Long numnota) {
        this.numnota = numnota;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    
    


}
