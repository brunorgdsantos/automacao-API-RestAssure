package com.dbserver.desafio_tecnico.apitests.payloads;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.main.cli.Main;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;
import java.io.File;
import java.net.URL;
import java.io.IOException;

@Component
public class UsuarioAutenticacaoPayload {

    public String getCampo(String campo) throws IOException {
        URL resource = Main.class.getClassLoader().getResource("UsuarioAutenticacaoModel.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode readFile = objectMapper.readTree(
                new File(resource.getFile())
        );
        return new Gson().toJson(readFile.get(campo));
    }
}
