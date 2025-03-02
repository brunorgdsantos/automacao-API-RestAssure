package com.dbserver.desafio_tecnico.apitests.payloads.dependecy;

public interface ILoginCriacaoTokenPayload {
    String convertToJson(String username, String password);
}
