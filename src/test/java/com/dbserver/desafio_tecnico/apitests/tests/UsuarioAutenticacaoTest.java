package com.dbserver.desafio_tecnico.apitests.tests;

import com.dbserver.desafio_tecnico.apitests.requests.UsuarioAutenticacaoRequest;
import com.dbserver.desafio_tecnico.apitests.requests.BaseUrl;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.Matchers.*;

@SpringBootTest
public class UsuarioAutenticacaoTest extends BaseUrl {

    @Autowired
    UsuarioAutenticacaoRequest usuarioAutenticacaoRequest;

    @Test
    @Tag("ApiTests")
    @Description("Deve buscar usuário para autenticação (GET /users)")
    public void deveBuscarUsuarioAutenticacao() throws Exception{
        usuarioAutenticacaoRequest.getUsuario()
                .then()
                .body("users[0].id", equalTo(1))
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    @Tag("ApiTests")
    @Description("Deve buscar company name")
    public void deveBuscarCompanyName() throws Exception{
        usuarioAutenticacaoRequest.getUsuario()
                .then()
                .body("users[20].company.name", containsString("Smitham"))
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    @Tag("ApiTests")
    @Description("Deve buscar card type")
    public void deveBuscarCardType() throws Exception{
        usuarioAutenticacaoRequest.getUsuario()
                .then()
                .body("users[3].bank.cardType", containsString("Mastercard"))
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    @Tag("ApiTests")
    @Description("Exceção: Deve buscar outro usuário para autenticação")
    public void deveBuscarOutroUsuarioAutenticacaoExcecao() throws Exception{
        usuarioAutenticacaoRequest.getUsuario()
                .then()
                .body("users[0].id", equalTo(1))
                .body("users[0].firstName", not(containsString("Terry")))
                .statusCode(HttpStatus.SC_OK);
    }
}
