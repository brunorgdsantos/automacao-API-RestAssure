package com.dbserver.desafio_tecnico.api_tests.requests;

import com.dbserver.desafio_tecnico.utils.Utils;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static io.restassured.RestAssured.given;

@Component
public class StatusAplicacaoRequest {

    @Autowired
    Utils util;

    @Step("Buscar o status da aplicação")
    public Response getStatus(){
        return given()
                .when()
                .get(util.getTEST_URL());

    }

}
