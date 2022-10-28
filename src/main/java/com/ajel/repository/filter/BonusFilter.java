package com.ajel.repository.filter;

import java.util.Date;

public class BonusFilter {
	
	private Long numbonus;
	private Long codprod;
	private String codfilial;
	private Date databonus;
	private Date dtfechamento;
    
	
	public Long getNumbonus() {
        return numbonus;
    }
    public void setNumbonus(Long numbonus) {
        this.numbonus = numbonus;
    }
    public Long getCodprod() {
        return codprod;
    }
    public void setCodprod(Long codprod) {
        this.codprod = codprod;
    }
    public String getCodfilial() {
        return codfilial;
    }
    public void setCodfilial(String codfilial) {
        this.codfilial = codfilial;
    }
    public Date getDatabonus() {
        return databonus;
    }
    public void setDatabonus(Date databonus) {
        this.databonus = databonus;
    }
    public Date getDtfechamento() {
        return dtfechamento;
    }
    public void setDtfechamento(Date dtfechamento) {
        this.dtfechamento = dtfechamento;
    }
	
	
	
}
