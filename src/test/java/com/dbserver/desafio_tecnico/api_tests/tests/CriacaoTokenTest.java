package com.dbserver.desafio_tecnico.api_tests.tests;

import com.dbserver.desafio_tecnico.api_tests.requests.BaseUrl;
import com.dbserver.desafio_tecnico.api_tests.requests.CriacaoTokenRequest;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CriacaoTokenTest extends BaseUrl {

    @Autowired
    CriacaoTokenRequest tokenRequest;

    @Test
    @Tag("todos")
    @Description("Deve criar um token para Autenticação (POST /auth/login)")
    public void deveCriarTokenAutenticacao() throws Exception{
        tokenRequest.criarToken()
                .then()
                .statusCode(HttpStatus.SC_CREATED);
    }
}
