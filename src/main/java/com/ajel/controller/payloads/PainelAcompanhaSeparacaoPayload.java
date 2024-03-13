package com.ajel.controller.payloads;

import java.math.BigDecimal;
import java.util.Date;

public class PainelAcompanhaSeparacaoPayload {
   
    private String tempodecorrido;
    private String localseparacao;
    private String tiposeparacao;
    private BigDecimal numped;
    private BigDecimal codigovendedor;
    private String nome;
    private BigDecimal codigocliente;
    private String cliente;
    private BigDecimal vltotal;
    private String posicao;
    private Date datapedido;
    private Date datachegadacli;
    private String codfilial;
    private BigDecimal qtitem;
    private BigDecimal viasimpressas;
    private BigDecimal viasimpressasgalpao;
    
    
    public String getTempodecorrido() {
        return tempodecorrido;
    }
    public void setTempodecorrido(String tempodecorrido) {
        this.tempodecorrido = tempodecorrido;
    }
    public String getLocalseparacao() {
        return localseparacao;
    }
    public void setLocalseparacao(String localseparacao) {
        this.localseparacao = localseparacao;
    }
    public String getTiposeparacao() {
        return tiposeparacao;
    }
    public void setTiposeparacao(String tiposeparacao) {
        this.tiposeparacao = tiposeparacao;
    }
    public BigDecimal getNumped() {
        return numped;
    }
    public void setNumped(BigDecimal numped) {
        this.numped = numped;
    }
    public BigDecimal getCodigovendedor() {
        return codigovendedor;
    }
    public void setCodigovendedor(BigDecimal codigovendedor) {
        this.codigovendedor = codigovendedor;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public BigDecimal getCodigocliente() {
        return codigocliente;
    }
    public void setCodigocliente(BigDecimal codigocliente) {
        this.codigocliente = codigocliente;
    }
    public String getCliente() {
        return cliente;
    }
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    public BigDecimal getVltotal() {
        return vltotal;
    }
    public void setVltotal(BigDecimal vltotal) {
        this.vltotal = vltotal;
    }
    public String getPosicao() {
        return posicao;
    }
    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }
    public Date getDatapedido() {
        return datapedido;
    }
    public void setDatapedido(Date datapedido) {
        this.datapedido = datapedido;
    }
    public Date getDatachegadacli() {
        return datachegadacli;
    }
    public void setDatachegadacli(Date datachegadacli) {
        this.datachegadacli = datachegadacli;
    }
    public String getCodfilial() {
        return codfilial;
    }
    public void setCodfilial(String codfilial) {
        this.codfilial = codfilial;
    }
    public BigDecimal getQtitem() {
        return qtitem;
    }
    public void setQtitem(BigDecimal qtitem) {
        this.qtitem = qtitem;
    }
    public BigDecimal getViasimpressas() {
        return viasimpressas;
    }
    public void setViasimpressas(BigDecimal viasimpressas) {
        this.viasimpressas = viasimpressas;
    }
    public BigDecimal getViasimpressasgalpao() {
        return viasimpressasgalpao;
    }
    public void setViasimpressasgalpao(BigDecimal viasimpressasgalpao) {
        this.viasimpressasgalpao = viasimpressasgalpao;
    }
    
    
    
    

}
