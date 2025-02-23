package com.dbserver.desafio_tecnico.apitests.payloads.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
public class LoginModel {
    private String username;
    private String password;
}
