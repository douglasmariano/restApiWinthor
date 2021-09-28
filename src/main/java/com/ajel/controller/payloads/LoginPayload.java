package com.ajel.controller.payloads;

public class LoginPayload {

    private String usuario;
    private String senha;

    @Override
    public String toString() {
        return "UsuarioPayload{" +
                "usuario='" + usuario + '\'' +
                ", senha='" + senha + '\'' +
                '}';
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
}
