package com.dbserver.desafio_tecnico.apitests.requests;

import com.dbserver.desafio_tecnico.apitests.payloads.dependecy.ICriacaoTokenRequest;
import com.dbserver.desafio_tecnico.apitests.payloads.dependecy.IUrlsUtils;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;

@Component
public class ProdutosAutenticacaoRequest {

    @Autowired
    IUrlsUtils util;

    @Autowired
    ICriacaoTokenRequest request;

    @Step("Buscar produtos com autenticação")
    public Response produtosAutenticacao(){
        String accessToken = request.criarToken("emilys", "emilyspass")
                .jsonPath().getString("accessToken");
        return given()
                .header("Content-Type", "application/json")
                .header("Authorization", String.format("Bearer %s", accessToken))
                .when()
                .get(util.getAuthProdUrl());
    }

    @Step("Buscar produtos token expirado")
    public Response produtosAutenticacaoTokenExpired(){
        return given()
                .header("Content-Type", "application/json")
                .header("Authorization", String.format("Bearer %s", util.getUnauthorizedToken()))
                .when()
                .get(util.getAuthProdUrl());
    }

    @Step("Buscar produtos token inválido")
    public Response produtosAutenticacaoTokenInvalido(){
        return given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer invalidoTokenTeste")
                .when()
                .get(util.getAuthProdUrl());
    }

    @Step("Buscar produtos token não enviado")
    public Response produtosAutenticacaoTokenNaoEnviado(){
        return given()
                .header("Content-Type", "application/json")
                .header("Authorization", "")
                .when()
                .get(util.getAuthProdUrl());
    }
}
