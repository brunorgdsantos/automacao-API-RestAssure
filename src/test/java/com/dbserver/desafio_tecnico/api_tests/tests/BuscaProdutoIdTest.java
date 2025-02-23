package com.dbserver.desafio_tecnico.api_tests.tests;

import com.dbserver.desafio_tecnico.api_tests.requests.BaseUrl;
import com.dbserver.desafio_tecnico.api_tests.requests.BuscarProdutoIdRequest;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BuscaProdutoIdTest extends BaseUrl {
    @Autowired
    BuscarProdutoIdRequest produtosIdRequest;

    @Test
    @Tag("todos")
    @Description("Deve criar produto (POST /products/add)")
    public void deveCriarProduto() throws Exception{
        produtosIdRequest.buscaProdutosId()
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
