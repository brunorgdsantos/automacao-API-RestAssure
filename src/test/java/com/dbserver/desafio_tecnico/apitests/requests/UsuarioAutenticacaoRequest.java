package com.dbserver.desafio_tecnico.apitests.requests;

import com.dbserver.desafio_tecnico.apitests.payloads.dependecy.IUrlsUtils;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static io.restassured.RestAssured.given;

@Component
public class UsuarioAutenticacaoRequest {

    @Autowired
    IUrlsUtils util;

    @Step("Buscar usuário para autenticação")
    public Response getUsuario(){
        return given()
                .when()
                .get(util.getUserUrl());
    }
}
