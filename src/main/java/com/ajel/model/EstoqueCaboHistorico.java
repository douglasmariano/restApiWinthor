package com.ajel.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "ajel_cabo_historico")
public class EstoqueCaboHistorico {
    
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CODTRANSACAOCABO")
    @SequenceGenerator(name="SEQ_CODTRANSACAOCABO", sequenceName="SEQ_CODTRANSACAOCABO",allocationSize=1)
    @Column(name = "codtransacaocabo" ) 
    private Long codtransacaocabo;  
    
    @Column(name = "codcabo" ) 
    private Long codcabo;  
       
    @Column(name = "codprod_pcest" ) 
    private Long codprod_pcest;
    
    @Column(name = "codfilial_pcest" ) 
    private String codfilial_pcest;
   
    @MapsId(value="codcabo")
    @ManyToOne
    @JoinColumn(name="codcabo",referencedColumnName = "codcabo")
    private EstoqueCabo estoqueCabo;
 
    @Column(name = "tipotransacao" ) 
    private String tipotransacao;
        
    @Column(name = "dttransacao" ) 
    private Date dttransacao;

    @Column(name = "qt" ) 
    private Long qt;
    
    @Column(name = "matricula" ) 
    private Long matricula;

      public EstoqueCaboHistorico() {
        
    }

    public EstoqueCaboHistorico(Long codtransacaocabo, Long codcabo, Long codprod_pcest, String codfilial_pcest,
            EstoqueCabo estoqueCabo, String tipotransacao, Date dttransacao, Long qt, Long matricula) {
        super();
        this.codtransacaocabo = codtransacaocabo;
        this.codcabo = codcabo;
        this.codprod_pcest = codprod_pcest;
        this.codfilial_pcest = codfilial_pcest;
        this.estoqueCabo = estoqueCabo;
        this.tipotransacao = tipotransacao;
        this.dttransacao = dttransacao;
        this.qt = qt;
        this.matricula = matricula;
    }

    public Long getCodtransacaocabo() {
        return codtransacaocabo;
    }

    public void setCodtransacaocabo(Long codtransacaocabo) {
        this.codtransacaocabo = codtransacaocabo;
    }

    public Long getCodcabo() {
        return codcabo;
    }

    public void setCodcabo(Long codcabo) {
        this.codcabo = codcabo;
    }

    public Long getCodprod_pcest() {
        return codprod_pcest;
    }

    public void setCodprod_pcest(Long codprod_pcest) {
        this.codprod_pcest = codprod_pcest;
    }

    public String getCodfilial_pcest() {
        return codfilial_pcest;
    }

    public void setCodfilial_pcest(String codfilial_pcest) {
        this.codfilial_pcest = codfilial_pcest;
    }

    public EstoqueCabo getEstoqueCabo() {
        return estoqueCabo;
    }

    public void setEstoqueCabo(EstoqueCabo estoqueCabo) {
        this.estoqueCabo = estoqueCabo;
    }

    public String getTipotransacao() {
        return tipotransacao;
    }

    public void setTipotransacao(String tipotransacao) {
        this.tipotransacao = tipotransacao;
    }

    public Date getDttransacao() {
        return dttransacao;
    }

    public void setDttransacao(Date dttransacao) {
        this.dttransacao = dttransacao;
    }

    public Long getQt() {
        return qt;
    }

    public void setQt(Long qt) {
        this.qt = qt;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }
      

    
    
}
