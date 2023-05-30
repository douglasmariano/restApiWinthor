package com.ajel.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class NotaFiscalEntradaPK implements  Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public NotaFiscalEntradaPK() {
        
    }
    public NotaFiscalEntradaPK(Long numtransent, String codcont) {
        super();
        this.numtransent = numtransent;
        this.codcont = codcont;
    }

    @Column(name = "numtransent")
    private Long numtransent;
    
    @Column(name = "codcont")
    private String codcont;

    public Long getNumtransent() {
        return numtransent;
    }

    public void setNumtransent(Long numtransent) {
        this.numtransent = numtransent;
    }

    public String getCodcont() {
        return codcont;
    }

    public void setCodcont(String codcont) {
        this.codcont = codcont;
    }

    
}
