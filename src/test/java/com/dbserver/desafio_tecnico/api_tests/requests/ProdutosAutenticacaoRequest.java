package com.dbserver.desafio_tecnico.api_tests.requests;

import com.dbserver.desafio_tecnico.utils.Utils;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;

@Component
public class ProdutosAutenticacaoRequest {

    @Autowired
    Utils util;

    @Step("Buscar produtos com autenticação")
    public Response produtosAutenticacao(){
        return given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJlbWlseXMiLCJlbWFpbCI6ImVtaWx5LmpvaG5zb25AeC5kdW1teWpzb24uY29tIiwiZmlyc3ROYW1lIjoiRW1pbHkiLCJsYXN0TmFtZSI6IkpvaG5zb24iLCJnZW5kZXIiOiJmZW1hbGUiLCJpbWFnZSI6Imh0dHBzOi8vZHVtbXlqc29uLmNvbS9pY29uL2VtaWx5cy8xMjgiLCJpYXQiOjE3NDAyNjc1MzQsImV4cCI6MTc0MDI3MTEzNH0.QKfmHERRVDzNrYh49sF87cr7NIDX1ENcZrHi41O1iqQ")
                .when()
                .get(util.getAUTH_PROD_URL());
    }
}
