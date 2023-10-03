package com.ajel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PCVEICUL")
public class Veiculo {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codveiculo;
    
    private String descricao;
    
    private String placa;
    
    private String situacao;

    private String obs;
    
    private String rastreado;
    
    private String kmatual;
    
    public Veiculo() {
        
    }

    public Veiculo(Long codveiculo, String descricao, String placa, String situacao, String obs, String rastreado,
            String kmatual) {
        super();
        this.codveiculo = codveiculo;
        this.descricao = descricao;
        this.placa = placa;
        this.situacao = situacao;
        this.obs = obs;
        this.rastreado = rastreado;
        this.kmatual = kmatual;
    }

    public Long getCodveiculo() {
        return codveiculo;
    }

    public void setCodveiculo(Long codveiculo) {
        this.codveiculo = codveiculo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getRastreado() {
        return rastreado;
    }

    public void setRastreado(String rastreado) {
        this.rastreado = rastreado;
    }

    public String getKmatual() {
        return kmatual;
    }

    public void setKmatual(String kmatual) {
        this.kmatual = kmatual;
    }
    
    
    

}
