package com.ajel.controller;

import com.ajel.controller.payloads.LoginPayload;
import com.ajel.exception.ErrorDetails;
import com.ajel.services.UserService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/api/v1/auth")
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginPayload usuario) {
        try {
            List<String> roles = Arrays.asList("ROLE_ADMIN", "ROLE_FINANCEIRO");
            String token = userService.getToken(usuario);
            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("roles", roles);
            return ResponseEntity.ok(response);
        } catch (Exception e) {            
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorDetails(new Date(), e.getMessage(), null));
            
        }
    }
}
