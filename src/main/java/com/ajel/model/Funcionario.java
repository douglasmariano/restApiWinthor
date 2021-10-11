package com.ajel.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pcempr")
public class Funcionario {

    @Id
    @Column(name = "matricula")
    private Long matricula;

    @Column(name = "nome")
    private String nome;

    @Column(name = "dt_exclusao")
    private Date dtexclusao;

    @Column(name = "situacao")
    private String situacao;

    @Column(name = "tipovenda")
    private String tipovenda;

    @Column(name = "codusur")
    private Long codusur;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "codperfil")
    private Long codperfil;

    @Column(name = "codsetor")
    private Long codsetor;

    @Column(name = "tipocargo")
    private String tipocargo;

    @Column(name = "areaatuacao_compra")
    private String areaatuacao_compra;

    @Column(name = "areaatuacao_vendas")
    private String areaatuacao_vendas;

    @Column(name = "areaatuacao_financeiro")
    private String areaatuacao_financeiro;

    @Column(name = "areaatuacao_logistica")
    private String areaatuacao_logistica;

    @Column(name = "areaatuacao_expedicao")
    private String areaatuacao_expedicao;

    @Column(name = "areaatuacao_rh")
    private String areaatuacao_rh;

    @Column(name = "areaatuacao_fiscal")
    private String areaatuacao_fiscal;

    @Column(name = "areaatuacao_contabil")
    private String areaatuacao_contabil;

    @Column(name = "areaatuacao_outros")
    private String areaatuacao_outros;

    public Funcionario() {

    }

    public Funcionario(Long matricula, String nome, Date dtexclusao, String situacao, String tipovenda, Long codusur,
            String tipo, Long codperfil, Long codsetor, String tipocargo, String areaatuacao_compra, String areaatuacao_vendas,
            String areaatuacao_financeiro, String areaatuacao_logistica, String areaatuacao_expedicao, String areaatuacao_rh,
            String areaatuacao_fiscal, String areaatuacao_contabil, String areaatuacao_outros) {
        super();
        this.matricula = matricula;
        this.nome = nome;
        this.dtexclusao = dtexclusao;
        this.situacao = situacao;
        this.tipovenda = tipovenda;
        this.codusur = codusur;
        this.tipo = tipo;
        this.codperfil = codperfil;
        this.codsetor = codsetor;
        this.tipocargo = tipocargo;
        this.areaatuacao_compra = areaatuacao_compra;
        this.areaatuacao_vendas = areaatuacao_vendas;
        this.areaatuacao_financeiro = areaatuacao_financeiro;
        this.areaatuacao_logistica = areaatuacao_logistica;
        this.areaatuacao_expedicao = areaatuacao_expedicao;
        this.areaatuacao_rh = areaatuacao_rh;
        this.areaatuacao_fiscal = areaatuacao_fiscal;
        this.areaatuacao_contabil = areaatuacao_contabil;
        this.areaatuacao_outros = areaatuacao_outros;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDtexclusao() {
        return dtexclusao;
    }

    public void setDtexclusao(Date dtexclusao) {
        this.dtexclusao = dtexclusao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getTipovenda() {
        return tipovenda;
    }

    public void setTipovenda(String tipovenda) {
        this.tipovenda = tipovenda;
    }

    public Long getCodusur() {
        return codusur;
    }

    public void setCodusur(Long codusur) {
        this.codusur = codusur;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getCodperfil() {
        return codperfil;
    }

    public void setCodperfil(Long codperfil) {
        this.codperfil = codperfil;
    }

    public Long getCodsetor() {
        return codsetor;
    }

    public void setCodsetor(Long codsetor) {
        this.codsetor = codsetor;
    }

    public String getTipocargo() {
        return tipocargo;
    }

    public void setTipocargo(String tipocargo) {
        this.tipocargo = tipocargo;
    }

    public String getAreaatuacao_compra() {
        return areaatuacao_compra;
    }

    public void setAreaatuacao_compra(String areaatuacao_compra) {
        this.areaatuacao_compra = areaatuacao_compra;
    }

    public String getAreaatuacao_vendas() {
        return areaatuacao_vendas;
    }

    public void setAreaatuacao_vendas(String areaatuacao_vendas) {
        this.areaatuacao_vendas = areaatuacao_vendas;
    }

    public String getAreaatuacao_financeiro() {
        return areaatuacao_financeiro;
    }

    public void setAreaatuacao_financeiro(String areaatuacao_financeiro) {
        this.areaatuacao_financeiro = areaatuacao_financeiro;
    }

    public String getAreaatuacao_logistica() {
        return areaatuacao_logistica;
    }

    public void setAreaatuacao_logistica(String areaatuacao_logistica) {
        this.areaatuacao_logistica = areaatuacao_logistica;
    }

    public String getAreaatuacao_expedicao() {
        return areaatuacao_expedicao;
    }

    public void setAreaatuacao_expedicao(String areaatuacao_expedicao) {
        this.areaatuacao_expedicao = areaatuacao_expedicao;
    }

    public String getAreaatuacao_rh() {
        return areaatuacao_rh;
    }

    public void setAreaatuacao_rh(String areaatuacao_rh) {
        this.areaatuacao_rh = areaatuacao_rh;
    }

    public String getAreaatuacao_fiscal() {
        return areaatuacao_fiscal;
    }

    public void setAreaatuacao_fiscal(String areaatuacao_fiscal) {
        this.areaatuacao_fiscal = areaatuacao_fiscal;
    }

    public String getAreaatuacao_contabil() {
        return areaatuacao_contabil;
    }

    public void setAreaatuacao_contabil(String areaatuacao_contabil) {
        this.areaatuacao_contabil = areaatuacao_contabil;
    }

    public String getAreaatuacao_outros() {
        return areaatuacao_outros;
    }

    public void setAreaatuacao_outros(String areaatuacao_outros) {
        this.areaatuacao_outros = areaatuacao_outros;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Funcionario other = (Funcionario) obj;
        if (matricula == null) {
            if (other.matricula != null)
                return false;
        } else if (!matricula.equals(other.matricula))
            return false;
        return true;
    }

}