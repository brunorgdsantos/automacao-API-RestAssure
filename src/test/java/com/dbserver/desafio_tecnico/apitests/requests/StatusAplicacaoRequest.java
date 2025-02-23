package com.dbserver.desafio_tecnico.apitests.requests;

import com.dbserver.desafio_tecnico.utils.UrlsUtils;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static io.restassured.RestAssured.given;

@Component
public class StatusAplicacaoRequest {

    @Autowired
    UrlsUtils util;

    @Step("Buscar o status da aplicação")
    public Response getStatus(){
        return given()
                .when()
                .get(util.getTEST_URL());

    }

}
