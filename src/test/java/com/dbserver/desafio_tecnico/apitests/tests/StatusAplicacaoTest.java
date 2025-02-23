package com.dbserver.desafio_tecnico.apitests.tests;

import com.dbserver.desafio_tecnico.apitests.requests.BaseUrl;
import com.dbserver.desafio_tecnico.apitests.requests.StatusAplicacaoRequest;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.Matchers.containsString;

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
}
