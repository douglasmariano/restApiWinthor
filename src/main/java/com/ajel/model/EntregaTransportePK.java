package com.ajel.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EntregaTransportePK implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Column(name="codtransporte")
    private Long codtransporte;  
    
    @Column(name="codentrega")
    private Long  codentrega;   

   
    public EntregaTransportePK() {
        
    }


    public EntregaTransportePK(Long codtransporte, Long codentrega) {
        super();
        this.codtransporte = codtransporte;
        this.codentrega = codentrega;
    }


    public Long getCodtransporte() {
        return codtransporte;
    }


    public void setCodtransporte(Long codtransporte) {
        this.codtransporte = codtransporte;
    }


    public Long getCodentrega() {
        return codentrega;
    }


    public void setCodentrega(Long codentrega) {
        this.codentrega = codentrega;
    }



}
