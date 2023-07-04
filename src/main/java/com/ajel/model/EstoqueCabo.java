package com.ajel.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



@Entity
@Table(name = "ajel_cabo")
public class EstoqueCabo {
    
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CODCABO")
    @SequenceGenerator(name="SEQ_CODCABO", sequenceName="SEQ_CODCABO",allocationSize=1)
    @Column(name = "codcabo" ) 
    private Long codcabo;  
    
    @Column(name = "codprod_pcprodut" ) 
    private Long codprod_pcprodut;  
       
    @Column(name = "codprod_pcest" ) 
    private Long codprod_pcest;
    
    @Column(name = "codfilial_pcest" ) 
    private String codfilial_pcest;
    
    @MapsId(value="codprod")
    @ManyToOne
    @JoinColumn(name="codprod_pcprodut",referencedColumnName = "codprod")
    private Produto produto;
    
    @MapsId(value = "estoquePK")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "codprod_pcest", referencedColumnName = "codprod"),
            @JoinColumn(name = "codfilial_pcest", referencedColumnName = "codfilial")
    })
    private Estoque estoquePK;
    
    @MapsId(value="codmarca")
    @ManyToOne(optional=true )
    @JoinColumn(name="codmarca",referencedColumnName = "codmarca")
    @Fetch(FetchMode.JOIN) 
    private Marca marca;
    
    @MapsId(value="pcempr")
    @ManyToOne
    @JoinColumn(name="matricula",referencedColumnName = "matricula")
    private Funcionario funcionario;
    
    @MapsId(value="codfornec")
    @ManyToOne
    @JoinColumn(name="codfornec",referencedColumnName = "codfornec")
    private Transportadora fornecedor;

    @Column(name = "codmarca" ) 
    private Long codmarca;
    
    @Column(name = "codfornec" ) 
    private Long codfornec;
    
    @Column(name = "matricula" ) 
    private Long matricula;
    
    @Column(name = "tipoendereco" ) 
    private String tipoendereco;
        
    @Column(name = "dtinclusao" ) 
    private Date dtinclusao;

    @Column(name = "dtexclusao" ) 
    private Date dtexclusao;  
 
    @Column(name = "status" ) 
    private String status;

    @Column(name = "obs" ) 
    private String obs; 

    @Column(name = "qtgerencial" ) 
    private Long qtgerencial;
    
    @Column(name = "qt" ) 
    private Long qt;

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


    public EstoqueCabo(Long codcabo, Long codprod_pcprodut, Long codprod_pcest, String codfilial_pcest, Produto produto,
            Estoque estoquePK, Marca marca, Funcionario funcionario, Transportadora fornecedor, Long codmarca, Long codfornec,
            Long matricula, String tipoendereco, Date dtinclusao, Date dtexclusao, String status, String obs,
            Long qtgerencial, Long qt, Long numero, Long modulo, Long rua, Long apto) {
        super();
        this.codcabo = codcabo;
        this.codprod_pcprodut = codprod_pcprodut;
        this.codprod_pcest = codprod_pcest;
        this.codfilial_pcest = codfilial_pcest;
        this.produto = produto;
        this.estoquePK = estoquePK;
        this.marca = marca;
        this.funcionario = funcionario;
        this.fornecedor = fornecedor;
        this.codmarca = codmarca;
        this.codfornec = codfornec;
        this.matricula = matricula;
        this.tipoendereco = tipoendereco;
        this.dtinclusao = dtinclusao;
        this.dtexclusao = dtexclusao;
        this.status = status;
        this.obs = obs;
        this.qtgerencial = qtgerencial;
        this.qt = qt;
        this.numero = numero;
        this.modulo = modulo;
        this.rua = rua;
        this.apto = apto;
    }


    public Long getCodcabo() {
        return codcabo;
    }


    public void setCodcabo(Long codcabo) {
        this.codcabo = codcabo;
    }


    public Long getCodprod_pcprodut() {
        return codprod_pcprodut;
    }


    public void setCodprod_pcprodut(Long codprod_pcprodut) {
        this.codprod_pcprodut = codprod_pcprodut;
    }


    public Long getCodprod_pcest() {
        return codprod_pcest;
    }


    public void setCodprod_pcest(Long codprod_pcest) {
        this.codprod_pcest = codprod_pcest;
    }


    public String getCodfilial_pcest() {
        return codfilial_pcest;
    }


    public void setCodfilial_pcest(String codfilial_pcest) {
        this.codfilial_pcest = codfilial_pcest;
    }


    public Produto getProduto() {
        return produto;
    }


    public void setProduto(Produto produto) {
        this.produto = produto;
    }


    public Estoque getEstoquePK() {
        return estoquePK;
    }


    public void setEstoquePK(Estoque estoquePK) {
        this.estoquePK = estoquePK;
    }


    public Marca getMarca() {
        return marca;
    }


    public void setMarca(Marca marca) {
        this.marca = marca;
    }


    public Funcionario getFuncionario() {
        return funcionario;
    }


    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }


    public Transportadora getFornecedor() {
        return fornecedor;
    }


    public void setFornecedor(Transportadora fornecedor) {
        this.fornecedor = fornecedor;
    }


    public Long getCodmarca() {
        return codmarca;
    }


    public void setCodmarca(Long codmarca) {
        this.codmarca = codmarca;
    }


    public Long getCodfornec() {
        return codfornec;
    }


    public void setCodfornec(Long codfornec) {
        this.codfornec = codfornec;
    }


    public Long getMatricula() {
        return matricula;
    }


    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }


    public String getTipoendereco() {
        return tipoendereco;
    }


    public void setTipoendereco(String tipoendereco) {
        this.tipoendereco = tipoendereco;
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


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }


    public String getObs() {
        return obs;
    }


    public void setObs(String obs) {
        this.obs = obs;
    }


    public Long getQtgerencial() {
        return qtgerencial;
    }


    public void setQtgerencial(Long qtgerencial) {
        this.qtgerencial = qtgerencial;
    }


    public Long getQt() {
        return qt;
    }


    public void setQt(Long qt) {
        this.qt = qt;
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
