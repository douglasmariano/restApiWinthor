package com.ajel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pcmarca")
public class Marca {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codmarca;
    
    private String marca;
    
    private String ativo;

    public Long getCodmarca() {
        return codmarca;
    }

    public void setCodmarca(Long codmarca) {
        this.codmarca = codmarca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }
    
}
