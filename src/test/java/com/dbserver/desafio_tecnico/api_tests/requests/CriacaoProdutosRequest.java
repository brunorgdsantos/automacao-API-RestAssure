package com.dbserver.desafio_tecnico.api_tests.requests;

import com.dbserver.desafio_tecnico.utils.Utils;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;

@Component
public class CriacaoProdutosRequest {
    @Autowired
    Utils util;

    @Step("Criação de produto")
    public Response criarProdutos(){
        return given()
                .header("Content-Type", "application/json")
                .body("{ \"title\": \"Perfume Oil\", \"description\": \"Mega Discount, Impression of A...\", \"price\": \"13\", \"discountPercentage\": \"8.4\", \"rating\": \"4.26\", \"stock\": \"65\", \"brand\": \"Impression of Acqua Di Gio\", \"category\": \"fragrances\", \"thumbnail\": \"https://i.dummyjson.com/data/products/11/thumnail.jpg\"}")
                .when()
                .post(util.getPROD_URL());
    }
}
