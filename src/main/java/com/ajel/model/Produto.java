package com.ajel.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pcprodut")
public class Produto {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codprod" ) 
    private Long codprod;

    @Column(name = "pesoliq" ) 
    private Long pesoliq;

    @Column(name = "pesobruto" ) 
    private Long pesobruto;

    @Column(name = "codepto" ) 
    private Long codepto;

    @Column(name = "codsec" ) 
    private Long codsec;

    @Column(name = "qtunit" ) 
    private Long qtunit;

    @Column(name = "codfornec" ) 
    private Long codfornec;

    @Column(name = "volume" ) 
    private Long volume;

    @Column(name = "codauxiliar" ) 
    private Long codauxiliar;
    
    @Column(name = "codauxiliar2" ) 
    private Long codauxiliar2;

    @Column(name = "modulo" ) 
    private Long modulo;

    @Column(name = "numero" ) 
    private Long numero;

    @Column(name = "rua" ) 
    private Long rua;

    @Column(name = "apto" ) 
    private Long apto;

    @Column(name = "codprodprinc" ) 
    private Long codprodprinc;

    @Column(name = "codmarca" ) 
    private Long codmarca;

    @Column(name = "codrotinaultalter" ) 
    private Long codrotinaultalter;

    @Column(name = "dtultatupcompra" ) 
    private Date dtultatupcompra;

    @Column(name = "dtcadastro" ) 
    private Date dtcadastro;

    @Column(name = "dtexclusao" ) 
    private Date dtexclusao;

    @Column(name = "dtultaltcom" ) 
    private Date dtultaltcom;

    @Column(name = "dtultalter" ) 
    private Date dtultalter;

    @Column(name = "nbm" ) 
    private String nbm;

    @Column(name = "codfab" ) 
    private String codfab;

    @Column(name = "rotinalanc" ) 
    private String rotinalanc;

    @Column(name = "catergoria" ) 
    private String catergoria;

    @Column(name = "descricao" ) 
    private String descricao;

    @Column(name = "embalagem" ) 
    private String embalagem;

    @Column(name = "unidade" ) 
    private String unidade;

    @Column(name = "obs" ) 
    private String obs;

    @Column(name = "obs2" ) 
    private String obs2;

    @Column(name = "dadostecnicos" ) 
    private String dadostecnicos;
    
    public Produto() {

    }

    public Produto(Long codprod, Long pesoliq, Long pesobruto, Long codepto, Long codsec, Long qtunit, Long codfornec,
            Long volume, Long codauxiliar,  Long codauxiliar2, Long modulo, Long numero, Long rua, Long apto, Long codprodprinc, Long codmarca,
            Long codrotinaultalter, Date dtultatupcompra, Date dtcadastro, Date dtexclusao, Date dtultaltcom, Date dtultalter,
            String nbm, String codfab, String rotinalanc, String catergoria, String descricao, String embalagem, String unidade,
            String obs, String obs2, String dadostecnicos) {
        super();
        this.codprod = codprod;
        this.pesoliq = pesoliq;
        this.pesobruto = pesobruto;
        this.codepto = codepto;
        this.codsec = codsec;
        this.qtunit = qtunit;
        this.codfornec = codfornec;
        this.volume = volume;
        this.codauxiliar = codauxiliar;
        this.codauxiliar2 = codauxiliar2;
        this.modulo = modulo;
        this.numero = numero;
        this.rua = rua;
        this.apto = apto;
        this.codprodprinc = codprodprinc;
        this.codmarca = codmarca;
        this.codrotinaultalter = codrotinaultalter;
        this.dtultatupcompra = dtultatupcompra;
        this.dtcadastro = dtcadastro;
        this.dtexclusao = dtexclusao;
        this.dtultaltcom = dtultaltcom;
        this.dtultalter = dtultalter;
        this.nbm = nbm;
        this.codfab = codfab;
        this.rotinalanc = rotinalanc;
        this.catergoria = catergoria;
        this.descricao = descricao;
        this.embalagem = embalagem;
        this.unidade = unidade;
        this.obs = obs;
        this.obs2 = obs2;
        this.dadostecnicos = dadostecnicos;
    }

    public Long getCodprod() {
        return codprod;
    }

    public void setCodprod(Long codprod) {
        this.codprod = codprod;
    }

    public Long getPesoliq() {
        return pesoliq;
    }

    public void setPesoliq(Long pesoliq) {
        this.pesoliq = pesoliq;
    }

    public Long getPesobruto() {
        return pesobruto;
    }

    public void setPesobruto(Long pesobruto) {
        this.pesobruto = pesobruto;
    }

    public Long getCodepto() {
        return codepto;
    }

    public void setCodepto(Long codepto) {
        this.codepto = codepto;
    }

    public Long getCodsec() {
        return codsec;
    }

    public void setCodsec(Long codsec) {
        this.codsec = codsec;
    }

    public Long getQtunit() {
        return qtunit;
    }

    public void setQtunit(Long qtunit) {
        this.qtunit = qtunit;
    }

    public Long getCodfornec() {
        return codfornec;
    }

    public void setCodfornec(Long codfornec) {
        this.codfornec = codfornec;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public Long getCodauxiliar() {
        return codauxiliar;
    }

    public void setCodauxiliar(Long codauxiliar) {
        this.codauxiliar = codauxiliar;
    }

    public Long getModulo() {
        return modulo;
    }

    public void setModulo(Long modulo) {
        this.modulo = modulo;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
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

    public Long getCodprodprinc() {
        return codprodprinc;
    }

    public void setCodprodprinc(Long codprodprinc) {
        this.codprodprinc = codprodprinc;
    }

    public Long getCodmarca() {
        return codmarca;
    }

    public void setCodmarca(Long codmarca) {
        this.codmarca = codmarca;
    }

    public Long getCodrotinaultalter() {
        return codrotinaultalter;
    }

    public void setCodrotinaultalter(Long codrotinaultalter) {
        this.codrotinaultalter = codrotinaultalter;
    }

    public Date getDtultatupcompra() {
        return dtultatupcompra;
    }

    public void setDtultatupcompra(Date dtultatupcompra) {
        this.dtultatupcompra = dtultatupcompra;
    }

    public Date getDtcadastro() {
        return dtcadastro;
    }

    public void setDtcadastro(Date dtcadastro) {
        this.dtcadastro = dtcadastro;
    }

    public Date getDtexclusao() {
        return dtexclusao;
    }

    public void setDtexclusao(Date dtexclusao) {
        this.dtexclusao = dtexclusao;
    }

    public Date getDtultaltcom() {
        return dtultaltcom;
    }

    public void setDtultaltcom(Date dtultaltcom) {
        this.dtultaltcom = dtultaltcom;
    }

    public Date getDtultalter() {
        return dtultalter;
    }

    public void setDtultalter(Date dtultalter) {
        this.dtultalter = dtultalter;
    }

    public String getNbm() {
        return nbm;
    }

    public void setNbm(String nbm) {
        this.nbm = nbm;
    }

    public String getCodfab() {
        return codfab;
    }

    public void setCodfab(String codfab) {
        this.codfab = codfab;
    }

    public String getRotinalanc() {
        return rotinalanc;
    }

    public void setRotinalanc(String rotinalanc) {
        this.rotinalanc = rotinalanc;
    }

    public String getCatergoria() {
        return catergoria;
    }

    public void setCatergoria(String catergoria) {
        this.catergoria = catergoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(String embalagem) {
        this.embalagem = embalagem;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getObs2() {
        return obs2;
    }

    public void setObs2(String obs2) {
        this.obs2 = obs2;
    }

    public String getDadostecnicos() {
        return dadostecnicos;
    }

    public void setDadostecnicos(String dadostecnicos) {
        this.dadostecnicos = dadostecnicos;
    }

    public Long getCodauxiliar2() {
        return codauxiliar2;
    }

    public void setCodauxiliar2(Long codauxiliar2) {
        this.codauxiliar2 = codauxiliar2;
    }
    
    
}
