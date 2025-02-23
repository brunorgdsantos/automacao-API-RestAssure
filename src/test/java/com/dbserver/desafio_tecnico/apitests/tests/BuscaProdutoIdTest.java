package com.dbserver.desafio_tecnico.apitests.tests;

import com.dbserver.desafio_tecnico.apitests.requests.BaseUrl;
import com.dbserver.desafio_tecnico.apitests.requests.BuscarProdutoIdRequest;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.Matchers.containsString;

@SpringBootTest
public class BuscaProdutoIdTest extends BaseUrl {
    @Autowired
    BuscarProdutoIdRequest produtosIdRequest;

    @Test
    @Tag("todos")
    @Description("Deve buscar apenas um produto por id (POST /products/{id})")
    public void deveBuscarProdutoId() throws Exception{
        produtosIdRequest.buscaProdutosId(1)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    @Tag("todos")
    @Description("Exceção: Deve retornar Status Code 404 Not found para Id não cadastrado")
    public void deveRetornarErroProdutoIdNaoCadastrado() throws Exception{
        produtosIdRequest.buscaProdutosId(255)
                .then()
                .body("message", containsString("Product with id '255' not found"))
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }
}
