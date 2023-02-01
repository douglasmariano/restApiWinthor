package com.ajel.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pcclient")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codcli")
    private BigDecimal codigoCliente;

    @Column(name = "cliente")
    private String nomeCliente;

    @Column(name = "cgcent")
    private String cpfcnpj;

    @Column(name = "municcob")
    private String municcob;

    @Column(name = "estcob")
    private String estcob;

    @Column(name = "telcob")
    private String telcob;

    @Column(name = "telent")
    private String telent;

    @Column(name = "telcom")
    private String telcom;

    @Column(name = "telcelent")
    private String telcelent;

    @Column(name = "bloqueio")
    private String bloqueio;

    @Column(name = "bloqueiosefaz")
    private String bloqueiosefaz;

    @Column(name = "dtcadastro")
    private Date dtcadastro;

    @Column(name = "DTULTALTER")
    private Date dtultalt;

    public Cliente() {

    }

    public Cliente(BigDecimal codigoCliente, String nomeCliente, String cpfcnpj, String municcob, String estcob, String telcob,
            String telent, String telcom, String telcelent, String bloqueio, String bloqueiosefaz, Date dtcadastro,
            Date dtultalt) {
        super();
        this.codigoCliente = codigoCliente;
        this.nomeCliente = nomeCliente;
        this.cpfcnpj = cpfcnpj;
        this.municcob = municcob;
        this.estcob = estcob;
        this.telcob = telcob;
        this.telent = telent;
        this.telcom = telcom;
        this.telcelent = telcelent;
        this.bloqueio = bloqueio;
        this.bloqueiosefaz = bloqueiosefaz;
        this.dtcadastro = dtcadastro;
        this.dtultalt = dtultalt;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (codigoCliente != other.codigoCliente)
            return false;
        return true;
    }

    public BigDecimal getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(BigDecimal codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpfcnpj() {
        return cpfcnpj;
    }

    public void setCpfcnpj(String cpfcnpj) {
        this.cpfcnpj = cpfcnpj;
    }

    public String getMuniccob() {
        return municcob;
    }

    public void setMuniccob(String municcob) {
        this.municcob = municcob;
    }

    public String getEstcob() {
        return estcob;
    }

    public void setEstcob(String estcob) {
        this.estcob = estcob;
    }

    public String getTelcob() {
        return telcob;
    }

    public void setTelcob(String telcob) {
        this.telcob = telcob;
    }

    public String getTelent() {
        return telent;
    }

    public void setTelent(String telent) {
        this.telent = telent;
    }

    public String getTelcom() {
        return telcom;
    }

    public void setTelcom(String telcom) {
        this.telcom = telcom;
    }

    public String getTelcelent() {
        return telcelent;
    }

    public void setTelcelent(String telcelent) {
        this.telcelent = telcelent;
    }

    public String getBloqueio() {
        return bloqueio;
    }

    public void setBloqueio(String bloqueio) {
        this.bloqueio = bloqueio;
    }

    public String getBloqueiosefaz() {
        return bloqueiosefaz;
    }

    public void setBloqueiosefaz(String bloqueiosefaz) {
        this.bloqueiosefaz = bloqueiosefaz;
    }

    public Date getDtcadastro() {
        return dtcadastro;
    }

    public void setDtcadastro(Date dtcadastro) {
        this.dtcadastro = dtcadastro;
    }

    public Date getDtultalt() {
        return dtultalt;
    }

    public void setDtultalt(Date dtultalt) {
        this.dtultalt = dtultalt;
    }

}
