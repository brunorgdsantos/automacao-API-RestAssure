package com.dbserver.desafio_tecnico.apitests.requests;

import com.dbserver.desafio_tecnico.apitests.payloads.LoginCriacaoTokenPayload;
import com.dbserver.desafio_tecnico.utils.UrlsUtils;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static io.restassured.RestAssured.given;

@Component
public class CriacaoTokenRequest {

    @Autowired
    UrlsUtils util;

    @Step("Criação de token para Autenticação")
    public Response criarToken(String username, String password){
        return given()
                .header("Content-Type", "application/json")
                .body(LoginCriacaoTokenPayload.convertToJson(username, password))
                .when()
                .post(util.getAUTH_URL());
    }
}
