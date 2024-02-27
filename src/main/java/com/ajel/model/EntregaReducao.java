package com.ajel.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="ajel_entrega_reducao")
public class EntregaReducao {
    
    @EmbeddedId
    public EntregaReducaoPK id;    

    @Column(name = "dtincluido")
    public Date dtincluido;

    @Column(name = "dtexcluido")
    public Date dtexcluido;

    @Column(name = "codusur")
    public Long codusur;
    
    @Column(name = "numvolume")
    public Long numvolume;

    
    public EntregaReducao() {
        
    }


    public EntregaReducao(EntregaReducaoPK id, Date dtincluido, Date dtexcluido, Long codusur, Long numvolume) {
        super();
        this.id = id;
        this.dtincluido = dtincluido;
        this.dtexcluido = dtexcluido;
        this.codusur = codusur;
        this.numvolume = numvolume;
    }


    public EntregaReducaoPK getId() {
        return id;
    }


    public void setId(EntregaReducaoPK id) {
        this.id = id;
    }


    public Date getDtincluido() {
        return dtincluido;
    }


    public void setDtincluido(Date dtincluido) {
        this.dtincluido = dtincluido;
    }


    public Date getDtexcluido() {
        return dtexcluido;
    }


    public void setDtexcluido(Date dtexcluido) {
        this.dtexcluido = dtexcluido;
    }


    public Long getCodusur() {
        return codusur;
    }


    public void setCodusur(Long codusur) {
        this.codusur = codusur;
    }


    public Long getNumvolume() {
        return numvolume;
    }


    public void setNumvolume(Long numvolume) {
        this.numvolume = numvolume;
    }


  

}
