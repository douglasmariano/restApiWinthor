package com.ajel.controller.payloads;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import com.ajel.jwt.Role;
import com.ajel.jwt.UserPrincipal;

public class UsuarioPayload implements Authentication {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String username;
    private String email;
    private BigDecimal codsetor;
    private boolean isAuthenticated;

    public UsuarioPayload(Long id, String name, String username, String email, BigDecimal codsetor, boolean isAuthenticated) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.codsetor = codsetor;
        this.isAuthenticated = isAuthenticated;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(Role.values());
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return new UserPrincipal(id, name, username, email, codsetor, null, getAuthorities());
    }

    @Override
    public boolean isAuthenticated() {
        return isAuthenticated;
    }
    
    

    public BigDecimal getCodsetor() {
        return codsetor;
    }

    public void setCodsetor(BigDecimal codsetor) {
        this.codsetor = codsetor;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {
        this.isAuthenticated = b;
    }

    @Override
    public String getName() {
        return name;
    }
}
