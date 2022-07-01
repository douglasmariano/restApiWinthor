package com.ajel.repository.filter;

import java.util.Date;

public class NotaFiscalSaidaFilter {

    private Long codfilial;
    
    private Long numtransvenda;
    
    private Long numnotaInicial;
    
    private Long numnotaFinal;
    
    private Date dtsaida;
    
    private Date dtcanhoto;
    
    private Long codcli;
    
    

    public Long getCodfilial() {
        return codfilial;
    }

    public void setCodfilial(Long codfilial) {
        this.codfilial = codfilial;
    }

    public Long getNumtransvenda() {
        return numtransvenda;
    }

    public void setNumtransvenda(Long numtransvenda) {
        this.numtransvenda = numtransvenda;
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

    public Date getDtsaida() {
        return dtsaida;
    }

    public void setDtsaida(Date dtsaida) {
        this.dtsaida = dtsaida;
    }

    public Date getDtcanhoto() {
        return dtcanhoto;
    }

    public void setDtcanhoto(Date dtcanhoto) {
        this.dtcanhoto = dtcanhoto;
    }

    public Long getCodcli() {
        return codcli;
    }

    public void setCodcli(Long codcli) {
        this.codcli = codcli;
    }
    
    
}
