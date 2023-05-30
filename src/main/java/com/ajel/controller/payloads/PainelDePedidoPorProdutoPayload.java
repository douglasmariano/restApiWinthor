package com.ajel.controller.payloads;

import java.math.BigDecimal;
import java.util.Date;

public class PainelDePedidoPorProdutoPayload {

    private BigDecimal numped;
    private String cliente;
    private BigDecimal codprod;
    private String descricao;
    private BigDecimal qt;
    private BigDecimal qtestger;
    private Date datapedido;
    private String tiposeparacao;
    private String status;
    private Date datachegadacli;
    private Date datainiciosep;
    private Date datafimsep;
    private String posicao;
    private String posicaopedido;
    
    public BigDecimal getNumped() {
        return numped;
    }
    public void setNumped(BigDecimal numped) {
        this.numped = numped;
    }
    public String getCliente() {
        return cliente;
    }
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    public BigDecimal getCodprod() {
        return codprod;
    }
    public void setCodprod(BigDecimal codprod) {
        this.codprod = codprod;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public BigDecimal getQt() {
        return qt;
    }
    public void setQt(BigDecimal qt) {
        this.qt = qt;
    }
    public BigDecimal getQtestger() {
        return qtestger;
    }
    public void setQtestger(BigDecimal qtestger) {
        this.qtestger = qtestger;
    }
    public Date getDatapedido() {
        return datapedido;
    }
    public void setDatapedido(Date datapedido) {
        this.datapedido = datapedido;
    }
    public String getTiposeparacao() {
        return tiposeparacao;
    }
    public void setTiposeparacao(String tiposeparacao) {
        this.tiposeparacao = tiposeparacao;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Date getDatachegadacli() {
        return datachegadacli;
    }
    public void setDatachegadacli(Date datachegadacli) {
        this.datachegadacli = datachegadacli;
    }
    public String getPosicao() {
        return posicao;
    }
    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }
    public Date getDatainiciosep() {
        return datainiciosep;
    }
    public void setDatainiciosep(Date datainiciosep) {
        this.datainiciosep = datainiciosep;
    }
    
    public Date getDatafimsep() {
        return datafimsep;
    }
    public void setDatafimsep(Date datafimsep) {
        this.datafimsep = datafimsep;
    }
    public String getPosicaopedido() {
        return posicaopedido;
    }
    public void setPosicaopedido(String posicaopedido) {
        this.posicaopedido = posicaopedido;
    }
    
    
    
    
    
}
