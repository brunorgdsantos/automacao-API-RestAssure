package com.dbserver.desafio_tecnico.api_tests.tests;

import com.dbserver.desafio_tecnico.api_tests.requests.BaseUrl;
import com.dbserver.desafio_tecnico.api_tests.requests.StatusAplicacaoRequest;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static org.junit.matchers.JUnitMatchers.containsString;

@SpringBootTest
public class StatusAplicacaoTest extends BaseUrl {

    @Autowired
    StatusAplicacaoRequest statusRequest;

    @Test
    @Tag("todos")
    @Description("Deve buscar o status da aplicação (GET /test)")
    public void deveBuscarStatusAplicacao() throws Exception{
        statusRequest.getStatus()
                .then()
                .body("status", containsString("ok"))
                .body("method", containsString("GET"))
                .statusCode(HttpStatus.SC_OK);
    }


    /*
    @Test
    public void teste(){
        given()
                .log().all()
                .when()
                .get("/test")
                .then()
                .log().all()
                .statusCode(200);
    } */
}
