package com.dbserver.desafio_tecnico.apitests.requests;

import com.dbserver.desafio_tecnico.utils.UrlsUtils;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static io.restassured.RestAssured.given;

@Component
public class BuscarProdutosRequest {
    @Autowired
    UrlsUtils util;

    @Step("Buscar todos os produtos")
    public Response buscaProdutos(){
        return given()
                .when()
                .get(util.getBUSCA_PROD_URL());
    }
}
