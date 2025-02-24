package com.dbserver.desafio_tecnico.apitests.tests;

import com.dbserver.desafio_tecnico.apitests.requests.BaseUrl;
import com.dbserver.desafio_tecnico.apitests.requests.CriacaoTokenRequest;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.Matchers.*;

@SpringBootTest
public class CriacaoTokenTest extends BaseUrl {

    @Autowired
    CriacaoTokenRequest tokenRequest;

    @Test
    @Tag("ApiTests")
    @Description("Deve criar um token para Autenticação (POST /auth/login)")
    public void deveCriarTokenAutenticacao() throws Exception{
        tokenRequest.criarToken("emilys", "emilyspass")
                .then()
                .body("accessToken", not(empty()))
                .body("refreshToken", not(empty()))
                .statusCode(not(HttpStatus.SC_CREATED));
    }

    @Test
    @Tag("ApiTests")
    @Description("Deve validar login para usuário válido")
    public void deveRealizarLogin() throws Exception{
        tokenRequest.criarToken("emilys", "emilyspass")
                .then()
                .body("firstName", containsString("Emily"))
                .body("lastName", containsString("Johnson"))
                .statusCode(not(HttpStatus.SC_CREATED));
    }

    @Test
    @Tag("ApiTests")
    @Description("Exceção: Deve retornar status code 200 ao criar um token")
    public void deveRetornarStatus200() throws Exception{
        tokenRequest.criarToken("emilys", "emilyspass")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    @Tag("ApiTests")
    @Description("Exceção: Deve retorar status code 400 para login com usuário inválido")
    public void naoDeveRealizarLoginUsuarioInvalido() throws Exception{
        tokenRequest.criarToken("teste", "teste")
                .then()
                .body("message", containsString("Invalid credentials"))
                .body("accessToken", nullValue())
                .body("refreshToken", nullValue())
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    @Tag("ApiTests")
    @Description("Exceção: Deve retorar status code 400 para login apenas com username válido")
    public void naoDeveRealizarLoginPasswordInvalido() throws Exception{
        tokenRequest.criarToken("emilys", "teste")
                .then()
                .body("message", containsString("Invalid credentials"))
                .body("accessToken", nullValue())
                .body("refreshToken", nullValue())
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }
}
