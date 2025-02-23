package com.dbserver.desafio_tecnico.api_tests.requests;

import com.dbserver.desafio_tecnico.utils.Utils;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static io.restassured.RestAssured.given;

@Component
public class CriacaoTokenRequest {

    @Autowired
    Utils util;

    @Step("Criação de token para Autenticação")
    public Response criarToken(){
        return given()
                .header("Content-Type", "application/json")
                .body("{ \"username\": \"emilys\", \"password\": \"emilyspass\" }")
                .when()
                .post(util.getAUTH_URL());
    }
}
