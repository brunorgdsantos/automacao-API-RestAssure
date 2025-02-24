package com.dbserver.desafio_tecnico.apitests.requests;

import com.dbserver.desafio_tecnico.utils.UrlsUtils;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;

@Component
public class ProdutosAutenticacaoRequest {

    @Autowired
    UrlsUtils util;

    @Autowired
    CriacaoTokenRequest request;

    @Step("Buscar produtos com autenticação")
    public Response produtosAutenticacao(){
        String accessToken = request.criarToken("emilys", "emilyspass")
                .jsonPath().getString("accessToken");
        return given()
                .header("Content-Type", "application/json")
                .header("Authorization", String.format("Bearer %s", accessToken))
                .when()
                .get(util.getAUTH_PROD_URL());
    }

    public Response produtosAutenticacaoTokenExpired(){
        return given()
                .header("Content-Type", "application/json")
                .header("Authorization", String.format("Bearer %s", util.getUNAUTHORIZED_TOKEN()))
                .when()
                .get(util.getAUTH_PROD_URL());
    }

    public Response produtosAutenticacaoTokenInvalido(){
        return given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer invalidoTokenTeste")
                .when()
                .get(util.getAUTH_PROD_URL());
    }

    public Response produtosAutenticacaoTokenNaoEnviado(){
        return given()
                .header("Content-Type", "application/json")
                .header("Authorization", "")
                .when()
                .get(util.getAUTH_PROD_URL());
    }
}
