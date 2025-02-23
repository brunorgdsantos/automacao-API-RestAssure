package com.dbserver.desafio_tecnico.api_tests.tests;

import com.dbserver.desafio_tecnico.api_tests.requests.BaseUrl;
import com.dbserver.desafio_tecnico.api_tests.requests.CriacaoTokenRequest;
import com.dbserver.desafio_tecnico.api_tests.requests.ProdutosAutenticacaoRequest;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProdutosAutenticacaoTest extends BaseUrl {

    @Autowired
    ProdutosAutenticacaoRequest produtosRequest;

    @Test
    @Tag("todos")
    @Description("Deve buscar produtos com autenticação (GET /auth/products)")
    public void deveBuscarProdutosAutenticacao() throws Exception{
        produtosRequest.produtosAutenticacao()
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
