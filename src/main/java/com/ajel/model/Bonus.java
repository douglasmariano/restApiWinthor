package com.ajel.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pcbonusc")
public class Bonus {

    @Id
    @Column(name = "numbonus")
    private Long numbonus;

    @Column(name = "databonus")
    private Date databonus;

    @Column(name = "qtnfs")
    private Long qtnfs;

    @Column(name = "valortotal")
    private Long valortotal;

    @Column(name = "pesototal")
    private Long pesototal;

    @Column(name = "datarm")
    private Date datarm;

    @Column(name = "codfuncrm")
    private Long codfuncrm;

    @Column(name = "obs")
    private String obs;

    @Column(name = "dtfechamento")
    private Date dtfechamento;

    @Column(name = "codfuncbonus")
    private Long codfuncbonus;

    @Column(name = "codfuncfecha")
    private Long codfuncfecha;

    @Column(name = "codfilial")
    private String codfilial;

    @Column(name = "placa")
    private String placa;

    @Column(name = "tiposenha")
    private String tiposenha;

    @Column(name = "hora")
    private Long hora;

    @Column(name = "minuto")
    private Long minuto;

    @Column(name = "senha")
    private Long senha;

    @Column(name = "tipocarga")
    private String tipocarga;

    @Column(name = "peso")
    private Long peso;

    @Column(name = "codfornectransp")
    private Long codfornectransp;

    @Column(name = "obs1")
    private String obs1;

    @Column(name = "obs2")
    private String obs2;

    @Column(name = "tipodescarga")
    private String tipodescarga;

    @Column(name = "vldescarga")
    private Long vldescarga;

    @Column(name = "dtdescarga")
    private Date dtdescarga;

    @Column(name = "numviasrecibo")
    private Long numviasrecibo;

    @Column(name = "calcdescarga")
    private String calcdescarga;

    @Column(name = "vldescargap")
    private Long vldescargap;

    @Column(name = "vldescargav")
    private Long vldescargav;

    @Column(name = "totpesodescarga")
    private Long totpesodescarga;

    @Column(name = "totvolumedescarga")
    private Long totvolumedescarga;

    @Column(name = "dtcancel")
    private Date dtcancel;

    @Column(name = "codfunccancel")
    private Long codfunccancel;

    @Column(name = "motivocancel")
    private String motivocancel;

    @Column(name = "obs3")
    private String obs3;

    @Column(name = "obs4")
    private String obs4;

    @Column(name = "obs5")
    private String obs5;

    @Column(name = "vlinformado")
    private Long vlinformado;

    @Column(name = "box")
    private Long box;

    @Column(name = "nomemotorista")
    private String nomemotorista;

    @Column(name = "qtbloqueadaliberada")
    private String qtbloqueadaliberada;

    @Column(name = "emitido")
    private String emitido;

    @Column(name = "minutomontagem")
    private Long minutomontagem;

    @Column(name = "horamontagem")
    private Long horamontagem;

    @Column(name = "pesobalanca1")
    private Long pesobalanca1;

    @Column(name = "pesobalanca2")
    private Long pesobalanca2;

    @Column(name = "vladicional")
    private Long vladicional;

    @Column(name = "codbancorecdescarga")
    private Long codbancorecdescarga;

    @Column(name = "vldesconto")
    private Long vldesconto;

    @Column(name = "numviasbonus")
    private Long numviasbonus;

    @Column(name = "codbancorecremonte")
    private Long codbancorecremonte;

    @Column(name = "numviasreciboremonte")
    private Long numviasreciboremonte;

    @Column(name = "qtpaletesremonte")
    private Long qtpaletesremonte;

    @Column(name = "vlremonte")
    private Long vlremonte;

    @Column(name = "datafechacompleta")
    private Date datafechacompleta;

    @Column(name = "dtmontagem")
    private Date dtmontagem;

    @Column(name = "dtfechamentototal")
    private Date dtfechamentototal;

    @Column(name = "numtransentlote")
    private Long numtransentlote;

    @Column(name = "numtransvendalote")
    private Long numtransvendalote;

    @Column(name = "tipodocmotorista")
    private String tipodocmotorista;

    @Column(name = "numdocmotorista")
    private String numdocmotorista;

    @Column(name = "dtchegadamotorista")
    private Date dtchegadamotorista;

    @Column(name = "utilizoupreent")
    private String utilizoupreent;

    @Column(name = "enderecamentoporpalete")
    private String enderecamentoporpalete;

    @Column(name = "dataconf")
    private Date dataconf;

    @Column(name = "usarf")
    private String usarf;

    @Column(name = "estbonific")
    private String estbonific;

    @Column(name = "liberaestentmerc")
    private String liberaestentmerc;

    @Column(name = "liberaestfechbonus")
    private String liberaestfechbonus;

    public Bonus() {
        
    };
    
    public Bonus(Long numbonus, Date databonus, Long qtnfs, Long valortotal, Long pesototal, Date datarm, Long codfuncrm,
            String obs, Date dtfechamento, Long codfuncbonus, Long codfuncfecha, String codfilial, String placa,
            String tiposenha, Long hora, Long minuto, Long senha, String tipocarga, Long peso, Long codfornectransp,
            String obs1, String obs2, String tipodescarga, Long vldescarga, Date dtdescarga, Long numviasrecibo,
            String calcdescarga, Long vldescargap, Long vldescargav, Long totpesodescarga, Long totvolumedescarga,
            Date dtcancel, Long codfunccancel, String motivocancel, String obs3, String obs4, String obs5, Long vlinformado,
            Long box, String nomemotorista, String qtbloqueadaliberada, String emitido, Long minutomontagem, Long horamontagem,
            Long pesobalanca1, Long pesobalanca2, Long vladicional, Long codbancorecdescarga, Long vldesconto,
            Long numviasbonus, Long codbancorecremonte, Long numviasreciboremonte, Long qtpaletesremonte, Long vlremonte,
            Date datafechacompleta, Date dtmontagem, Date dtfechamentototal, Long numtransentlote, Long numtransvendalote,
            String tipodocmotorista, String numdocmotorista, Date dtchegadamotorista, String utilizoupreent,
            String enderecamentoporpalete, Date dataconf, String usarf, String estbonific, String liberaestentmerc,
            String liberaestfechbonus) {
        super();
        this.numbonus = numbonus;
        this.databonus = databonus;
        this.qtnfs = qtnfs;
        this.valortotal = valortotal;
        this.pesototal = pesototal;
        this.datarm = datarm;
        this.codfuncrm = codfuncrm;
        this.obs = obs;
        this.dtfechamento = dtfechamento;
        this.codfuncbonus = codfuncbonus;
        this.codfuncfecha = codfuncfecha;
        this.codfilial = codfilial;
        this.placa = placa;
        this.tiposenha = tiposenha;
        this.hora = hora;
        this.minuto = minuto;
        this.senha = senha;
        this.tipocarga = tipocarga;
        this.peso = peso;
        this.codfornectransp = codfornectransp;
        this.obs1 = obs1;
        this.obs2 = obs2;
        this.tipodescarga = tipodescarga;
        this.vldescarga = vldescarga;
        this.dtdescarga = dtdescarga;
        this.numviasrecibo = numviasrecibo;
        this.calcdescarga = calcdescarga;
        this.vldescargap = vldescargap;
        this.vldescargav = vldescargav;
        this.totpesodescarga = totpesodescarga;
        this.totvolumedescarga = totvolumedescarga;
        this.dtcancel = dtcancel;
        this.codfunccancel = codfunccancel;
        this.motivocancel = motivocancel;
        this.obs3 = obs3;
        this.obs4 = obs4;
        this.obs5 = obs5;
        this.vlinformado = vlinformado;
        this.box = box;
        this.nomemotorista = nomemotorista;
        this.qtbloqueadaliberada = qtbloqueadaliberada;
        this.emitido = emitido;
        this.minutomontagem = minutomontagem;
        this.horamontagem = horamontagem;
        this.pesobalanca1 = pesobalanca1;
        this.pesobalanca2 = pesobalanca2;
        this.vladicional = vladicional;
        this.codbancorecdescarga = codbancorecdescarga;
        this.vldesconto = vldesconto;
        this.numviasbonus = numviasbonus;
        this.codbancorecremonte = codbancorecremonte;
        this.numviasreciboremonte = numviasreciboremonte;
        this.qtpaletesremonte = qtpaletesremonte;
        this.vlremonte = vlremonte;
        this.datafechacompleta = datafechacompleta;
        this.dtmontagem = dtmontagem;
        this.dtfechamentototal = dtfechamentototal;
        this.numtransentlote = numtransentlote;
        this.numtransvendalote = numtransvendalote;
        this.tipodocmotorista = tipodocmotorista;
        this.numdocmotorista = numdocmotorista;
        this.dtchegadamotorista = dtchegadamotorista;
        this.utilizoupreent = utilizoupreent;
        this.enderecamentoporpalete = enderecamentoporpalete;
        this.dataconf = dataconf;
        this.usarf = usarf;
        this.estbonific = estbonific;
        this.liberaestentmerc = liberaestentmerc;
        this.liberaestfechbonus = liberaestfechbonus;
    }

    public Long getNumbonus() {
        return numbonus;
    }

    public void setNumbonus(Long numbonus) {
        this.numbonus = numbonus;
    }

    public Date getDatabonus() {
        return databonus;
    }

    public void setDatabonus(Date databonus) {
        this.databonus = databonus;
    }

    public Long getQtnfs() {
        return qtnfs;
    }

    public void setQtnfs(Long qtnfs) {
        this.qtnfs = qtnfs;
    }

    public Long getValortotal() {
        return valortotal;
    }

    public void setValortotal(Long valortotal) {
        this.valortotal = valortotal;
    }

    public Long getPesototal() {
        return pesototal;
    }

    public void setPesototal(Long pesototal) {
        this.pesototal = pesototal;
    }

    public Date getDatarm() {
        return datarm;
    }

    public void setDatarm(Date datarm) {
        this.datarm = datarm;
    }

    public Long getCodfuncrm() {
        return codfuncrm;
    }

    public void setCodfuncrm(Long codfuncrm) {
        this.codfuncrm = codfuncrm;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Date getDtfechamento() {
        return dtfechamento;
    }

    public void setDtfechamento(Date dtfechamento) {
        this.dtfechamento = dtfechamento;
    }

    public Long getCodfuncbonus() {
        return codfuncbonus;
    }

    public void setCodfuncbonus(Long codfuncbonus) {
        this.codfuncbonus = codfuncbonus;
    }

    public Long getCodfuncfecha() {
        return codfuncfecha;
    }

    public void setCodfuncfecha(Long codfuncfecha) {
        this.codfuncfecha = codfuncfecha;
    }

    public String getCodfilial() {
        return codfilial;
    }

    public void setCodfilial(String codfilial) {
        this.codfilial = codfilial;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTiposenha() {
        return tiposenha;
    }

    public void setTiposenha(String tiposenha) {
        this.tiposenha = tiposenha;
    }

    public Long getHora() {
        return hora;
    }

    public void setHora(Long hora) {
        this.hora = hora;
    }

    public Long getMinuto() {
        return minuto;
    }

    public void setMinuto(Long minuto) {
        this.minuto = minuto;
    }

    public Long getSenha() {
        return senha;
    }

    public void setSenha(Long senha) {
        this.senha = senha;
    }

    public String getTipocarga() {
        return tipocarga;
    }

    public void setTipocarga(String tipocarga) {
        this.tipocarga = tipocarga;
    }

    public Long getPeso() {
        return peso;
    }

    public void setPeso(Long peso) {
        this.peso = peso;
    }

    public Long getCodfornectransp() {
        return codfornectransp;
    }

    public void setCodfornectransp(Long codfornectransp) {
        this.codfornectransp = codfornectransp;
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

    public String getTipodescarga() {
        return tipodescarga;
    }

    public void setTipodescarga(String tipodescarga) {
        this.tipodescarga = tipodescarga;
    }

    public Long getVldescarga() {
        return vldescarga;
    }

    public void setVldescarga(Long vldescarga) {
        this.vldescarga = vldescarga;
    }

    public Date getDtdescarga() {
        return dtdescarga;
    }

    public void setDtdescarga(Date dtdescarga) {
        this.dtdescarga = dtdescarga;
    }

    public Long getNumviasrecibo() {
        return numviasrecibo;
    }

    public void setNumviasrecibo(Long numviasrecibo) {
        this.numviasrecibo = numviasrecibo;
    }

    public String getCalcdescarga() {
        return calcdescarga;
    }

    public void setCalcdescarga(String calcdescarga) {
        this.calcdescarga = calcdescarga;
    }

    public Long getVldescargap() {
        return vldescargap;
    }

    public void setVldescargap(Long vldescargap) {
        this.vldescargap = vldescargap;
    }

    public Long getVldescargav() {
        return vldescargav;
    }

    public void setVldescargav(Long vldescargav) {
        this.vldescargav = vldescargav;
    }

    public Long getTotpesodescarga() {
        return totpesodescarga;
    }

    public void setTotpesodescarga(Long totpesodescarga) {
        this.totpesodescarga = totpesodescarga;
    }

    public Long getTotvolumedescarga() {
        return totvolumedescarga;
    }

    public void setTotvolumedescarga(Long totvolumedescarga) {
        this.totvolumedescarga = totvolumedescarga;
    }

    public Date getDtcancel() {
        return dtcancel;
    }

    public void setDtcancel(Date dtcancel) {
        this.dtcancel = dtcancel;
    }

    public Long getCodfunccancel() {
        return codfunccancel;
    }

    public void setCodfunccancel(Long codfunccancel) {
        this.codfunccancel = codfunccancel;
    }

    public String getMotivocancel() {
        return motivocancel;
    }

    public void setMotivocancel(String motivocancel) {
        this.motivocancel = motivocancel;
    }

    public String getObs3() {
        return obs3;
    }

    public void setObs3(String obs3) {
        this.obs3 = obs3;
    }

    public String getObs4() {
        return obs4;
    }

    public void setObs4(String obs4) {
        this.obs4 = obs4;
    }

    public String getObs5() {
        return obs5;
    }

    public void setObs5(String obs5) {
        this.obs5 = obs5;
    }

    public Long getVlinformado() {
        return vlinformado;
    }

    public void setVlinformado(Long vlinformado) {
        this.vlinformado = vlinformado;
    }

    public Long getBox() {
        return box;
    }

    public void setBox(Long box) {
        this.box = box;
    }

    public String getNomemotorista() {
        return nomemotorista;
    }

    public void setNomemotorista(String nomemotorista) {
        this.nomemotorista = nomemotorista;
    }

    public String getQtbloqueadaliberada() {
        return qtbloqueadaliberada;
    }

    public void setQtbloqueadaliberada(String qtbloqueadaliberada) {
        this.qtbloqueadaliberada = qtbloqueadaliberada;
    }

    public String getEmitido() {
        return emitido;
    }

    public void setEmitido(String emitido) {
        this.emitido = emitido;
    }

    public Long getMinutomontagem() {
        return minutomontagem;
    }

    public void setMinutomontagem(Long minutomontagem) {
        this.minutomontagem = minutomontagem;
    }

    public Long getHoramontagem() {
        return horamontagem;
    }

    public void setHoramontagem(Long horamontagem) {
        this.horamontagem = horamontagem;
    }

    public Long getPesobalanca1() {
        return pesobalanca1;
    }

    public void setPesobalanca1(Long pesobalanca1) {
        this.pesobalanca1 = pesobalanca1;
    }

    public Long getPesobalanca2() {
        return pesobalanca2;
    }

    public void setPesobalanca2(Long pesobalanca2) {
        this.pesobalanca2 = pesobalanca2;
    }

    public Long getVladicional() {
        return vladicional;
    }

    public void setVladicional(Long vladicional) {
        this.vladicional = vladicional;
    }

    public Long getCodbancorecdescarga() {
        return codbancorecdescarga;
    }

    public void setCodbancorecdescarga(Long codbancorecdescarga) {
        this.codbancorecdescarga = codbancorecdescarga;
    }

    public Long getVldesconto() {
        return vldesconto;
    }

    public void setVldesconto(Long vldesconto) {
        this.vldesconto = vldesconto;
    }

    public Long getNumviasbonus() {
        return numviasbonus;
    }

    public void setNumviasbonus(Long numviasbonus) {
        this.numviasbonus = numviasbonus;
    }

    public Long getCodbancorecremonte() {
        return codbancorecremonte;
    }

    public void setCodbancorecremonte(Long codbancorecremonte) {
        this.codbancorecremonte = codbancorecremonte;
    }

    public Long getNumviasreciboremonte() {
        return numviasreciboremonte;
    }

    public void setNumviasreciboremonte(Long numviasreciboremonte) {
        this.numviasreciboremonte = numviasreciboremonte;
    }

    public Long getQtpaletesremonte() {
        return qtpaletesremonte;
    }

    public void setQtpaletesremonte(Long qtpaletesremonte) {
        this.qtpaletesremonte = qtpaletesremonte;
    }

    public Long getVlremonte() {
        return vlremonte;
    }

    public void setVlremonte(Long vlremonte) {
        this.vlremonte = vlremonte;
    }

    public Date getDatafechacompleta() {
        return datafechacompleta;
    }

    public void setDatafechacompleta(Date datafechacompleta) {
        this.datafechacompleta = datafechacompleta;
    }

    public Date getDtmontagem() {
        return dtmontagem;
    }

    public void setDtmontagem(Date dtmontagem) {
        this.dtmontagem = dtmontagem;
    }

    public Date getDtfechamentototal() {
        return dtfechamentototal;
    }

    public void setDtfechamentototal(Date dtfechamentototal) {
        this.dtfechamentototal = dtfechamentototal;
    }

    public Long getNumtransentlote() {
        return numtransentlote;
    }

    public void setNumtransentlote(Long numtransentlote) {
        this.numtransentlote = numtransentlote;
    }

    public Long getNumtransvendalote() {
        return numtransvendalote;
    }

    public void setNumtransvendalote(Long numtransvendalote) {
        this.numtransvendalote = numtransvendalote;
    }

    public String getTipodocmotorista() {
        return tipodocmotorista;
    }

    public void setTipodocmotorista(String tipodocmotorista) {
        this.tipodocmotorista = tipodocmotorista;
    }

    public String getNumdocmotorista() {
        return numdocmotorista;
    }

    public void setNumdocmotorista(String numdocmotorista) {
        this.numdocmotorista = numdocmotorista;
    }

    public Date getDtchegadamotorista() {
        return dtchegadamotorista;
    }

    public void setDtchegadamotorista(Date dtchegadamotorista) {
        this.dtchegadamotorista = dtchegadamotorista;
    }

    public String getUtilizoupreent() {
        return utilizoupreent;
    }

    public void setUtilizoupreent(String utilizoupreent) {
        this.utilizoupreent = utilizoupreent;
    }

    public String getEnderecamentoporpalete() {
        return enderecamentoporpalete;
    }

    public void setEnderecamentoporpalete(String enderecamentoporpalete) {
        this.enderecamentoporpalete = enderecamentoporpalete;
    }

    public Date getDataconf() {
        return dataconf;
    }

    public void setDataconf(Date dataconf) {
        this.dataconf = dataconf;
    }

    public String getUsarf() {
        return usarf;
    }

    public void setUsarf(String usarf) {
        this.usarf = usarf;
    }

    public String getEstbonific() {
        return estbonific;
    }

    public void setEstbonific(String estbonific) {
        this.estbonific = estbonific;
    }

    public String getLiberaestentmerc() {
        return liberaestentmerc;
    }

    public void setLiberaestentmerc(String liberaestentmerc) {
        this.liberaestentmerc = liberaestentmerc;
    }

    public String getLiberaestfechbonus() {
        return liberaestfechbonus;
    }

    public void setLiberaestfechbonus(String liberaestfechbonus) {
        this.liberaestfechbonus = liberaestfechbonus;
    }

    
}
