package com.ajel.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name ="ajel_entrega")
public class AjelEntrega {
    
    @SequenceGenerator(name = "SEQ_codentrega", sequenceName = "SEQ_codentrega", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_codentrega")
    @Id
    @Column(name = "codentrega")
    public Long codentrega;
    
    @Column(name = "obsdoentregador")
    public String obsdoentregador;

    @Column(name = "local")
    public String local;
    
    @Column(name = "estcob")
    public String estcob;
        
    @Column(name = "codcidade")
    public BigDecimal codcidade;
    
    @Column(name = "nomecidade")
    public String nomecidade;
    
    
    @Column(name = "endercob")
    public String endercob;

    @Column(name = "numnota")
    public BigDecimal numnota;
    
    @Column(name = "posicao")
    public String posicao;

    @Column(name = "codusur")
    public BigDecimal codusur;
    
    @Column(name = "nomevendedor")
    public String nomevendedor;

    @Column(name = "dtfat")
    public Date dtfat;
  
    @Column(name = "dtentrega")
    public Date dtentrega;
    
    @Column(name = "codfornecfrete")
    public BigDecimal codfornecfrete;
    
    @Column(name = "fornecedor")
    public String fornecedor;
    
    @Column(name = "codmotorista")
    public BigDecimal codmotorista;
    
    @Column(name = "nomemotorista")
    public String nomemotorista;
    
    @Column(name = "codcli")
    public BigDecimal codcli;
    
    @Column(name = "nomecliente")
    public String nomecliente;
    
    @Column(name = "obs")
    public String obs;
    
    @Column(name = "obs1")
    public String obs1;
    
    @Column(name = "obsentrega1")
    public String obsentrega1;
    
    @Column(name = "obsentrega2")
    public String obsentrega2;
    
    @Column(name = "obsentrega3")
    public String obsentrega3;
    
    @Column(name = "codfuncconf")
    public BigDecimal codfuncconf;
    
    @Column(name = "nomeconf")
    public String nomeconf;
    
    @Column(name = "vlatend")
    public BigDecimal vlatend;
    
    @Column(name = "numvolume")
    public BigDecimal numvolume;
   
    @Column(name = "dtinclusao")
    public Date dtinclusao;
  
    @Column(name = "dtexclusao")
    public Date dtexclusao;


    public AjelEntrega() {
    }



    public AjelEntrega(Long codentrega, String obsdoentregador, String local, String estcob, BigDecimal codcidade,String nomecidade, String endercob,
            BigDecimal numnota, String posicao, BigDecimal codusur, String nomevendedor, Date dtfat, Date dtentrega, BigDecimal codfornecfrete,
            String fornecedor, BigDecimal codmotorista, String nomemotorista, BigDecimal codcli, String nomecliente, String obs,
            String obs1, String obsentrega1, String obsentrega2, String obsentrega3, BigDecimal codfuncconf, String nomeconf,
            BigDecimal vlatend, BigDecimal numvolume, Date dtinclusao, Date dtexclusao) {
        super();
        this.codentrega = codentrega;
        this.obsdoentregador = obsdoentregador;
        this.local = local;
        this.estcob = estcob;
        this.codcidade = codcidade;
        this.nomecidade = nomecidade;
        this.endercob = endercob;
        this.numnota = numnota;
        this.posicao = posicao;
        this.codusur = codusur;
        this.nomevendedor = nomevendedor;
        this.dtfat = dtfat;
        this.dtentrega = dtentrega;
        this.codfornecfrete = codfornecfrete;
        this.fornecedor = fornecedor;
        this.codmotorista = codmotorista;
        this.nomemotorista = nomemotorista;
        this.codcli = codcli;
        this.nomecliente = nomecliente;
        this.obs = obs;
        this.obs1 = obs1;
        this.obsentrega1 = obsentrega1;
        this.obsentrega2 = obsentrega2;
        this.obsentrega3 = obsentrega3;
        this.codfuncconf = codfuncconf;
        this.nomeconf = nomeconf;
        this.vlatend = vlatend;
        this.numvolume = numvolume;
        this.dtinclusao = dtinclusao;
        this.dtexclusao = dtexclusao;
    }



    public Long getCodentrega() {
        return codentrega;
    }



    public void setCodentrega(Long codentrega) {
        this.codentrega = codentrega;
    }



    public String getObsdoentregador() {
        return obsdoentregador;
    }



    public void setObsdoentregador(String obsdoentregador) {
        this.obsdoentregador = obsdoentregador;
    }



    public String getLocal() {
        return local;
    }



    public void setLocal(String local) {
        this.local = local;
    }



    public String getEstcob() {
        return estcob;
    }



    public void setEstcob(String estcob) {
        this.estcob = estcob;
    }



    public BigDecimal getCodcidade() {
        return codcidade;
    }



    public void setCodcidade(BigDecimal codcidade) {
        this.codcidade = codcidade;
    }



    public String getEndercob() {
        return endercob;
    }



    public void setEndercob(String endercob) {
        this.endercob = endercob;
    }

    

    public String getNomecidade() {
        return nomecidade;
    }



    public void setNomecidade(String nomecidade) {
        this.nomecidade = nomecidade;
    }



    public BigDecimal getNumnota() {
        return numnota;
    }



    public void setNumnota(BigDecimal numnota) {
        this.numnota = numnota;
    }



    public String getPosicao() {
        return posicao;
    }



    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }



    public BigDecimal getCodusur() {
        return codusur;
    }



    public void setCodusur(BigDecimal codusur) {
        this.codusur = codusur;
    }



    public String getNomevendedor() {
        return nomevendedor;
    }



    public void setNomevendedor(String nomevendedor) {
        this.nomevendedor = nomevendedor;
    }



    public Date getDtfat() {
        return dtfat;
    }



    public void setDtfat(Date dtfat) {
        this.dtfat = dtfat;
    }



    public Date getDtentrega() {
        return dtentrega;
    }



    public void setDtentrega(Date dtentrega) {
        this.dtentrega = dtentrega;
    }



    public BigDecimal getCodfornecfrete() {
        return codfornecfrete;
    }



    public void setCodfornecfrete(BigDecimal codfornecfrete) {
        this.codfornecfrete = codfornecfrete;
    }



    public String getFornecedor() {
        return fornecedor;
    }



    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }



    public BigDecimal getCodmotorista() {
        return codmotorista;
    }



    public void setCodmotorista(BigDecimal codmotorista) {
        this.codmotorista = codmotorista;
    }



    public String getNomemotorista() {
        return nomemotorista;
    }



    public void setNomemotorista(String nomemotorista) {
        this.nomemotorista = nomemotorista;
    }



    public BigDecimal getCodcli() {
        return codcli;
    }



    public void setCodcli(BigDecimal codcli) {
        this.codcli = codcli;
    }



    public String getNomecliente() {
        return nomecliente;
    }



    public void setNomecliente(String nomecliente) {
        this.nomecliente = nomecliente;
    }



    public String getObs() {
        return obs;
    }



    public void setObs(String obs) {
        this.obs = obs;
    }



    public String getObs1() {
        return obs1;
    }



    public void setObs1(String obs1) {
        this.obs1 = obs1;
    }



    public String getObsentrega1() {
        return obsentrega1;
    }



    public void setObsentrega1(String obsentrega1) {
        this.obsentrega1 = obsentrega1;
    }



    public String getObsentrega2() {
        return obsentrega2;
    }



    public void setObsentrega2(String obsentrega2) {
        this.obsentrega2 = obsentrega2;
    }



    public String getObsentrega3() {
        return obsentrega3;
    }



    public void setObsentrega3(String obsentrega3) {
        this.obsentrega3 = obsentrega3;
    }



    public BigDecimal getCodfuncconf() {
        return codfuncconf;
    }



    public void setCodfuncconf(BigDecimal codfuncconf) {
        this.codfuncconf = codfuncconf;
    }



    public String getNomeconf() {
        return nomeconf;
    }



    public void setNomeconf(String nomeconf) {
        this.nomeconf = nomeconf;
    }



    public BigDecimal getVlatend() {
        return vlatend;
    }



    public void setVlatend(BigDecimal vlatend) {
        this.vlatend = vlatend;
    }



    public BigDecimal getNumvolume() {
        return numvolume;
    }



    public void setNumvolume(BigDecimal numvolume) {
        this.numvolume = numvolume;
    }



    public Date getDtinclusao() {
        return dtinclusao;
    }



    public void setDtinclusao(Date dtinclusao) {
        this.dtinclusao = dtinclusao;
    }



    public Date getDtexclusao() {
        return dtexclusao;
    }



    public void setDtexclusao(Date dtexclusao) {
        this.dtexclusao = dtexclusao;
    }

    
}