package com.ajel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pctabdev")
public class MotivoBloqueio {

    
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long coddevol;
    
    private String motivo;
    
    private String tipo;

    public Long getCoddevol() {
        return coddevol;
    }

    public void setCoddevol(Long coddevol) {
        this.coddevol = coddevol;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    

}
