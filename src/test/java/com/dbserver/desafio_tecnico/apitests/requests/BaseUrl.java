package com.dbserver.desafio_tecnico.apitests.requests;

import com.dbserver.desafio_tecnico.utils.UrlsUtils;
import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;

@Slf4j
public class BaseUrl {

    @BeforeAll
    public static void setUp() {
        log.info("Iniciando Testes Api Gerenciador de Produtos Eletrônicos.");
        RestAssured.baseURI = UrlsUtils.baseUrl();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
