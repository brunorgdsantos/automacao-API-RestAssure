package com.dbserver.desafio_tecnico.apitests.tests;

import com.dbserver.desafio_tecnico.apitests.requests.BaseUrl;
import com.dbserver.desafio_tecnico.apitests.requests.ProdutosAutenticacaoRequest;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.Matchers.containsString;

@SpringBootTest
public class ProdutosAutenticacaoTest extends BaseUrl{

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

    @Test
    @Tag("todos")
    @Description("Exceção: Deve retornar Status Code 401 Unauthorized: Token Expired quando token inválido")
    public void naoDeveBuscarProdutosAutenticacaoTokenExpirado() throws Exception{
        produtosRequest.produtosAutenticacaoTokenExpired()
                .then()
                .body("message", containsString("Token Expired!"))
                .statusCode(HttpStatus.SC_UNAUTHORIZED);
    }

    @Test
    @Tag("todos")
    @Description("Exceção: Deve retornar Status Code 401 Unauthorized: Invalid/Expired Token quando token inválido")
    public void naoDeveBuscarProdutosAutenticacaoTokenInvalido() throws Exception{
        produtosRequest.produtosAutenticacaoTokenInvalido()
                .then()
                .body("message", containsString("Invalid/Expired Token!"))
                .statusCode(HttpStatus.SC_UNAUTHORIZED);
    }
    /*
    @Test
    @Tag("todos")
    @Description("Exceção: Deve retornar Status Code 403 Forbidden quando credencial inválida")
    public void naoDeveBuscarProdutosAutenticacaoCredencialInvalida() throws Exception{
        produtosRequest.produtosAutenticacaoCredencialInvalida()
                .then()
                .statusCode(HttpStatus.SC_FORBIDDEN);
    } */
}
