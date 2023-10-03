package com.ajel.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pcbonusi")
public class BonusItens {

    @EmbeddedId
    private BonusItensPk id;
      
    @Column(name = "qtnf")
    private Long qtnf;

    @Column(name = "qtentrada")
    private Long qtentrada;

    @Column(name = "enderecado")
    private String enderecado;

    @Column(name = "dtvalidade")
    private Date dtvalidade;

    @Column(name = "codfornec")
    private Long codfornec;

    @Column(name = "codepto")
    private Long codepto;

    @Column(name = "qtsaida")
    private Long qtsaida;

    @Column(name = "qtestger")
    private Long qtestger;

    @Column(name = "dtultsaida")
    private Date dtultsaida;

    @Column(name = "qtavaria")
    private Long qtavaria;

    @Column(name = "numbono")
    private Long numbono;

    @Column(name = "percinteiro")
    private Long percinteiro;

    @Column(name = "percquebrado")
    private Long percquebrado;

    @Column(name = "percimpureza")
    private Long percimpureza;

    @Column(name = "percvermelho")
    private Long percvermelho;

    @Column(name = "percumidade")
    private Long percumidade;

    @Column(name = "codmotivo")
    private Long codmotivo;

    @Column(name = "qtfalta")
    private Long qtfalta;

    @Column(name = "qtexcesso")
    private Long qtexcesso;

    @Column(name = "divergencia")
    private String divergencia;

    @Column(name = "obsdivergencia")
    private String obsdivergencia;

    @Column(name = "tipodivergencia")
    private Long tipodivergencia;

    @Column(name = "codfuncsolucaodivergencia")
    private Long codfuncsolucaodivergencia;

    @Column(name = "dtsolucaodivergencia")
    private Date dtsolucaodivergencia;

    @Column(name = "conferida")
    private String conferida;

    @Column(name = "qtavarianf")
    private Long qtavarianf;

    @Column(name = "toleranciashelflife")
    private Long toleranciashelflife;

    @Column(name = "qtbloqueadaliberada")
    private String qtbloqueadaliberada;

    @Column(name = "datafabricacao")
    private Date datafabricacao;

    @Column(name = "numseq")
    private Long numseq;

    @Column(name = "qtdepecapesagem")
    private Long qtdepecapesagem;

    @Column(name = "valortaraporpeca")
    private Long valortaraporpeca;

    @Column(name = "numlotenf")
    private String numlotenf;

    @Column(name = "qtentradacx")
    private Long qtentradacx;

    @Column(name = "qtavariacx")
    private Long qtavariacx;

    @Column(name = "qtentcx")
    private Long qtentcx;

    @Column(name = "qtentun")
    private Long qtentun;

    @Column(name = "qtavariaun")
    private Long qtavariaun;

    @Column(name = "eanconf")
    private Long eanconf;

    @Column(name = "dunconf")
    private Long dunconf;

    @Column(name = "lastroconf")
    private Long lastroconf;

    @Column(name = "camadaconf")
    private Long camadaconf;

    @Column(name = "qttotpalconf")
    private Long qttotpalconf;

    @Column(name = "dadoslogisticos")
    private String dadoslogisticos;

    @Column(name = "numviasetiqueta")
    private Long numviasetiqueta;

    @Column(name = "codagregacao")
    private String codagregacao;

    @Column(name = "numlotefab")
    private String numlotefab;

    @Column(name = "numlotefornec")
    private String numlotefornec;

    @Column(name = "coddeposito")
    private Long coddeposito;

    @Column(name = "qtavariadigita")
    private Long qtavariadigita;

    @Column(name = "itemdesdobrado")
    private String itemdesdobrado;

    @Column(name = "tipoembalagempedido")
    private String tipoembalagempedido;

    @Column(name = "transacaonotadesdobralote")
    private Long transacaonotadesdobralote;

    @Column(name = "id_pcbonusinf")
    private String id_pcbonusinf;

    public BonusItens() {

    };

    public BonusItens(BonusItensPk id, Long qtnf, Long qtentrada, String enderecado,
            Date dtvalidade,
            Long codfornec, Long codepto, Long qtsaida, Long qtestger, Date dtultsaida, Long qtavaria, Long numbono,
            Long percinteiro, Long percquebrado, Long percimpureza, Long percvermelho, Long percumidade, Long codmotivo,
            Long qtfalta, Long qtexcesso, String divergencia, String obsdivergencia, Long tipodivergencia,
            Long codfuncsolucaodivergencia, Date dtsolucaodivergencia, String conferida, Long qtavarianf,
            Long toleranciashelflife,
            String qtbloqueadaliberada, Date datafabricacao, Long numseq, Long qtdepecapesagem, Long valortaraporpeca,
            String numlotenf, Long qtentradacx, Long qtavariacx, Long qtentcx, Long qtentun, Long qtavariaun, Long eanconf,
            Long dunconf, Long lastroconf, Long camadaconf, Long qttotpalconf, String dadoslogisticos, Long numviasetiqueta,
            String codagregacao, String numlotefab, String numlotefornec, Long coddeposito, Long qtavariadigita,
            String itemdesdobrado, String tipoembalagempedido, Long transacaonotadesdobralote, String id_pcbonusinf) {
        super();
        this.id = id;  
        this.qtnf = qtnf;
        this.qtentrada = qtentrada;
        this.enderecado = enderecado;
        this.dtvalidade = dtvalidade;
        this.codfornec = codfornec;
        this.codepto = codepto;
        this.qtsaida = qtsaida;
        this.qtestger = qtestger;
        this.dtultsaida = dtultsaida;
        this.qtavaria = qtavaria;
        this.numbono = numbono;
        this.percinteiro = percinteiro;
        this.percquebrado = percquebrado;
        this.percimpureza = percimpureza;
        this.percvermelho = percvermelho;
        this.percumidade = percumidade;
        this.codmotivo = codmotivo;
        this.qtfalta = qtfalta;
        this.qtexcesso = qtexcesso;
        this.divergencia = divergencia;
        this.obsdivergencia = obsdivergencia;
        this.tipodivergencia = tipodivergencia;
        this.codfuncsolucaodivergencia = codfuncsolucaodivergencia;
        this.dtsolucaodivergencia = dtsolucaodivergencia;
        this.conferida = conferida;
        this.qtavarianf = qtavarianf;
        this.toleranciashelflife = toleranciashelflife;
        this.qtbloqueadaliberada = qtbloqueadaliberada;
        this.datafabricacao = datafabricacao;
        this.numseq = numseq;
        this.qtdepecapesagem = qtdepecapesagem;
        this.valortaraporpeca = valortaraporpeca;
        this.numlotenf = numlotenf;
        this.qtentradacx = qtentradacx;
        this.qtavariacx = qtavariacx;
        this.qtentcx = qtentcx;
        this.qtentun = qtentun;
        this.qtavariaun = qtavariaun;
        this.eanconf = eanconf;
        this.dunconf = dunconf;
        this.lastroconf = lastroconf;
        this.camadaconf = camadaconf;
        this.qttotpalconf = qttotpalconf;
        this.dadoslogisticos = dadoslogisticos;
        this.numviasetiqueta = numviasetiqueta;
        this.codagregacao = codagregacao;
        this.numlotefab = numlotefab;
        this.numlotefornec = numlotefornec;
        this.coddeposito = coddeposito;
        this.qtavariadigita = qtavariadigita;
        this.itemdesdobrado = itemdesdobrado;
        this.tipoembalagempedido = tipoembalagempedido;
        this.transacaonotadesdobralote = transacaonotadesdobralote;
        this.id_pcbonusinf = id_pcbonusinf;
    }

    

   
    public BonusItensPk getId() {
        return id;
    }

    public void setId(BonusItensPk id) {
        this.id = id;
    }

    public Long getQtnf() {
        return qtnf;
    }

    public void setQtnf(Long qtnf) {
        this.qtnf = qtnf;
    }

    public Long getQtentrada() {
        return qtentrada;
    }

    public void setQtentrada(Long qtentrada) {
        this.qtentrada = qtentrada;
    }

    public String getEnderecado() {
        return enderecado;
    }

    public void setEnderecado(String enderecado) {
        this.enderecado = enderecado;
    }

    public Date getDtvalidade() {
        return dtvalidade;
    }

    public void setDtvalidade(Date dtvalidade) {
        this.dtvalidade = dtvalidade;
    }

    public Long getCodfornec() {
        return codfornec;
    }

    public void setCodfornec(Long codfornec) {
        this.codfornec = codfornec;
    }

    public Long getCodepto() {
        return codepto;
    }

    public void setCodepto(Long codepto) {
        this.codepto = codepto;
    }

    public Long getQtsaida() {
        return qtsaida;
    }

    public void setQtsaida(Long qtsaida) {
        this.qtsaida = qtsaida;
    }

    public Long getQtestger() {
        return qtestger;
    }

    public void setQtestger(Long qtestger) {
        this.qtestger = qtestger;
    }

    public Date getDtultsaida() {
        return dtultsaida;
    }

    public void setDtultsaida(Date dtultsaida) {
        this.dtultsaida = dtultsaida;
    }

    public Long getQtavaria() {
        return qtavaria;
    }

    public void setQtavaria(Long qtavaria) {
        this.qtavaria = qtavaria;
    }

    public Long getNumbono() {
        return numbono;
    }

    public void setNumbono(Long numbono) {
        this.numbono = numbono;
    }

    public Long getPercinteiro() {
        return percinteiro;
    }

    public void setPercinteiro(Long percinteiro) {
        this.percinteiro = percinteiro;
    }

    public Long getPercquebrado() {
        return percquebrado;
    }

    public void setPercquebrado(Long percquebrado) {
        this.percquebrado = percquebrado;
    }

    public Long getPercimpureza() {
        return percimpureza;
    }

    public void setPercimpureza(Long percimpureza) {
        this.percimpureza = percimpureza;
    }

    public Long getPercvermelho() {
        return percvermelho;
    }

    public void setPercvermelho(Long percvermelho) {
        this.percvermelho = percvermelho;
    }

    public Long getPercumidade() {
        return percumidade;
    }

    public void setPercumidade(Long percumidade) {
        this.percumidade = percumidade;
    }

    public Long getCodmotivo() {
        return codmotivo;
    }

    public void setCodmotivo(Long codmotivo) {
        this.codmotivo = codmotivo;
    }

    public Long getQtfalta() {
        return qtfalta;
    }

    public void setQtfalta(Long qtfalta) {
        this.qtfalta = qtfalta;
    }

    public Long getQtexcesso() {
        return qtexcesso;
    }

    public void setQtexcesso(Long qtexcesso) {
        this.qtexcesso = qtexcesso;
    }

    public String getDivergencia() {
        return divergencia;
    }

    public void setDivergencia(String divergencia) {
        this.divergencia = divergencia;
    }

    public String getObsdivergencia() {
        return obsdivergencia;
    }

    public void setObsdivergencia(String obsdivergencia) {
        this.obsdivergencia = obsdivergencia;
    }

    public Long getTipodivergencia() {
        return tipodivergencia;
    }

    public void setTipodivergencia(Long tipodivergencia) {
        this.tipodivergencia = tipodivergencia;
    }

    public Long getCodfuncsolucaodivergencia() {
        return codfuncsolucaodivergencia;
    }

    public void setCodfuncsolucaodivergencia(Long codfuncsolucaodivergencia) {
        this.codfuncsolucaodivergencia = codfuncsolucaodivergencia;
    }

    public Date getDtsolucaodivergencia() {
        return dtsolucaodivergencia;
    }

    public void setDtsolucaodivergencia(Date dtsolucaodivergencia) {
        this.dtsolucaodivergencia = dtsolucaodivergencia;
    }

    public String getConferida() {
        return conferida;
    }

    public void setConferida(String conferida) {
        this.conferida = conferida;
    }

    public Long getQtavarianf() {
        return qtavarianf;
    }

    public void setQtavarianf(Long qtavarianf) {
        this.qtavarianf = qtavarianf;
    }

    public Long getToleranciashelflife() {
        return toleranciashelflife;
    }

    public void setToleranciashelflife(Long toleranciashelflife) {
        this.toleranciashelflife = toleranciashelflife;
    }

    public String getQtbloqueadaliberada() {
        return qtbloqueadaliberada;
    }

    public void setQtbloqueadaliberada(String qtbloqueadaliberada) {
        this.qtbloqueadaliberada = qtbloqueadaliberada;
    }

    public Date getDatafabricacao() {
        return datafabricacao;
    }

    public void setDatafabricacao(Date datafabricacao) {
        this.datafabricacao = datafabricacao;
    }

    public Long getNumseq() {
        return numseq;
    }

    public void setNumseq(Long numseq) {
        this.numseq = numseq;
    }

    public Long getQtdepecapesagem() {
        return qtdepecapesagem;
    }

    public void setQtdepecapesagem(Long qtdepecapesagem) {
        this.qtdepecapesagem = qtdepecapesagem;
    }

    public Long getValortaraporpeca() {
        return valortaraporpeca;
    }

    public void setValortaraporpeca(Long valortaraporpeca) {
        this.valortaraporpeca = valortaraporpeca;
    }

    public String getNumlotenf() {
        return numlotenf;
    }

    public void setNumlotenf(String numlotenf) {
        this.numlotenf = numlotenf;
    }

    public Long getQtentradacx() {
        return qtentradacx;
    }

    public void setQtentradacx(Long qtentradacx) {
        this.qtentradacx = qtentradacx;
    }

    public Long getQtavariacx() {
        return qtavariacx;
    }

    public void setQtavariacx(Long qtavariacx) {
        this.qtavariacx = qtavariacx;
    }

    public Long getQtentcx() {
        return qtentcx;
    }

    public void setQtentcx(Long qtentcx) {
        this.qtentcx = qtentcx;
    }

    public Long getQtentun() {
        return qtentun;
    }

    public void setQtentun(Long qtentun) {
        this.qtentun = qtentun;
    }

    public Long getQtavariaun() {
        return qtavariaun;
    }

    public void setQtavariaun(Long qtavariaun) {
        this.qtavariaun = qtavariaun;
    }

    public Long getEanconf() {
        return eanconf;
    }

    public void setEanconf(Long eanconf) {
        this.eanconf = eanconf;
    }

    public Long getDunconf() {
        return dunconf;
    }

    public void setDunconf(Long dunconf) {
        this.dunconf = dunconf;
    }

    public Long getLastroconf() {
        return lastroconf;
    }

    public void setLastroconf(Long lastroconf) {
        this.lastroconf = lastroconf;
    }

    public Long getCamadaconf() {
        return camadaconf;
    }

    public void setCamadaconf(Long camadaconf) {
        this.camadaconf = camadaconf;
    }

    public Long getQttotpalconf() {
        return qttotpalconf;
    }

    public void setQttotpalconf(Long qttotpalconf) {
        this.qttotpalconf = qttotpalconf;
    }

    public String getDadoslogisticos() {
        return dadoslogisticos;
    }

    public void setDadoslogisticos(String dadoslogisticos) {
        this.dadoslogisticos = dadoslogisticos;
    }

    public Long getNumviasetiqueta() {
        return numviasetiqueta;
    }

    public void setNumviasetiqueta(Long numviasetiqueta) {
        this.numviasetiqueta = numviasetiqueta;
    }

    public String getCodagregacao() {
        return codagregacao;
    }

    public void setCodagregacao(String codagregacao) {
        this.codagregacao = codagregacao;
    }

    public String getNumlotefab() {
        return numlotefab;
    }

    public void setNumlotefab(String numlotefab) {
        this.numlotefab = numlotefab;
    }

    public String getNumlotefornec() {
        return numlotefornec;
    }

    public void setNumlotefornec(String numlotefornec) {
        this.numlotefornec = numlotefornec;
    }

    public Long getCoddeposito() {
        return coddeposito;
    }

    public void setCoddeposito(Long coddeposito) {
        this.coddeposito = coddeposito;
    }

    public Long getQtavariadigita() {
        return qtavariadigita;
    }

    public void setQtavariadigita(Long qtavariadigita) {
        this.qtavariadigita = qtavariadigita;
    }

    public String getItemdesdobrado() {
        return itemdesdobrado;
    }

    public void setItemdesdobrado(String itemdesdobrado) {
        this.itemdesdobrado = itemdesdobrado;
    }

    public String getTipoembalagempedido() {
        return tipoembalagempedido;
    }

    public void setTipoembalagempedido(String tipoembalagempedido) {
        this.tipoembalagempedido = tipoembalagempedido;
    }

    public Long getTransacaonotadesdobralote() {
        return transacaonotadesdobralote;
    }

    public void setTransacaonotadesdobralote(Long transacaonotadesdobralote) {
        this.transacaonotadesdobralote = transacaonotadesdobralote;
    }

    public String getId_pcbonusinf() {
        return id_pcbonusinf;
    }

    public void setId_pcbonusinf(String id_pcbonusinf) {
        this.id_pcbonusinf = id_pcbonusinf;
    }

}
