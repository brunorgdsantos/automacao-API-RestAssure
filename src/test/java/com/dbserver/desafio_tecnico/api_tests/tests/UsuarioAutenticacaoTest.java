package com.dbserver.desafio_tecnico.api_tests.tests;

import com.dbserver.desafio_tecnico.api_tests.requests.UsuarioAutenticacaoRequest;
import com.dbserver.desafio_tecnico.api_tests.requests.BaseUrl;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsuarioAutenticacaoTest extends BaseUrl {

    @Autowired
    UsuarioAutenticacaoRequest usuarioAutenticacaoRequest;

    @Test
    @Tag("todos")
    @Description("Deve buscar usuário para autenticação (GET /users)")
    public void deveBuscarUsuarioAutenticacao() throws Exception{
        usuarioAutenticacaoRequest.getUsuario()
                .then()
                //.body("status", containsString("ok"))
                //.body("method", containsString("GET"))
                .statusCode(HttpStatus.SC_OK);
    }
}
