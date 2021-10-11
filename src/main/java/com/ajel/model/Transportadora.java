package com.ajel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pcfornec")
public class Transportadora {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codfornec;
    
    private String fornecedor;
    
    private  String bloqueio;
    
    private String revenda;

    public Long getCodfornec() {
        return codfornec;
    }

    public void setCodfornec(Long codfornec) {
        this.codfornec = codfornec;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getBloqueio() {
        return bloqueio;
    }

    public void setBloqueio(String bloqueio) {
        this.bloqueio = bloqueio;
    }

    public String getRevenda() {
        return revenda;
    }

    public void setRevenda(String revenda) {
        this.revenda = revenda;
    }
    
    
    

}
