package com.ajel.jwt;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN,
    ESTOQUE,
    ADMINISTRATIVO,
    EXPEDICAO,
    RECEPCAO;
   
    

    @Override
    public String getAuthority() {
        return name();
    }
}
