package com.dbserver.desafio_tecnico.apitests.tests;

import com.dbserver.desafio_tecnico.apitests.requests.BaseUrl;
import com.dbserver.desafio_tecnico.apitests.requests.CriacaoProdutosRequest;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.Matchers.*;

@SpringBootTest
public class CriacaoProdutosTest extends BaseUrl {
    @Autowired
    CriacaoProdutosRequest produtosRequest;

    @Test
    @Tag("ApiTests")
    @Description("Deve criar produto (POST /products/add)")
    public void deveCriarProduto() throws Exception{
        produtosRequest.criarProdutos()
                .then()
                .statusCode(HttpStatus.SC_CREATED);
    }

    @Test
    @Tag("ApiTests")
    @Description("Deve validar características do produto")
    public void deveValidarProduto() throws Exception{
        produtosRequest.criarProdutos()
                .then()
                .body("title", containsString("Perfume Oil"))
                .body("price", equalTo(13))
                .body("stock", equalTo(65))
                .body("rating", equalTo(4.26F))
                .body("thumbnail", containsString("https://i.dummyjson.com/data/products/11/thumnail.jpg"))
                .body("description", containsString("Mega Discount, Impression of A..."))
                .body("brand", containsString("Impression of Acqua Di Gio"))
                .body("category", containsString("fragrances"))
                .statusCode(HttpStatus.SC_CREATED);
    }

    @Test
    @Tag("ApiTests")
    @Description("Deve criar produto com título")
    public void deveCriarProdutoComTitulo() throws Exception{
        produtosRequest.criarProdutosComTitulo()
                .then()
                .body("title", containsString("Book"))
                .statusCode(HttpStatus.SC_CREATED);
    }

    @Test
    @Tag("ApiTests")
    @Description("Exceção: Deve validar diferença no id do produto")
    public void deveValidarDiferencaIdProduto() throws Exception{
        produtosRequest.criarProdutos()
                .then()
                .body("id", not(equalTo(101)))
                .statusCode(HttpStatus.SC_CREATED);
    }
}
