package com.dbserver.desafio_tecnico.apitests.requests;

import com.dbserver.desafio_tecnico.apitests.payloads.dependecy.IUrlsUtils;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static io.restassured.RestAssured.given;

@Component
public class BuscarProdutoIdRequest {

    @Autowired
    IUrlsUtils util;

    @Step("Buscar apenas um produto por id")
    public Response buscaProdutosId(int id){
        return given()
                .when()
                .get(util.getBuscaProdIdUrl()+id);
    }
}
