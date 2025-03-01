package com.dbserver.desafio_tecnico.apitests.payloads;

import com.dbserver.desafio_tecnico.apitests.payloads.dependecy.ICriacaoProdutoPayload;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.main.cli.Main;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.IOException;
import java.net.URL;

@Component
public class CriacaoProdutoPayload implements ICriacaoProdutoPayload {
    @Override
    public JsonNode getData() throws IOException {
        URL resource = Main.class.getClassLoader().getResource("CriarProdutoDataModel.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode readFile = objectMapper.readTree(
                new File(resource.getFile())
        );
        return readFile;
    }
}
