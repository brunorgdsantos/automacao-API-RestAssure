package com.dbserver.desafio_tecnico.apitests.requests;

import com.dbserver.desafio_tecnico.apitests.payloads.dependecy.ICriacaoProdutoPayload;
import com.dbserver.desafio_tecnico.apitests.payloads.dependecy.IUrlsUtils;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.IOException;
import static io.restassured.RestAssured.given;

@Component
public class CriacaoProdutosRequest {

    @Autowired
    IUrlsUtils util;

    @Autowired
    ICriacaoProdutoPayload produtoPayload;

    @Step("Criação de produto")
    public Response criarProdutos() throws IOException {
        return given()
                .header("Content-Type", "application/json")
                .body(produtoPayload.getData())
                .when()
                .post(util.getProdUrl());
    }

    @Step("Criação de produto com título")
    public Response criarProdutosComTitulo() throws IOException {
        return given()
                .header("Content-Type", "application/json")
                .body("{\"title\":\"Book\"}")
                .when()
                .post(util.getProdUrl());
    }
}
