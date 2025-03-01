package com.dbserver.desafio_tecnico.apitests.requests;

import com.dbserver.desafio_tecnico.apitests.payloads.dependecy.IUrlsUtils;
import com.dbserver.desafio_tecnico.utils.UrlsUtils;
import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BaseUrl {

    @Autowired
    IUrlsUtils util;

    @BeforeAll
    public static void setUp() {
        log.info("Iniciando Testes Api Gerenciador de Produtos Eletrônicos.");
        RestAssured.baseURI = UrlsUtils.getBaseUrl();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
