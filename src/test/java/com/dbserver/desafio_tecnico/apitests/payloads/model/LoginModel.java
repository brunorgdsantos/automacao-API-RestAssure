package com.dbserver.desafio_tecnico.apitests.payloads.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginModel {
    private String username;
    private String password;
}
