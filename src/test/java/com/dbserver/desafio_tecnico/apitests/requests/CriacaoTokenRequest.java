package com.dbserver.desafio_tecnico.apitests.requests;

import com.dbserver.desafio_tecnico.apitests.payloads.dependecy.ILoginCriacaoTokenPayload;
import com.dbserver.desafio_tecnico.apitests.payloads.dependecy.IUrlsUtils;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static io.restassured.RestAssured.given;

@Component
public class CriacaoTokenRequest {

    @Autowired
    IUrlsUtils util;

    @Autowired
    ILoginCriacaoTokenPayload login;

    @Step("Criação de token para Autenticação")
    public Response criarToken(String username, String password){
        return given()
                .header("Content-Type", "application/json")
                .body(login.convertToJson(username, password))
                .when()
                .post(util.getAuthUrl());
    }
}
