package com.dbserver.desafio_tecnico.apitests.requests;

import com.dbserver.desafio_tecnico.utils.UrlsUtils;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static io.restassured.RestAssured.given;

@Component
public class UsuarioAutenticacaoRequest {

    @Autowired
    UrlsUtils util;

    @Step("Buscar usuário para autenticação")
    public Response getUsuario(){
        return given()
                .when()
                .get(util.getUSER_URL());
    }
}
