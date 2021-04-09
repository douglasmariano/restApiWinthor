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
    
    @Column(name = "codprod" ) 
    private Long codprod;

    @Column(name = "qt" ) 
    private Long qt;

    @Column(name = "qtreserv" ) 
    private Long qtreserv;

    @Column(name = "dtultmovsai" ) 
    private Date dtultmovsai;

    @Column(name = "dtultmovent" ) 
    private Date dtultmovent;

    @Column(name = "dtvalidade" ) 
    private Date dtvalidade;

    @Column(name = "tipoender" ) 
    private String tipoender;

    @Column(name = "status" ) 
    private String status;

    @Column(name = "numbonus" ) 
    private Long numbonus;

    @Column(name = "codfuncrm" ) 
    private Long codfuncrm;

    @Column(name = "databloqueio" ) 
    private Date databloqueio;

    @Column(name = "datadesbloqueio" ) 
    private Date datadesbloqueio;

    @Column(name = "codfuncdesbloqueio" ) 
    private Long codfuncdesbloqueio;

    @Column(name = "datafabricacao" ) 
    private Date datafabricacao;

    @Column(name = "numlote" ) 
    private Long numlote;

    @Column(name = "qtbloqueada" ) 
    private Long qtbloqueada;

    @Column(name = "numlotefab" ) 
    private Long numlotefab;

    @Column(name = "numlotefornec" ) 
    private Long numlotefornec;

    @Column(name = "fabricante" ) 
    private String fabricante;

    @Column(name = "obs1" ) 
    private String obs1;

    @Column(name = "obs2" ) 
    private String obs2;

    @Column(name = "embalagem" ) 
    private String embalagem;

    @Column(name = "umidade" ) 
    private String umidade;

    @Column(name = "numtransent" ) 
    private Long numtransent;

    @Column(name = "identificacao" ) 
    private String identificacao;

    @Column(name = "codequipe" ) 
    private Long codequipe;

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

    public EstoqueCabo(Long codendcabo, Long codprod, Long qt, Long qtreserv, Date dtultmovsai, Date dtultmovent,
            Date dtvalidade, String tipoender, String status, Long numbonus, String tipoalturapalete, Long codfuncrm,
            Date databloqueio, Date datadesbloqueio, Long codfuncdesbloqueio, Date datafabricacao, Long numlote,
            Long qtbloqueada, Long numlotefab, Long numlotefornec, String fabricante, String obs1, String obs2,
            String embalagem, String umidade, Long numtransent, String identificacao, Long codequipe, Long numero, Long modulo,
            Long rua, Long apto) {
        super();
        this.codendcabo = codendcabo;
        this.codprod = codprod;
        this.qt = qt;
        this.qtreserv = qtreserv;
        this.dtultmovsai = dtultmovsai;
        this.dtultmovent = dtultmovent;
        this.dtvalidade = dtvalidade;
        this.tipoender = tipoender;
        this.status = status;
        this.numbonus = numbonus;
        this.codfuncrm = codfuncrm;
        this.databloqueio = databloqueio;
        this.datadesbloqueio = datadesbloqueio;
        this.codfuncdesbloqueio = codfuncdesbloqueio;
        this.datafabricacao = datafabricacao;
        this.numlote = numlote;
        this.qtbloqueada = qtbloqueada;
        this.numlotefab = numlotefab;
        this.numlotefornec = numlotefornec;
        this.fabricante = fabricante;
        this.obs1 = obs1;
        this.obs2 = obs2;
        this.embalagem = embalagem;
        this.umidade = umidade;
        this.numtransent = numtransent;
        this.identificacao = identificacao;
        this.codequipe = codequipe;
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

    public Long getQtreserv() {
        return qtreserv;
    }

    public void setQtreserv(Long qtreserv) {
        this.qtreserv = qtreserv;
    }

    public Date getDtultmovsai() {
        return dtultmovsai;
    }

    public void setDtultmovsai(Date dtultmovsai) {
        this.dtultmovsai = dtultmovsai;
    }

    public Date getDtultmovent() {
        return dtultmovent;
    }

    public void setDtultmovent(Date dtultmovent) {
        this.dtultmovent = dtultmovent;
    }

    public Date getDtvalidade() {
        return dtvalidade;
    }

    public void setDtvalidade(Date dtvalidade) {
        this.dtvalidade = dtvalidade;
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

    public Long getNumbonus() {
        return numbonus;
    }

    public void setNumbonus(Long numbonus) {
        this.numbonus = numbonus;
    }

    public Long getCodfuncrm() {
        return codfuncrm;
    }

    public void setCodfuncrm(Long codfuncrm) {
        this.codfuncrm = codfuncrm;
    }

    public Date getDatabloqueio() {
        return databloqueio;
    }

    public void setDatabloqueio(Date databloqueio) {
        this.databloqueio = databloqueio;
    }

    public Date getDatadesbloqueio() {
        return datadesbloqueio;
    }

    public void setDatadesbloqueio(Date datadesbloqueio) {
        this.datadesbloqueio = datadesbloqueio;
    }

    public Long getCodfuncdesbloqueio() {
        return codfuncdesbloqueio;
    }

    public void setCodfuncdesbloqueio(Long codfuncdesbloqueio) {
        this.codfuncdesbloqueio = codfuncdesbloqueio;
    }

    public Date getDatafabricacao() {
        return datafabricacao;
    }

    public void setDatafabricacao(Date datafabricacao) {
        this.datafabricacao = datafabricacao;
    }

    public Long getNumlote() {
        return numlote;
    }

    public void setNumlote(Long numlote) {
        this.numlote = numlote;
    }

    public Long getQtbloqueada() {
        return qtbloqueada;
    }

    public void setQtbloqueada(Long qtbloqueada) {
        this.qtbloqueada = qtbloqueada;
    }

    public Long getNumlotefab() {
        return numlotefab;
    }

    public void setNumlotefab(Long numlotefab) {
        this.numlotefab = numlotefab;
    }

    public Long getNumlotefornec() {
        return numlotefornec;
    }

    public void setNumlotefornec(Long numlotefornec) {
        this.numlotefornec = numlotefornec;
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

    public String getObs2() {
        return obs2;
    }

    public void setObs2(String obs2) {
        this.obs2 = obs2;
    }

    public String getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(String embalagem) {
        this.embalagem = embalagem;
    }

    public String getUmidade() {
        return umidade;
    }

    public void setUmidade(String umidade) {
        this.umidade = umidade;
    }

    public Long getNumtransent() {
        return numtransent;
    }

    public void setNumtransent(Long numtransent) {
        this.numtransent = numtransent;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public Long getCodequipe() {
        return codequipe;
    }

    public void setCodequipe(Long codequipe) {
        this.codequipe = codequipe;
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
