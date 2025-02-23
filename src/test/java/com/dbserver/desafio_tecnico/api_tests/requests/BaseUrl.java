package com.dbserver.desafio_tecnico.api_tests.requests;

import com.dbserver.desafio_tecnico.utils.Utils;
import io.restassured.RestAssured;
import jdk.jshell.execution.Util;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
public class BaseUrl {

    @BeforeAll
    public static void setUp() {
        log.info("Iniciando os testes de API.");
        RestAssured.baseURI = Utils.baseUrl();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
