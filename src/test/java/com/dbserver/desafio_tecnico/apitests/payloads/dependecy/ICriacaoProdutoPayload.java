package com.dbserver.desafio_tecnico.apitests.payloads.dependecy;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public interface ICriacaoProdutoPayload {
    JsonNode getData() throws IOException;
}
