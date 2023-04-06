package com.ajel.repository.filter;

import java.util.Date;

public class NotaFiscalEntradaFilter {

    private Long codfilial;
    
    private Long numtransent;
    
    private Long numbonus;
    
    private Long numnotaInicial;
    
    private Long numnotaFinal;
    
    private Date dtent;  
    
    private Long codfornec;

    public Long getCodfilial() {
        return codfilial;
    }

    public void setCodfilial(Long codfilial) {
        this.codfilial = codfilial;
    }

    public Long getNumtransent() {
        return numtransent;
    }

    public void setNumtransent(Long numtransent) {
        this.numtransent = numtransent;
    }

    public Long getNumbonus() {
        return numbonus;
    }

    public void setNumbonus(Long numbonus) {
        this.numbonus = numbonus;
    }

    public Long getNumnotaInicial() {
        return numnotaInicial;
    }

    public void setNumnotaInicial(Long numnotaInicial) {
        this.numnotaInicial = numnotaInicial;
    }

    public Long getNumnotaFinal() {
        return numnotaFinal;
    }

    public void setNumnotaFinal(Long numnotaFinal) {
        this.numnotaFinal = numnotaFinal;
    }

    public Date getDtent() {
        return dtent;
    }

    public void setDtent(Date dtent) {
        this.dtent = dtent;
    }

    public Long getCodfornec() {
        return codfornec;
    }

    public void setCodfornec(Long codfornec) {
        this.codfornec = codfornec;
    }

    
    

   
    
}
