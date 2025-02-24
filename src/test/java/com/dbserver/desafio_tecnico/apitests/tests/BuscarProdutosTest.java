package com.dbserver.desafio_tecnico.apitests.tests;

import com.dbserver.desafio_tecnico.apitests.requests.BaseUrl;
import com.dbserver.desafio_tecnico.apitests.requests.BuscarProdutosRequest;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.Matchers.*;

@SpringBootTest
public class BuscarProdutosTest extends BaseUrl {

    @Autowired
    BuscarProdutosRequest produtosRequest;

    @Test
    @Tag("ApiTests")
    @Description("Deve buscar todos os produtos (GET /products)")
    public void deveBuscarProdutos() throws Exception{
        produtosRequest.buscaProdutos()
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    @Tag("ApiTests")
    @Description("Deve verificar campos do produto Id:30")
    public void deveVerificarProdutos() throws Exception{
        produtosRequest.buscaProdutos()
                .then()
                .body("products[29].id", equalTo(30))
                .body("products[29].title", containsString("Kiwi"))
                .body("products[29].tags[0]", containsString("fruits"))
                .body("products[29].reviews[1].reviewerName", containsString("Dylan Wells"))
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    @Tag("ApiTests")
    @Description("Deve validar estoque total de produtos")
    public void deveValidarTotalProdutos() throws Exception{
        produtosRequest.buscaProdutos()
                .then()
                .body("total", equalTo(194))
                .body("skip", equalTo(0))
                .body("limit", equalTo(30))
                .statusCode(HttpStatus.SC_OK);
    }
}
