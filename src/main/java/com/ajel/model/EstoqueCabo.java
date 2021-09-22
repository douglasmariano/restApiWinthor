package com.ajel.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "pcestendcabo")
public class EstoqueCabo {
    
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CODENDCABO")
    @SequenceGenerator(name="SEQ_CODENDCABO", sequenceName="SEQ_CODENDCABO",allocationSize=1)
    @Column(name = "codendcabo" ) 
    private Long codendcabo;  
    
    @Column(name = "identificacao" ) 
    private Long identificacao;
    
    @Column(name = "codprod" ) 
    private Long codprod;

    @Column(name = "qt" ) 
    private Long qt;

    @Column(name = "datainclusao" ) 
    private Date datainclusao;

    @Column(name = "dataexclusao" ) 
    private Date dataexclusao;  

    @Column(name = "tipoender" ) 
    private String tipoender;

    @Column(name = "status" ) 
    private String status;

    @Column(name = "codfuncinc" ) 
    private Long codfuncinc;
    
    @Column(name = "fabricante" ) 
    private String fabricante;

    @Column(name = "obs1" ) 
    private String obs1; 

    @Column(name = "embalagem" ) 
    private String embalagem;

    @Column(name = "qtmaster" ) 
    private String qtmaster;

    @Column(name = "numero" ) 
    private Long numero;

    @Column(name = "modulo" ) 
    private Long modulo;

    @Column(name = "rua" ) 
    private Long rua;

    @Column(name = "apto" ) 
    private Long apto;
    
    public EstoqueCabo() {

    }

    public EstoqueCabo(Long codendcabo, Long identificacao, Long codprod, Long qt, Date datainclusao, Date dataexclusao,
            String tipoender, String status, Long codfuncinc, String fabricante, String obs1, String embalagem, String qtmaster,
            Long numero, Long modulo, Long rua, Long apto) {
        super();
        this.codendcabo = codendcabo;
        this.identificacao = identificacao;
        this.codprod = codprod;
        this.qt = qt;
        this.datainclusao = datainclusao;
        this.dataexclusao = dataexclusao;
        this.tipoender = tipoender;
        this.status = status;
        this.codfuncinc = codfuncinc;
        this.fabricante = fabricante;
        this.obs1 = obs1;
        this.embalagem = embalagem;
        this.qtmaster = qtmaster;
        this.numero = numero;
        this.modulo = modulo;
        this.rua = rua;
        this.apto = apto;
    }

    public Long getCodendcabo() {
        return codendcabo;
    }

    public void setCodendcabo(Long codendcabo) {
        this.codendcabo = codendcabo;
    }

    public Long getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(Long identificacao) {
        this.identificacao = identificacao;
    }

    public Long getCodprod() {
        return codprod;
    }

    public void setCodprod(Long codprod) {
        this.codprod = codprod;
    }

    public Long getQt() {
        return qt;
    }

    public void setQt(Long qt) {
        this.qt = qt;
    }

    public Date getDatainclusao() {
        return datainclusao;
    }

    public void setDatainclusao(Date datainclusao) {
        this.datainclusao = datainclusao;
    }

    public Date getDataexclusao() {
        return dataexclusao;
    }

    public void setDataexclusao(Date dataexclusao) {
        this.dataexclusao = dataexclusao;
    }

    public String getTipoender() {
        return tipoender;
    }

    public void setTipoender(String tipoender) {
        this.tipoender = tipoender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCodfuncinc() {
        return codfuncinc;
    }

    public void setCodfuncinc(Long codfuncinc) {
        this.codfuncinc = codfuncinc;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getObs1() {
        return obs1;
    }

    public void setObs1(String obs1) {
        this.obs1 = obs1;
    }

    public String getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(String embalagem) {
        this.embalagem = embalagem;
    }

    public String getQtmaster() {
        return qtmaster;
    }

    public void setQtmaster(String qtmaster) {
        this.qtmaster = qtmaster;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Long getModulo() {
        return modulo;
    }

    public void setModulo(Long modulo) {
        this.modulo = modulo;
    }

    public Long getRua() {
        return rua;
    }

    public void setRua(Long rua) {
        this.rua = rua;
    }

    public Long getApto() {
        return apto;
    }

    public void setApto(Long apto) {
        this.apto = apto;
    }
    



}
