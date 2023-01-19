package com.ajel.controller.payloads;

import java.math.BigDecimal;

public class LoginPayload {

    private String usuario;
    private String senha;
    private String matricula;
    private BigDecimal codsetor;
    

    @Override
    public String toString() {
        return "UsuarioPayload{" +
                "usuario='" + usuario + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }

    
    public String getMatricula() {
        return matricula;
    }


    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public BigDecimal getCodsetor() {
        return codsetor;
    }


    public void setCodsetor(BigDecimal codsetor) {
        this.codsetor = codsetor;
    }
    
}
