package com.dbserver.desafio_tecnico.apitests.payloads.dependecy;

import io.restassured.response.Response;

public interface ICriacaoTokenRequest {
    Response criarToken(String username, String password);
}
