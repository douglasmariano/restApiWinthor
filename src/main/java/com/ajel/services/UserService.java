package com.ajel.services;

import com.ajel.controller.payloads.UsuarioPayload;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public boolean isUsuarioValido(UsuarioPayload usuario) {
        System.out.println(usuario);
        return true;
    }
}
