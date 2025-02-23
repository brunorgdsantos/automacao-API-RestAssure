package com.dbserver.desafio_tecnico.api_tests.tests;

import com.dbserver.desafio_tecnico.api_tests.requests.BaseUrl;
import com.dbserver.desafio_tecnico.api_tests.requests.BuscarProdutosRequest;
import com.dbserver.desafio_tecnico.api_tests.requests.CriacaoProdutosRequest;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BuscarProdutosTest extends BaseUrl {
    @Autowired
    BuscarProdutosRequest produtosRequest;

    @Test
    @Tag("todos")
    @Description("Deve criar produto (POST /products/add)")
    public void deveCriarProduto() throws Exception{
        produtosRequest.buscaProdutos()
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
