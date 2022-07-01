package com.ajel.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pcest")
public class Estoque {
    
    @EmbeddedId
    private EstoquePK estoquePK;  

    @Column(name = "vlultpcompra" ) 
    private Long vlultpcompra;

    @Column(name = "estideal" ) 
    private Long estideal;

    @Column(name = "numero" ) 
    private Long numero;

    @Column(name = "qtest" ) 
    private Long qtest;

    @Column(name = "estmin" ) 
    private Long estmin;

    @Column(name = "qtvendmes" ) 
    private Long qtvendmes;

    @Column(name = "qtvendmes1" ) 
    private Long qtvendmes1;

    @Column(name = "qtvendmes2" ) 
    private Long qtvendmes2;

    @Column(name = "qtvendmes3" ) 
    private Long qtvendmes3;

    @Column(name = "vlvendmes" ) 
    private Long vlvendmes;

    @Column(name = "qtvenddia" ) 
    private Long qtvenddia;

    @Column(name = "vlvenddia" ) 
    private Long vlvenddia;

    @Column(name = "qtpedida" ) 
    private Long qtpedida;

    @Column(name = "qtestant" ) 
    private Long qtestant;

    @Column(name = "qtreserv" ) 
    private Long qtreserv;

    @Column(name = "qtultent" ) 
    private Long qtultent;

    @Column(name = "qtestger" ) 
    private Long qtestger;

    @Column(name = "qtbloqueada" ) 
    private Long qtbloqueada;

    @Column(name = "qtpendente" ) 
    private Long qtpendente;

    @Column(name = "qtgirodia" ) 
    private Long qtgirodia;

    @Column(name = "modulo" ) 
    private Long modulo;

    @Column(name = "rua" ) 
    private Long rua;

    @Column(name = "apto" ) 
    private Long apto;

    @Column(name = "estmax" ) 
    private Long estmax;

    @Column(name = "dtultfat" ) 
    private Date dtultfat;

    @Column(name = "dtemissaoultent" ) 
    private Date dtemissaoultent;

    @Column(name = "dtultent" ) 
    private Date dtultent;

    @Column(name = "dtultsaida" ) 
    private Date dtultsaida;

    @Column(name = "dtultinvent" ) 
    private Date dtultinvent;

    @Column(name = "rotinalanc" ) 
    private String rotinalanc;

    @Column(name = "fimestoque" ) 
    private String fimestoque;

    @Column(name = "motivobloqestoque" ) 
    private String motivobloqestoque;
    
    @Column(name = "codauxiliar" ) 
    private String codauxiliar;
    
    @Column(name = "codauxiliar2" ) 
    private String codauxiliar2;
    
    public Estoque() {
    
    }

    public Estoque(EstoquePK estoquePK, Long vlultpcompra, Long estideal, Long numero, Long qtest, Long estmin, Long qtvendmes,
            Long qtvendmes1, Long qtvendmes2, Long qtvendmes3, Long vlvendmes, Long qtvenddia, Long vlvenddia, Long qtpedida,
            Long qtestant, Long qtreserv, Long qtultent, Long qtestger, Long qtbloqueada, Long qtpendente, Long qtgirodia,
            Long modulo, Long rua, Long apto, Long estmax, Date dtultfat, Date dtemissaoultent, Date dtultent, Date dtultsaida,
            Date dtultinvent, String rotinalanc, String fimestoque, String motivobloqestoque, String codauxiliar, String codauxiliar2) {
        super();
        this.estoquePK = estoquePK;
        this.vlultpcompra = vlultpcompra;
        this.estideal = estideal;
        this.numero = numero;
        this.qtest = qtest;
        this.estmin = estmin;
        this.qtvendmes = qtvendmes;
        this.qtvendmes1 = qtvendmes1;
        this.qtvendmes2 = qtvendmes2;
        this.qtvendmes3 = qtvendmes3;
        this.vlvendmes = vlvendmes;
        this.qtvenddia = qtvenddia;
        this.vlvenddia = vlvenddia;
        this.qtpedida = qtpedida;
        this.qtestant = qtestant;
        this.qtreserv = qtreserv;
        this.qtultent = qtultent;
        this.qtestger = qtestger;
        this.qtbloqueada = qtbloqueada;
        this.qtpendente = qtpendente;
        this.qtgirodia = qtgirodia;
        this.modulo = modulo;
        this.rua = rua;
        this.apto = apto;
        this.estmax = estmax;
        this.dtultfat = dtultfat;
        this.dtemissaoultent = dtemissaoultent;
        this.dtultent = dtultent;
        this.dtultsaida = dtultsaida;
        this.dtultinvent = dtultinvent;
        this.rotinalanc = rotinalanc;
        this.fimestoque = fimestoque;
        this.motivobloqestoque = motivobloqestoque;
        this.codauxiliar = codauxiliar;
        this.codauxiliar2 = codauxiliar2;
    }

    public EstoquePK getEstoquePK() {
        return estoquePK;
    }

    public void setEstoquePK(EstoquePK estoquePK) {
        this.estoquePK = estoquePK;
    }

    public Long getVlultpcompra() {
        return vlultpcompra;
    }

    public void setVlultpcompra(Long vlultpcompra) {
        this.vlultpcompra = vlultpcompra;
    }

    public Long getEstideal() {
        return estideal;
    }

    public void setEstideal(Long estideal) {
        this.estideal = estideal;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Long getQtest() {
        return qtest;
    }

    public void setQtest(Long qtest) {
        this.qtest = qtest;
    }

    public Long getEstmin() {
        return estmin;
    }

    public void setEstmin(Long estmin) {
        this.estmin = estmin;
    }

    public Long getQtvendmes() {
        return qtvendmes;
    }

    public void setQtvendmes(Long qtvendmes) {
        this.qtvendmes = qtvendmes;
    }

    public Long getQtvendmes1() {
        return qtvendmes1;
    }

    public void setQtvendmes1(Long qtvendmes1) {
        this.qtvendmes1 = qtvendmes1;
    }

    public Long getQtvendmes2() {
        return qtvendmes2;
    }

    public void setQtvendmes2(Long qtvendmes2) {
        this.qtvendmes2 = qtvendmes2;
    }

    public Long getQtvendmes3() {
        return qtvendmes3;
    }

    public void setQtvendmes3(Long qtvendmes3) {
        this.qtvendmes3 = qtvendmes3;
    }

    public Long getVlvendmes() {
        return vlvendmes;
    }

    public void setVlvendmes(Long vlvendmes) {
        this.vlvendmes = vlvendmes;
    }

    public Long getQtvenddia() {
        return qtvenddia;
    }

    public void setQtvenddia(Long qtvenddia) {
        this.qtvenddia = qtvenddia;
    }

    public Long getVlvenddia() {
        return vlvenddia;
    }

    public void setVlvenddia(Long vlvenddia) {
        this.vlvenddia = vlvenddia;
    }

    public Long getQtpedida() {
        return qtpedida;
    }

    public void setQtpedida(Long qtpedida) {
        this.qtpedida = qtpedida;
    }

    public Long getQtestant() {
        return qtestant;
    }

    public void setQtestant(Long qtestant) {
        this.qtestant = qtestant;
    }

    public Long getQtreserv() {
        return qtreserv;
    }

    public void setQtreserv(Long qtreserv) {
        this.qtreserv = qtreserv;
    }

    public Long getQtultent() {
        return qtultent;
    }

    public void setQtultent(Long qtultent) {
        this.qtultent = qtultent;
    }

    public Long getQtestger() {
        return qtestger;
    }

    public void setQtestger(Long qtestger) {
        this.qtestger = qtestger;
    }

    public Long getQtbloqueada() {
        return qtbloqueada;
    }

    public void setQtbloqueada(Long qtbloqueada) {
        this.qtbloqueada = qtbloqueada;
    }

    public Long getQtpendente() {
        return qtpendente;
    }

    public void setQtpendente(Long qtpendente) {
        this.qtpendente = qtpendente;
    }

    public Long getQtgirodia() {
        return qtgirodia;
    }

    public void setQtgirodia(Long qtgirodia) {
        this.qtgirodia = qtgirodia;
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

    public Long getEstmax() {
        return estmax;
    }

    public void setEstmax(Long estmax) {
        this.estmax = estmax;
    }

    public Date getDtultfat() {
        return dtultfat;
    }

    public void setDtultfat(Date dtultfat) {
        this.dtultfat = dtultfat;
    }

    public Date getDtemissaoultent() {
        return dtemissaoultent;
    }

    public void setDtemissaoultent(Date dtemissaoultent) {
        this.dtemissaoultent = dtemissaoultent;
    }

    public Date getDtultent() {
        return dtultent;
    }

    public void setDtultent(Date dtultent) {
        this.dtultent = dtultent;
    }

    public Date getDtultsaida() {
        return dtultsaida;
    }

    public void setDtultsaida(Date dtultsaida) {
        this.dtultsaida = dtultsaida;
    }

    public Date getDtultinvent() {
        return dtultinvent;
    }

    public void setDtultinvent(Date dtultinvent) {
        this.dtultinvent = dtultinvent;
    }

    public String getRotinalanc() {
        return rotinalanc;
    }

    public void setRotinalanc(String rotinalanc) {
        this.rotinalanc = rotinalanc;
    }

    public String getFimestoque() {
        return fimestoque;
    }

    public void setFimestoque(String fimestoque) {
        this.fimestoque = fimestoque;
    }

    public String getMotivobloqestoque() {
        return motivobloqestoque;
    }

    public void setMotivobloqestoque(String motivobloqestoque) {
        this.motivobloqestoque = motivobloqestoque;
    }

    public String getCodauxiliar() {
        return codauxiliar;
    }

    public void setCodauxiliar(String codauxiliar) {
        this.codauxiliar = codauxiliar;
    }

    public String getCodauxiliar2() {
        return codauxiliar2;
    }

    public void setCodauxiliar2(String codauxiliar2) {
        this.codauxiliar2 = codauxiliar2;
    }

    

}
